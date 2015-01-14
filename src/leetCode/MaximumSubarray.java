package leetCode;

/**
 * Created by gengyu.bi on 2015/1/7.
 */
public class MaximumSubarray {
	public int maxSubArray(int[] A) {
		if (A == null || A.length == 0)
			return 0;
		if (A.length == 1)
			return A[0];
		return getMax(A, 0, A.length - 1, Integer.MIN_VALUE);
	}

	private int getMax(int[] A, int start, int end, int max) {
		if (start > end)
			return Integer.MIN_VALUE;
		int mid = (start + end) / 2;
		int lMax = getMax(A, start, mid - 1, max);
		int rMax = getMax(A, mid + 1, end, max);
		max = Math.max(max, lMax);
		max = Math.max(max, rMax);
		int lMax_mid = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = mid - 1; i >= 0; i--) {
			sum += A[i];
			if (sum > lMax_mid)
				lMax_mid = sum;
		}
		int rMax_mid = Integer.MIN_VALUE;
		sum = 0;
		for (int i = mid + 1; i <= end; i++) {
			sum += A[i];
			if (sum > rMax_mid)
				rMax_mid = sum;
		}
		max = Math.max(max, lMax_mid + A[mid] + rMax_mid);
		return max;
	}

	public static void main(String[] args) {
		MaximumSubarray maximumSubarray = new MaximumSubarray();
		int r = maximumSubarray.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
		System.out.println(r);
	}
}
