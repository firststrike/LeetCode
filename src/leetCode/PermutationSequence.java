package leetCode;

import java.util.LinkedList;
import java.util.List;

public class PermutationSequence {
	public String getPermutation(int n, int k) {
		k = k - 1;
		List<Integer> intList = new LinkedList<Integer>();
		String result = "";
		for (int i = 1; i <= n; i++) {
			intList.add(i);
		}
		int index = 0;
		for (int i = 0; i < n; i++) {
			if (intList.size() == 1) {
				result += intList.get(0);
				break;
			} else {
				int m = factorial(intList.size() - 1);
				index = k / m;
				k = k % m;
				result += intList.get(index);
				intList.remove(index);
			}
		}
		return result;
	}

	public int factorial(int k) {
		int i = 1;
		for (int j = 2; j <= k; j++) {
			i = i * j;
		}
		return i;
	}
}
