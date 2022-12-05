package tapcoltd.techicaltest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tapcoltd.techicaltest.entity.CalculatedFare;
import tapcoltd.techicaltest.entity.Driver;
import tapcoltd.techicaltest.repository.CalculatedFareRepository;
import tapcoltd.techicaltest.util.CalculationUtil;
import tapcoltd.techicaltest.util.NumberUtil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CalculatedFareService {

    @Autowired
    private CalculatedFareRepository calculatedFareRepository;

    @Autowired
    private DriverService driverService;

    public List<CalculatedFare> viewCalculatedFares(int driverId) {
        return calculatedFareRepository.getCalculatedFaresById(driverId);
    }

    public List<CalculatedFare> scanAndCalculateFare(int driverId) {

        //Delete all previously calculated fares
        calculatedFareRepository.deleteAll();

        Driver selectedDriver = driverService.getDriverById(driverId);
        List<CalculatedFare> calculatedFareList = new ArrayList<>();
        String line = "";
        String splitBy = ",";

        try
        {
            //parsing a CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/inputValues.csv"));
            while ((line = br.readLine()) != null)
            {
                String[] scannedValue = line.split(splitBy);    // use comma as separator

                //Set necessary values to entity from scanned csv
                CalculatedFare calculatedFare = new CalculatedFare();
                calculatedFare.setDriverId(selectedDriver.getDriverId());
                calculatedFare.setCsvDistanceTraveled(Integer.parseInt(scannedValue[0]));
                calculatedFare.setCsvTravelUnit(Integer.parseInt(scannedValue[1]));
                calculatedFare.setCsvCostPerDistanceTraveled(Integer.parseInt(scannedValue[2]));

                //Calculated distance travel units
                int distanceTravelUnits = CalculationUtil.calculateDistanceTravelUnits(selectedDriver.getBaseFareDistance(), calculatedFare.getCsvDistanceTraveled(), calculatedFare.getCsvTravelUnit());

                //Check if distance traveled exceeds base fare distance
                if(!CalculationUtil.applyCostPerDistanceTraveled(calculatedFare.getCsvDistanceTraveled(), selectedDriver.getBaseFareDistance())) {
                    calculatedFare.setCsvCostPerDistanceTraveled(0);
                }
                //Calculate final fare
                double finalCalculatedCost = CalculationUtil.calculateFare(selectedDriver.getBaseFarePrice(), distanceTravelUnits, calculatedFare.getCsvCostPerDistanceTraveled());
                calculatedFare.setFinalCalculatedCost(finalCalculatedCost);

                //Add the final calculated fare to the list of fares
                calculatedFareList.add(calculatedFare);
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return calculatedFareRepository.saveAll(calculatedFareList);
    }

}
