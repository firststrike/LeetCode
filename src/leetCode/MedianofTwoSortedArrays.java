package leetCode;

public class MedianofTwoSortedArrays {
	public double findMedianSortedArrays(int A[], int B[]) {
		int[] sortedInts;
		if ((A == null || A.length == 0) && (B == null || B.length == 0)) {
			return -1;
		} else if ((A == null || A.length == 0) && (B != null && B.length > 0)) {
			sortedInts = B;
		} else if ((A != null && A.length > 0) && (B == null || B.length == 0)) {
			sortedInts = A;
		} else {
			sortedInts = new int[A.length + B.length];
			int index_A = 0;
			int index_B = 0;
			for (int i = 0; i < sortedInts.length; i++) {
				if (index_A < A.length
						&& (index_B >= B.length || A[index_A] < B[index_B])) {
					sortedInts[i] = A[index_A];
					index_A++;
				} else {
					sortedInts[i] = B[index_B];
					index_B++;
				}
			}
		}
		return getMedian(sortedInts);
	}

	private double getMedian(int A[]) {
		if (A.length % 2 == 1) {
			return A[A.length / 2];
		} else {
			int a = A[A.length / 2 - 1];
			int b = A[A.length / 2];
			return ((double) a + b) / 2;
		}
	}
}
