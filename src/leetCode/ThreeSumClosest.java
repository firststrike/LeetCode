package leetCode;

import java.util.Arrays;

/**
 * Created by gengyu.bi on 2014/12/22.
 */
public class ThreeSumClosest {
	public int threeSumClosest(int[] num, int target) {
		if (num == null || num.length == 0) {
			return 0;
		}
		Arrays.sort(num);
		int minDifferent = Integer.MAX_VALUE;
		int result = 0;
		for (int i = 0; i < num.length; i++) {
			int l = i + 1;
			int r = num.length - 1;
			while (l < r) {
				int sum = num[i] + num[l] + num[r];
				int different = target - sum;
				if (Math.abs(different) < minDifferent) {
					minDifferent = Math.abs(different);
					result = sum;
				}
				if (different > 0) {
					l++;
				} else if (different < 0) {
					r--;
				} else {
					return result;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		ThreeSumClosest threeSumClosest = new ThreeSumClosest();
		int r = threeSumClosest.threeSumClosest(new int[]{-1, 2, 1, -4}, 1);
		System.out.println(r);
	}
}
