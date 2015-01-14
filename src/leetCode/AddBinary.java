package leetCode;

/**
 * Created by gengyu.bi on 2014/12/23.
 */
public class AddBinary {
	public String addBinary(String a, String b) {
		if (a == null || a.length() == 0) {
			return b;
		}
		if (b == null || b.length() == 0) {
			return a;
		}
		StringBuilder stringBuilder = new StringBuilder();
		int carry = 0;
		char[] charA = a.toCharArray();
		char[] charB = b.toCharArray();
		for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
			int m = i >= 0 ? charA[i] - 48 : 0;
			int n = j >= 0 ? charB[j] - 48 : 0;
			int r = (m + n + carry) % 2;
			carry = (m + n + carry) / 2;
			stringBuilder.append(r);
		}
		if (carry == 1) {
			stringBuilder.append(1);
		}
		stringBuilder.reverse();
		return stringBuilder.toString();
	}

	public static void main(String[] args) {
		AddBinary addBinary = new AddBinary();
		String r = addBinary.addBinary("101", "1");
		System.out.println(r);
	}
}
