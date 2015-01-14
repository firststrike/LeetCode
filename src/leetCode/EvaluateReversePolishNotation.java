package leetCode;

import java.util.Stack;

public class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < tokens.length; i++) {
			String s = tokens[i];
			if (s.equals("+")) {
				int a = stack.pop();
				int b = stack.pop();
				stack.push(a + b);
			} else if (s.equals("-")) {
				int a = stack.pop();
				int b = stack.pop();
				stack.push(b - a);
			} else if (s.equals("*")) {
				int a = stack.pop();
				int b = stack.pop();
				stack.push(a * b);
			} else if (s.equals("/")) {
				int a = stack.pop();
				int b = stack.pop();
				stack.push(b / a);
			} else {
				int k = Integer.valueOf(s);
				stack.push(k);
			}
		}
		return stack.pop();
	}
}
