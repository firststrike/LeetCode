package leetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class PermutationsII {
	public List<List<Integer>> permuteUnique(int[] num) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		Set<String> set = new HashSet<String>();
		int count = factorial(num.length);
		for (int i = 0; i < count; i++) {
			Store store = getPermutation(num, i);
			if (!set.contains(store.key)) {
				result.add(store.value);
				set.add(store.key);
			}
		}
		return result;
	}

	public Store getPermutation(int[] num, int k) {
		List<Integer> intList = new LinkedList<Integer>();
		String key = "";
		for (int i = 0; i < num.length; i++) {
			intList.add(num[i]);
		}
		List<Integer> list = new LinkedList<Integer>();
		int index = 0;
		for (int i = 0; i < num.length; i++) {
			if (intList.size() == 1) {
				list.add(intList.get(0));
				key += intList.get(0) + ",";
				break;
			} else {
				int m = factorial(intList.size() - 1);
				index = k / m;
				k = k % m;
				list.add(intList.get(index));
				key += intList.get(index) + ",";
				intList.remove(index);
			}
		}
		Store store = new Store(key, list);
		return store;
	}

	public int factorial(int k) {
		int i = 1;
		for (int j = 2; j <= k; j++) {
			i = i * j;
		}
		return i;
	}
}

class Store {
	String key;
	List<Integer> value;

	public Store(String key, List<Integer> value) {
		this.key = key;
		this.value = value;
	}
}
