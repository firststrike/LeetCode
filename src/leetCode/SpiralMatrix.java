package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gengyu.bi on 2014/12/30.
 */
public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<Integer>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return result;
		int rowStart = 0;
		int colStart = 0;
		int rowEnd = matrix.length - 1;
		int colEnd = matrix[0].length - 1;
		int r = 0, c = 0;
		int index = 1;
		int count = matrix.length * matrix[0].length;
		result.add(matrix[rowStart][colStart]);
		while (true) {
			while (++c <= colEnd) {
				result.add(matrix[r][c]);
				index++;
			}
			if (index >= count)
				break;
			c--;
			colStart++;
			while (++r <= rowEnd) {
				result.add(matrix[r][c]);
				index++;
			}
			if (index >= count)
				break;
			r--;
			rowEnd--;
			while (--c >= rowStart) {
				result.add(matrix[r][c]);
				index++;
			}
			if (index >= count)
				break;
			c++;
			colEnd--;
			while (--r >= colStart) {
				result.add(matrix[r][c]);
				index++;
			}
			if (index >= count)
				break;
			r++;
			rowStart++;
		}
		return result;
	}

	public static void main(String[] args) {
		SpiralMatrix spiralMatrix = new SpiralMatrix();
		spiralMatrix.spiralOrder(
				new int[][]{{2, 3}});
		System.out.println("SpiralMatrix");
	}
}
