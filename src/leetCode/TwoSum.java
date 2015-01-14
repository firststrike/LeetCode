package leetCode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public int[] twoSum(int[] numbers, int target) {
		int[] result = new int[2];
		Map<Integer, Integer> numbersMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {
			numbersMap.put(numbers[i], i + 1);
		}
		for (int i = 0; i < numbers.length; i++) {
			int number = numbers[i];
			if (numbersMap.get(target - number) != null
					&& numbersMap.get(target - number) - 1 != i) {
				result[0] = i + 1;
				result[1] = numbersMap.get(target - number);
				return result;
			} else {
				continue;
			}
		}
		return result;
	}
}
