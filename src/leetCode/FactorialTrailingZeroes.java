package leetCode;

/**
 * Created by gengyu.bi on 2014/12/30.
 */
public class FactorialTrailingZeroes {
	public int trailingZeroes(int n) {
		int i = 0;
		int count = 0;
		while (true) {
			int c = (int) (n / Math.pow(5, ++i));
			if (c == 0)
				break;
			count += c;
		}
		return count;
	}

	public static void main(String[] args) {
		FactorialTrailingZeroes factorialTrailingZeroes = new FactorialTrailingZeroes();
		int r = factorialTrailingZeroes.trailingZeroes(3);
		System.out.println(r);
	}
}
