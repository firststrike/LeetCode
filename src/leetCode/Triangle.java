package leetCode;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0) {
			return 0;
		}
		List<int[]> store = new ArrayList<int[]>();
		int root = triangle.get(0).get(0);
		store.add(new int[] { root });
		for (int i = 1; i < triangle.size(); i++) {
			List<Integer> intList = triangle.get(i);
			int[] lastLine = store.get(i - 1);
			int[] ints = new int[intList.size()];
			for (int j = 0; j < intList.size(); j++) {
				if (j == 0) {
					ints[j] = lastLine[j] + intList.get(j);
				} else if (j == intList.size() - 1) {
					ints[j] = lastLine[j - 1] + intList.get(j);
				} else {
					int l1 = lastLine[j - 1];
					int l2 = lastLine[j];
					int thisInt = intList.get(j);
					ints[j] = getMin(l1 + thisInt, l2 + thisInt);
				}
			}
			store.add(ints);
		}
		return getMin(store.get(store.size() - 1));
	}

	private int getMin(int a, int b) {
		if (a < b) {
			return a;
		} else {
			return b;
		}
	}

	private int getMin(int[] line) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < line.length; i++) {
			if (line[i] < min) {
				min = line[i];
			}
		}
		return min;
	}
}
