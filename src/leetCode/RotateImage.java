package leetCode;

/**
 * Created by gengyu.bi on 2014/12/30.
 */
public class RotateImage {
	// 顺时针旋转=先延/对角线翻转，再水平翻转
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n - 1 - j][n - 1 - i];
				matrix[n - 1 - j][n - 1 - i] = temp;
			}
		}
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < n; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n - 1 - i][j];
				matrix[n - 1 - i][j] = temp;
			}
		}
	}

	public static void main(String[] args) {
		RotateImage rotateImage = new RotateImage();
		int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
		rotateImage.rotate(matrix);
		System.out.println("RotateImage");
	}
}
