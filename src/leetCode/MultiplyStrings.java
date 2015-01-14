package leetCode;

/**
 * Created by gengyu.bi on 2014/12/29.
 */
public class MultiplyStrings {
	public String multiply(String num1, String num2) {
		if (num1.startsWith("0") || num2.startsWith("0")) {
			return "0";
		}
		if (num1.length() < num2.length()) {
			String temp = num1;
			num1 = num2;
			num2 = temp;
		}
		char[] char1 = num1.toCharArray();
		char[] char2 = num2.toCharArray();
		int index = 0;
		StringBuilder stringBuilder = new StringBuilder();
		int carry = 0;
		while (index < char2.length) {
			int a = char1[char1.length - 1 - index] - 48;
			int b = char2[char2.length - 1 - index] - 48;
			int r = a * b + carry;
			if (r > 10) {
				r = r % 10;
				carry = r / 10;
			} else {
				carry = 0;
			}
			stringBuilder.append((char) (r + 48));
			index++;
		}
		if (carry > 0 && char1.length > char2.length) {
			stringBuilder.append((char) (char1[char1.length - 1 - index] - 48 + carry));
			index++;
		}
		while (index < char1.length) {
			stringBuilder.append(char1[char1.length - 1 - index]);
			index++;
		}
		return stringBuilder.reverse().toString();
	}

	private char[] multiplySingle(char[] charNums, char multiplicator) {
		StringBuilder stringBuilder = new StringBuilder();
		int carry = 0;
		for (int i = charNums.length - 1; i >= 0; i--) {

		}
		return null;
	}

	public static void main(String[] args) {
		MultiplyStrings multiplyStrings = new MultiplyStrings();
		String r = multiplyStrings.multiply("354", "21786");
		System.out.println(r);
	}
}
