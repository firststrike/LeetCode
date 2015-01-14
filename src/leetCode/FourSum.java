package leetCode;

import java.util.*;

/**
 * Created by gengyu.bi on 2014/12/22.
 */
public class FourSum {
	public List<List<Integer>> fourSum(int[] num, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (num == null || num.length < 4) {
			return result;
		}
		Arrays.sort(num);
		Map<Integer, List<int[]>> storeMap = new HashMap<Integer, List<int[]>>();
		for (int i = 0; i < num.length - 1; i++) {
			for (int j = i + 1; j < num.length; j++) {
				int sum = num[i] + num[j];
				List<int[]> numList;
				if (!storeMap.containsKey(sum)) {
					numList = new ArrayList<int[]>();
				} else {
					numList = storeMap.get(sum);
				}
				numList.add(new int[]{i, j});
				storeMap.put(sum, numList);
			}
		}
		for (Map.Entry<Integer, List<int[]>> store : storeMap.entrySet()) {
			int num1 = store.getKey();
			int num2 = target - num1;
			if (storeMap.containsKey(num2)) {
				List<int[]> numList1 = store.getValue();
				List<int[]> numList2 = storeMap.get(num2);
				for (int i = 0; i < numList1.size(); i++) {
					for (int j = 0; j < numList2.size(); j++) {
						Set<Integer> numSet = new TreeSet<Integer>();
						numSet.add(numList1.get(i)[0]);
						numSet.add(numList1.get(i)[1]);
						numSet.add(numList2.get(j)[0]);
						numSet.add(numList2.get(j)[1]);
						if (numSet.size() == 4) {
							List<Integer> numList = new ArrayList<Integer>();
							for (int n : numSet) {
								numList.add(num[n]);
							}
							if (!result.contains(numList)) {
								result.add(numList);
							}
						}
					}
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		FourSum fourSum = new FourSum();
		List<List<Integer>> result = fourSum.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
		System.out.println(result);
	}
}
