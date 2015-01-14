package leetCode;

/**
 * Created by gengyu.bi on 2014/12/25.
 */
public class Fraction2RecurringDecimal {
	public String fractionToDecimal(int numerator, int denominator) {
		if (denominator == 0) {
			return null;
		}
		if (numerator == 0) {
			return "0";
		}
		if (denominator == 1) {
			return String.valueOf(numerator);
		}
		String positive = "";
		if (numerator > 0 && denominator < 0 || numerator < 0 && denominator > 0) {
			positive = "-";
		}
		if (numerator % denominator == 0) {
			return numerator / denominator + "";
		}
		String a = String.valueOf((double) numerator / denominator);
		String[] result = a.split("\\.");
		if (isPrime(denominator)) {
			int l = repeating(denominator);
			if (l > 0) {
				result[1] = "(" + result[1].substring(0, l) + ")";
			}
		}
		if (!result[1].equals("0")) {
			return positive + result[0] + "." + result[1];
		} else {
			return positive + result[0];
		}
	}

	public boolean isPrime(int a) {
		boolean flag = true;
		if (a < 2) {// 素数不小于2
			return false;
		} else {
			for (int i = 2; i <= Math.sqrt(a); i++) {
				if (a % i == 0) {// 若能被整除，则说明不是素数，返回false
					flag = false;
					break;// 跳出循环
				}
			}
		}
		return flag;
	}

	public int repeating(int denominator) {
		if (denominator % 3 == 0) {
			return 1;
		} else if (denominator % 7 == 0) {
			return 6;
		} else if (denominator % 11 == 0) {
			return 2;
		} else if (denominator % 13 == 0) {
			return 12;
		} else if (denominator % 17 == 0) {
			return 16;
		} else if (denominator % 19 == 0) {
			return 18;
		} else {
			return -1;
		}
	}

	public static void main(String[] args) {
		Fraction2RecurringDecimal fraction2RecurringDecimal = new Fraction2RecurringDecimal();
		String r = fraction2RecurringDecimal.fractionToDecimal(1, 19);
		System.out.println(r);
	}
}
