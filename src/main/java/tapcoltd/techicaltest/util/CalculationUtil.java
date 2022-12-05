package tapcoltd.techicaltest.util;

public class CalculationUtil {

    private CalculationUtil() {}

    public static int calculateDistanceTravelUnits(int baseFareDistance, int csvInputDistanceTraveled, int csvInputTravelUnit) {
        int distanceTravelUnits = (csvInputDistanceTraveled - baseFareDistance) / csvInputTravelUnit ;
        return distanceTravelUnits;
    }

    public static boolean applyCostPerDistanceTraveled (int csvInputDistanceTraveled, int baseFareDistance) {
        if(csvInputDistanceTraveled > baseFareDistance){
            return true;
        } else {
            return false;
        }
    }

    public static Double calculateFare(double baseFarePrice, int distanceTraveledUnit, double csvInputCostPerDistanceTraveled) {
        double calculatedFare = (distanceTraveledUnit * csvInputCostPerDistanceTraveled) + baseFarePrice;
        return calculatedFare;
    }

}
