package leetCode;

public class JumpGameII {
	public int jump(int[] A) {
		int[] steps = new int[A.length];
		for (int i = 0; i < steps.length; i++) {
			steps[i] = Integer.MAX_VALUE;
		}
		steps[0] = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = 1; j <= A[i]; j++) {
				if (i + j >= A.length) {
					break;
				}
				steps[i + j] = getMin(steps[i + j], steps[i] + 1);
				if (i + j == A.length - 1) {
					return steps[i + j];
				}
			}
		}
		return steps[A.length - 1];
	}

	private int getMin(int a, int b) {
		if (a < b) {
			return a;
		} else {
			return b;
		}
	}
}
