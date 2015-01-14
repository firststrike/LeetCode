package leetCode;

import java.util.Stack;

/**
 * Created by gengyu.bi on 2015/1/8.
 */
public class NQueensII {
	int result = 0;

	public int totalNQueens(int n) {
		Stack<Integer> stack = new Stack<Integer>();
		if (n <= 0)
			return result;
		add(stack, 0, n);
		return result;
	}

	private void add(Stack<Integer> stack, int index, int n) {
		if (stack.size() == n) {
			result++;
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
				add(stack, index + 1, n);
				stack.pop();
			}
		}
	}

	public static void main(String[] args) {
		NQueensII nQueensII = new NQueensII();
		int r = nQueensII.totalNQueens(4);
		System.out.println(r);
	}
}
