package tapcoltd.techicaltest.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tapcoltd.techicaltest.entity.Driver;
import tapcoltd.techicaltest.repository.DriverRepository;

import java.util.List;

@Service
@Transactional
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    public void addDriver(Driver driver) {
        driverRepository.save(driver);
    }

    public Driver getDriverById(Integer id) {
        return driverRepository.findById(id).get();
    }

    public void deleteDriver(Integer id) {
        driverRepository.deleteById(id);
    }


}
