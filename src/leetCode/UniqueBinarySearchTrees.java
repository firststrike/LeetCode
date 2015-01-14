package leetCode;

public class UniqueBinarySearchTrees {
	public int numTrees(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		} else {
			int[] record = new int[n + 1];
			record[0] = 1;
			record[1] = 1;
			record[2] = 2;
			for (int i = 3; i <= n; i++) {
				int count = 0;
				for (int j = 0; j < i; j++) {
					count += record[j] * record[i - j - 1];
				}
				record[i] = count;
			}
			return record[n];
		}
	}
}
