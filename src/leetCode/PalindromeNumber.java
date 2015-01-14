package leetCode;

public class PalindromeNumber {
	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		} else if (x == 0) {
			return true;
		} else {
			return isPalindrome(String.valueOf(x));
		}
	}

	public boolean isPalindrome(String number) {
		if (number.length() == 1) {
			return true;
		} else if (number.length() == 2) {
			if (number.substring(0, 1).equals(number.substring(1))) {
				return true;
			} else {
				return false;
			}
		} else {
			if (number.substring(0, 1).equals(
					number.substring(number.length() - 1, number.length()))) {
				return isPalindrome(number.substring(1,
						number.length() - 1));
			} else {
				return false;
			}
		}
	}
}
