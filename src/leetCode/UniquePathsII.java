package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gengyu.bi on 2014/12/29.
 */
public class UniquePathsII {
	Map<String, Integer> store = new HashMap<String, Integer>();

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length - 1;
		int n = obstacleGrid[0].length - 1;
		if (obstacleGrid[m][n] == 1 || obstacleGrid[0][0] == 1) {
			return 0;
		}
		return uniquePaths(m, n, obstacleGrid);
	}

	private int uniquePaths(int m, int n, int[][] obstacleGrid) {
		if (m == 0 && n == 0) {
			return 1;
		}
		if (m == 0 || n == 0) {
			if (m == 0) {
				if (obstacleGrid[m][n - 1] == 1) {
					return 0;
				} else {
					return uniquePaths(m, n - 1, obstacleGrid);
				}
			} else {
				if (obstacleGrid[m - 1][n] == 1) {
					return 0;
				} else {
					return uniquePaths(m - 1, n, obstacleGrid);
				}
			}
		} else {
			String key = m + "," + n;
			if (store.get(key) != null) {
				return store.get(key);
			} else {
				int a = obstacleGrid[m - 1][n] == 1 ? 0 : uniquePaths(m - 1, n, obstacleGrid);
				int b = obstacleGrid[m][n - 1] == 1 ? 0 : uniquePaths(m, n - 1, obstacleGrid);
				int value = a + b;
				store.put(key, value);
				return value;
			}
		}
	}

	public static void main(String[] args) {
		UniquePathsII uniquePathsII = new UniquePathsII();
		int r = uniquePathsII.uniquePathsWithObstacles(
				new int[][]{{0, 1, 0, 0, 0}, {1, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}});
		System.out.println(r);
	}
}
