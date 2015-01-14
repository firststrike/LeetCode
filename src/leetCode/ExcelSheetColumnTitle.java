package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gengyu.bi on 2014/12/23.
 */
public class ExcelSheetColumnTitle {
	public String convertToTitle(int n) {
		List<Character> letterArray = new ArrayList<Character>();
		while (n > 0) {
			int remainder = n % 26;
			n = n / 26;
			if (remainder == 0) {
				remainder = 26;
				n--;
			}
			letterArray.add((char) (remainder + 64));
		}
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = letterArray.size() - 1; i >= 0; i--) {
			stringBuilder.append(letterArray.get(i));
		}
		return stringBuilder.toString();
	}

	public static void main(String[] args) {
		ExcelSheetColumnTitle excelSheetColumnTitle = new ExcelSheetColumnTitle();
		String result = excelSheetColumnTitle.convertToTitle(53);
		System.out.println(result);
	}
}
