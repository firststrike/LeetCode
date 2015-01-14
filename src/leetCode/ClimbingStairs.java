package leetCode;

public class ClimbingStairs {
	public int climbStairs(int n) {
		if (n <= 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		} else {
			int[] climbTable = new int[n];
			climbTable[0] = 1;
			climbTable[1] = 2;
			for (int i = 2; i < n; i++) {
				climbTable[i] = climbTable[i - 1] + climbTable[i - 2];
			}
			return climbTable[n - 1];
		}
	}
}
