package leetCode;

import java.util.Stack;

/**
 * Created by gengyu.bi on 2014/12/24.
 */
public class ValidParentheses {
	public boolean isValid(String s) {
		if (s == null || s.equals("")) {
			return true;
		}
		char[] chars = s.toCharArray();
		Stack<Character> characterStack = new Stack<Character>();
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == '(' || chars[i] == '{' || chars[i] == '[') {
				characterStack.push(chars[i]);
			} else if (chars[i] == ')' || chars[i] == '}' || chars[i] == ']') {
				boolean correct = true;
				if (characterStack.isEmpty()) {
					return false;
				}
				while (!characterStack.isEmpty()) {
					char c = characterStack.pop();
					if (c == '(' && chars[i] == ')') {
						break;
					}
					if (c == '{' && chars[i] == '}') {
						break;
					}
					if (c == '[' && chars[i] == ']') {
						break;
					}
					correct = false;
				}
				if (!correct) {
					return false;
				}
			}
		}
		if (characterStack.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		ValidParentheses validParentheses = new ValidParentheses();
		boolean r = validParentheses.isValid("}");
		System.out.println(r);
	}
}
