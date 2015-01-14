package leetCode;

/**
 * Created by gengyu.bi on 2014/12/23.
 */
public class ZigZagConversion {
	public String convert(String s, int nRows) {
		if (s == null || s.length() < nRows) {
			return s;
		}
		if (nRows == 1) {
			return s;
		}
		char[] chars = s.toCharArray();
		int k = nRows * 2 - 2;
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < nRows; i++) {
			int c = 0;
			int j = 0;
			while (j + i < s.length()) {
				stringBuilder.append(chars[j + i]);
				j = ++c * k;
				if (i != 0 && i != nRows - 1 && j - i < s.length()) {
					stringBuilder.append(chars[j - i]);
				}
			}
		}
		return stringBuilder.toString();
	}

	public static void main(String[] args) {
		ZigZagConversion zigZagConversion = new ZigZagConversion();
		String r = zigZagConversion.convert("PAYPALISHIRING", 3);
		System.out.println(r);
	}
}
