package leetCode;

import java.util.LinkedList;
import java.util.List;

public class Permutations {
	public List<List<Integer>> permute(int[] num) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		int count = factorial(num.length);
		for (int i = 0; i < count; i++) {
			result.add(getPermutation(num, i));
		}
		return result;
	}

	public List<Integer> getPermutation(int[] num, int k) {
		List<Integer> intList = new LinkedList<Integer>();
		for (int i = 0; i < num.length; i++) {
			intList.add(num[i]);
		}
		List<Integer> list = new LinkedList<Integer>();
		int index = 0;
		for (int i = 0; i < num.length; i++) {
			if (intList.size() == 1) {
				list.add(intList.get(0));
				break;
			} else {
				int m = factorial(intList.size() - 1);
				index = k / m;
				k = k % m;
				list.add(intList.get(index));
				intList.remove(index);
			}
		}
		return list;
	}

	public int factorial(int k) {
		int i = 1;
		for (int j = 2; j <= k; j++) {
			i = i * j;
		}
		return i;
	}
}
