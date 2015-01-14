package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by gengyu.bi on 2015/1/4.
 */
public class Subsets {
	public List<List<Integer>> subsets(int[] S) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Stack<Integer> stack = new Stack<Integer>();
		if (S == null || S.length == 0)
			return result;
		Arrays.sort(S);
		for (int i = 0; i <= S.length; i++) {
			add(result, 0, S, i, stack);
		}
		return result;
	}

	private void add(List<List<Integer>> lists, int index, int[] S, int k, Stack<Integer> stack) {
		if (stack.size() == k) {
			List<Integer> numlist = new ArrayList<Integer>();
			for (int i : stack) {
				numlist.add(i);
			}
			lists.add(numlist);
		} else {
			for (int i = index; i < S.length; i++) {
				stack.push(S[i]);
				add(lists, i + 1, S, k, stack);
				stack.pop();
			}
		}
	}

	public static void main(String[] args) {
		Subsets subsets = new Subsets();
		subsets.subsets(new int[]{4, 1, 0});
		System.out.println("Subsets");
	}
}
