package leetCode;

/**
 * Created by gengyu.bi on 2014/12/23.
 */
public class Search2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == target || matrix[i][matrix[i].length - 1] == target) {
				return true;
			}
			if (matrix[i][0] > target) {
				return false;
			}
			if (matrix[i][0] < target && matrix[i][matrix[i].length - 1] > target) {
				for (int j = 1; j < matrix[i].length - 1; j++) {
					if (matrix[i][j] == target) {
						return true;
					}
					if (matrix[i][j] > target) {
						return false;
					}
					continue;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Search2DMatrix search2DMatrix = new Search2DMatrix();
		int[][] matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
		boolean r = search2DMatrix.searchMatrix(matrix, 3);
		System.out.println(r);
	}
}
