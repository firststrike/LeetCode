package leetCode;

public class PlusOne {
	public int[] plusOne(int[] digits) {
		boolean carry = false;
		for (int i = digits.length - 1; i >= 0; i--) {
			Carry result = plus(digits[i]);
			digits[i] = result.getResult();
			if (result.isCarry()) {
				if (i == 0) {
					carry = true;
					break;
				} else {
					continue;
				}
			} else {
				break;
			}
		}
		int[] r;
		int d_s = 0;
		int r_s = 0;
		if (carry) {
			r = new int[digits.length + 1];
			r[0] = 1;
			r_s = 1;
			System.out.print("1");
		} else {
			for (int i = 0; i < digits.length; i++) {
				d_s = i;
				if (digits[i] > 0) {
					break;
				}
			}
			r = new int[digits.length - d_s];
		}
		for (int i = d_s; i < digits.length; i++) {
			r[r_s] = digits[i];
			r_s++;
			System.out.print(digits[i]);
		}
		return r;
	}

	private Carry plus(int d) {
		int result = d + 1;
		Carry carry = new Carry();
		carry.setResult(result % 10);
		if (result >= 10) {
			carry.setCarry(true);
		} else {
			carry.setCarry(false);
		}
		return carry;
	}
}

class Carry {
	private boolean carry;
	private int result;

	public boolean isCarry() {
		return carry;
	}

	public void setCarry(boolean carry) {
		this.carry = carry;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

}
