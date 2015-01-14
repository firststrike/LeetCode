package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gengyu.bi on 2014/12/19.
 */
public class LetterCombinationsOfPhoneNumber {
	public static Map<Character, char[]> phoneNum;

	static {
		phoneNum = new HashMap<Character, char[]>();
		phoneNum.put('2', "abc".toCharArray());
		phoneNum.put('3', "def".toCharArray());
		phoneNum.put('4', "ghi".toCharArray());
		phoneNum.put('5', "jkl".toCharArray());
		phoneNum.put('6', "mno".toCharArray());
		phoneNum.put('7', "pqrs".toCharArray());
		phoneNum.put('8', "tuv".toCharArray());
		phoneNum.put('9', "wxyz".toCharArray());
		phoneNum.put('0', " ".toCharArray());
	}

	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<String>();
		if (digits == null)
			return result;
		digits = digits.replace("1", "");
		if (digits.length() == 0) {
			result.add("");
			return result;
		}
		char[] charDigits = digits.toCharArray();
		StringBuilder stringBuilder = new StringBuilder();
		add(stringBuilder, 0, charDigits, result);
		return result;
	}

	private void add(StringBuilder stringBuilder, int index, char[] charDigits, List<String> result) {
		char[] chars = phoneNum.get(charDigits[index]);
		for (int i = 0; i < chars.length; i++) {
			stringBuilder.append(chars[i]);
			if (stringBuilder.length() == charDigits.length) {
				result.add(stringBuilder.toString());
			} else {
				add(stringBuilder, index + 1, charDigits, result);
			}
			stringBuilder.deleteCharAt(stringBuilder.length() - 1);
		}
	}

	public static void main(String[] args) {
		LetterCombinationsOfPhoneNumber letterCombinationsOfPhoneNumber = new LetterCombinationsOfPhoneNumber();
		System.out.println(letterCombinationsOfPhoneNumber.letterCombinations("2"));
	}
}
