package leetCode;

import java.util.HashMap;
import java.util.Map;

public class UniquePaths {
	Map<String, Integer> store = new HashMap<String, Integer>();

	public int uniquePaths(int m, int n) {
		if (m == 1 || n == 1) {
			return 1;
		} else {
			String key = m + "," + n;
			if (store.get(key) != null) {
				return store.get(key);
			} else {
				int value = uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
				store.put(key, value);
				return value;
			}
		}
	}
}
