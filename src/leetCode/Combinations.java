package leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by gengyu.bi on 2015/1/4.
 */
public class Combinations {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Stack<Integer> stack = new Stack<Integer>();
		if (n == 0 || k == 0 || k > n)
			return result;
		add(result, 1, n, k, stack);
		return result;
	}

	private void add(List<List<Integer>> lists, int index, int n, int k, Stack<Integer> stack) {
		if (stack.size() == k) {
			List<Integer> numlist = new ArrayList<Integer>();
			for (int i : stack) {
				numlist.add(i);
			}
			lists.add(numlist);
		} else {
			for (int i = index; i <= n; i++) {
				stack.push(i);
				add(lists, i + 1, n, k, stack);
				stack.pop();
			}
		}
	}

	public static void main(String[] args) {
		Combinations combinations = new Combinations();
		combinations.combine(1, 1);
		System.out.println("Combinations");
	}
}
