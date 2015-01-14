package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by gengyu.bi on 2015/1/12.
 */
public class CombinationSumII {
	Stack<Integer> stack = new Stack<Integer>();

	public List<List<Integer>> combinationSum2(int[] num, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (num == null || num.length == 0)
			return result;
		Arrays.sort(num);
		addNum(result, stack, num, 0, target);
		return result;
	}

	private void addNum(List<List<Integer>> result, Stack<Integer> stack, int[] num, int index, int target) {
		if (index > num.length || target < 0) {
			return;
		}
		if (target == 0) {
			List<Integer> list = new ArrayList<Integer>();
			for (int k : stack)
				list.add(k);
			result.add(list);
			return;
		}
		for (int i = index; i < num.length; i++) {
			if (i > index && num[i] == num[i - 1])
				continue;
			stack.push(num[i]);
			addNum(result, stack, num, i + 1, target - num[i]);
			stack.pop();
		}
	}

	public static void main(String[] args) {
		CombinationSumII combinationSumII = new CombinationSumII();
		combinationSumII.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
		System.out.println("Combination Sum II");
	}
}
