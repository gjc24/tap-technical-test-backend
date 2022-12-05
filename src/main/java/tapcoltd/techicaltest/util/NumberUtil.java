package tapcoltd.techicaltest.util;

import java.text.DecimalFormat;

public class NumberUtil {

    private NumberUtil() {}

    private static DecimalFormat twoDecimalFormat = new DecimalFormat("#0.00");

    public static Double formatToTwoDecimal(Double number) {
        return Double.valueOf(twoDecimalFormat.format(number));
    }

    public static Double roundOffTwoDecimal(Double number) {
        return (double) Math.round(number * 100) / 100;
    }

}
