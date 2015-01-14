package leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by gengyu.bi on 2015/1/8.
 */
public class NQueens {
	public List<String[]> solveNQueens(int n) {
		Stack<Integer> stack = new Stack<Integer>();
		List<String[]> result = new ArrayList<String[]>();
		if (n <= 0)
			return result;
		add(stack, result, 0, n);
		return result;
	}

	private void add(Stack<Integer> stack, List<String[]> result, int index, int n) {
		if (stack.size() == n) {
			int yQ = 0;
			String[] strings = new String[n];
			for (int xQ : stack) {
				StringBuilder stringBuilder = new StringBuilder();
				for (int i = 0; i < n; i++) {
					stringBuilder.append(".");
				}
				stringBuilder.replace(xQ, xQ + 1, "Q");
				strings[yQ] = stringBuilder.toString();
				yQ++;
			}
			result.add(strings);
			return;
		}
		for (int i = 0; i < n; i++) {
			int y = stack.size();
			int yQ, xQ;
			boolean could = true;
			for (yQ = 0; yQ < stack.size(); yQ++) {
				xQ = stack.get(yQ);
				if (xQ == i || yQ == y || Math.abs(yQ - y) == Math.abs(xQ - i)) {
					could = false;
					break;
				}
			}
			if (could) {
				stack.push(i);
				add(stack, result, index + 1, n);
				stack.pop();
			}
		}
	}

	public static void main(String[] args) {
		NQueens nQueens = new NQueens();
		nQueens.solveNQueens(4);
		System.out.println("N-Queens");
	}
}
