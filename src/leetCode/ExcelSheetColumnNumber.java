package leetCode;


/**
 * Created by gengyu.bi on 2014/12/30.
 */
public class ExcelSheetColumnNumber {
	public int titleToNumber(String s) {
		if (s == null || s.equals(""))
			return 0;
		char[] chars = s.toCharArray();
		int result = 0;
		for (int i = 0; i < chars.length; i++) {
			int c = chars[chars.length - 1 - i] - 64;
			result += c * Math.pow(26, i);
		}
		return result;
	}

	public static void main(String[] args) {
		ExcelSheetColumnNumber excelSheetColumnNumber = new ExcelSheetColumnNumber();
		int r = excelSheetColumnNumber.titleToNumber("AB");
		System.out.println(r);
	}
}
