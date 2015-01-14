package leetCode;

/**
 * Created by gengyu.bi on 2014/12/29.
 */
public class PowXN {
	public double pow(double x, int n) {
		if (n == 0) {
			return 1;
		} else if (n > 0) {
			return mathPow(x, n);
		} else {
			return 1.0 / mathPow(x, -n);
		}
	}

	private double mathPow(double x, int n) {
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return x;
		}
		double r = mathPow(x, n / 2);
		if (n % 2 == 0) {
			return r * r;
		} else {
			return r * r + x;
		}
	}
}
