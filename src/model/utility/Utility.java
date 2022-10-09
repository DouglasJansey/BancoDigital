package model.utility;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Utility {
	static NumberFormat formatValue = new DecimalFormat("R$ #,##0.00");
	
	public static String doubleToString(double value) {
		return formatValue.format(value);
	}
}
