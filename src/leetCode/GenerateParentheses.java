package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gengyu.bi on 2014/12/24.
 */
public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<String>();
		ParenthesesTree parenthesesTree = new ParenthesesTree('(', n, 1, 0, "", result);
		return result;
	}

	public static void main(String[] args) {
		GenerateParentheses generateParentheses = new GenerateParentheses();
		List<String> r = generateParentheses.generateParenthesis(2);
		System.out.println("GenerateParentheses");
	}
}

class ParenthesesTree {
	String str;
	ParenthesesTree leftTree;
	ParenthesesTree rightTree;

	public ParenthesesTree(char c, int n, int leftCount, int rightCount, String str, List<String> strings) {
		this.str = str + c;
		if (leftCount < n) {
			this.leftTree = new ParenthesesTree('(', n, leftCount + 1, rightCount, this.str, strings);
		} else {
			this.leftTree = null;
		}
		if (rightCount < leftCount) {
			this.rightTree = new ParenthesesTree(')', n, leftCount, rightCount + 1, this.str, strings);
		} else {
			this.rightTree = null;
		}
		if (leftCount == n && rightCount == n) {
			strings.add(this.str);
		}
	}
}
