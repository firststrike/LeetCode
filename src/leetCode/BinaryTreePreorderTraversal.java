package leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if (root!=null) {
			Stack<Integer> stack = new Stack<Integer>();
			add(stack, root);
			while (!stack.isEmpty()) {
				result.add(stack.pop());
			}
		}
		return result;
	}

	private void add(Stack<Integer> stack, TreeNode node) {
		if (node != null) {
			stack.push(node.val);
			add(stack, node.right);
			add(stack, node.left);
		}
	}
}
