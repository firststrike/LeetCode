package leetCode;

import java.util.LinkedList;
import java.util.List;

public class PascalsTriangleII {
	public List<Integer> getRow(int rowIndex) {
		return generate(rowIndex + 1).get(rowIndex);
	}

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> resultList = new LinkedList<List<Integer>>();
		if (numRows >= 1) {
			List<Integer> list = new LinkedList<Integer>();
			list.add(1);
			resultList.add(list);
		}
		if (numRows >= 2) {
			List<Integer> list = new LinkedList<Integer>();
			list.add(1);
			list.add(1);
			resultList.add(list);
		}
		if (numRows >= 3) {
			int index = 0;
			do {
				index++;
				List<Integer> list = new LinkedList<Integer>();
				list.add(1);
				for (int i = 0; i < index; i++) {
					List<Integer> l1 = resultList.get(index);
					list.add(l1.get(i) + l1.get(i + 1));
				}
				list.add(1);
				resultList.add(list);
			} while (index <= numRows - 3);
		}
		return resultList;
	}
}
