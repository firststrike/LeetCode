package leetCode;

public class FindPeakElement {
	public int findPeakElement(int[] num) {
		if (num == null || num.length == 0) {
			return -1;
		}
		if (num.length == 1) {
			return 0;
		}
		int[] temp = new int[num.length];
		temp[0] = 0;
		temp[1] = num[1] - num[0];
		if (temp[1] < 0) {
			return 0;
		}
		for (int i = 2; i < temp.length; i++) {
			temp[i] = num[i] - num[i - 1];
			if (temp[i] < 0 && temp[i - 1] > 0) {
				return i - 1;
			}
		}
		if (temp[num.length - 1] > 0) {
			return num.length - 1;
		}
		return -1;
	}
}
