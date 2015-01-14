package leetCode;

import java.text.DecimalFormat;

public class myTestCode {
	public String getByte(String input) {
		DecimalFormat decimalFormat = new DecimalFormat("#0.00");
		double size = Double.parseDouble(input);
		String unit;
		int k = 0;
		while (size > 1024 && k < 4) {
			k++;
			size = size / 1024;
		}
		switch (k) {
		case 0:
			unit = "B";
			break;
		case 1:
			unit = "KB";
			break;
		case 2:
			unit = "MB";
			break;
		case 3:
			unit = "GB";
			break;
		default:
			unit = "TB";
			break;
		}
		return decimalFormat.format(size) + unit;
	}
}
