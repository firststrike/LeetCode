package leetCode;

import java.util.Arrays;

/**
 * Created by gengyu.bi on 2015/1/7.
 */
public class NextPermutation {
	public void nextPermutation(int[] num) {
		if (num == null || num.length <= 1)
			return;
		int i;
		int j = -1;
		for (i = num.length - 1; i >= 1; i--) {
			int l = num[i - 1];
			int r = num[i];
			if (l < r) {
				j = i - 1;
				break;
			}
		}
		if (i == 0 && j < 0) {
			Arrays.sort(num);
			return;
		}
		int k = 0;
		for (i = num.length - 1; i >= j + 1; i--) {
			int n = num[i];
			if (n > num[j]) {
				k = i;
				break;
			}
		}
		exchange(num, j, k);
		int end = (num.length + j) / 2;
		int index = 0;
		for (i = j + 1; i <= end; i++) {
			exchange(num, i, num.length - 1 - index++);
		}
	}

	private void exchange(int[] num, int m, int n) {
		int temp = num[m];
		num[m] = num[n];
		num[n] = temp;
	}

	public static void main(String[] args) {
		NextPermutation nextPermutation = new NextPermutation();
		int[] num = new int[]{2, 3, 1, 3, 3};
		while (true) {
			nextPermutation.nextPermutation(num);
			System.out.println(num.toString());
		}
	}
}
