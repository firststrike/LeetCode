package leetCode;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class MergeSortedArray {
	public void merge(int A[], int m, int B[], int n) {
		Map<Integer, Integer> sortedMap = new TreeMap<Integer, Integer>();
		for (int i = 0; i < m; i++) {
			add(sortedMap, A[i]);
		}
		for (int i = 0; i < n; i++) {
			add(sortedMap, B[i]);
		}
		int index = 0;
		for (Entry<Integer, Integer> mapEntry : sortedMap.entrySet()) {
			for (int i = 0; i < mapEntry.getValue(); i++) {
				A[index] = mapEntry.getKey();
				index++;
			}
		}
	}

	private void add(Map<Integer, Integer> treeMap, int key) {
		if (treeMap.containsKey(key)) {
			treeMap.put(key, treeMap.get(key) + 1);
		} else {
			treeMap.put(key, 1);
		}
	}
}
