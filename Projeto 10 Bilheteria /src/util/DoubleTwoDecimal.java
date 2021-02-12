package util;

import java.text.DecimalFormat;

public class DoubleTwoDecimal {
    public static double doubleToDecimal(double value) {
       DecimalFormat fmt = new DecimalFormat("0.00");
       String[] parts = fmt.format(value).split(",");
       String solve = parts[0] + "." + parts[1];
       return Double.parseDouble(solve);
    }
}
