package leetCode;

/**
 * Created by gengyu.bi on 2015/1/7.
 */
public class DecodeWays {
	public int numDecodings(String s) {
		if (s == null || s.length() == 0)
			return 0;
		char[] chars = s.toCharArray();
		int[] count = new int[s.length() + 1];
		count[count.length - 1] = 1;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (chars[i] == '0')
				count[i] = 0;
			else
				count[i] = count[i + 1];
			if (i + 1 < s.length() && (chars[i] == '1' || chars[i] == '2' && chars[i + 1] <= '6')) {
				count[i] += count[i + 2];
			}
		}
		return count[0];
	}

	public static void main(String[] args) {
		DecodeWays decodeWays = new DecodeWays();
		int r = decodeWays.numDecodings("26");
		System.out.println(r);
	}
}
