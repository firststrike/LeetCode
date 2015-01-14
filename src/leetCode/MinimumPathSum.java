package leetCode;

public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
		int r = grid.length;
		int c = grid[0].length;
		if (r == 1 && c == 1) {
			return grid[0][0];
		} else {
			int[][] minGrid = new int[r][c];
			minGrid[0][0] = grid[0][0];
			for (int i = 1; i < r; i++) {
				minGrid[i][0] = minGrid[i - 1][0] + grid[i][0];
			}
			for (int i = 1; i < c; i++) {
				minGrid[0][i] = minGrid[0][i - 1] + grid[0][i];
			}
			for (int i = 1; i < r; i++) {
				for (int j = 1; j < c; j++) {
					minGrid[i][j] = getMin(minGrid[i - 1][j], minGrid[i][j - 1])
							+ grid[i][j];
				}
			}
			return minGrid[r - 1][c - 1];
		}
	}

	private int getMin(int a, int b) {
		if (a < b) {
			return a;
		} else {
			return b;
		}
	}
}
