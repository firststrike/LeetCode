package leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by gengyu.bi on 2014/12/26.
 */
public class PathSumII {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Stack<TreeNode> treeNodeStack = new Stack<TreeNode>();
		if (root == null) {
			return result;
		}
		treeNodeStack.push(root);
		getPath(result, treeNodeStack, sum);
		return result;
	}

	private void getPath(List<List<Integer>> list, Stack<TreeNode> stack, int sum) {
		TreeNode node = stack.peek();
		if (node.left == null && node.right == null) {
			List<Integer> numList = getNumList(stack, sum);
			if (numList != null) {
				list.add(getNumList(stack, sum));
			}
		} else {
			if (node.left != null) {
				stack.push(node.left);
				getPath(list, stack, sum);
			}
			if (node.right != null) {
				stack.push(node.right);
				getPath(list, stack, sum);
			}
		}
		stack.pop();
	}

	private List<Integer> getNumList(Stack<TreeNode> treeNodeStack, int sum) {
		List<Integer> result = new ArrayList<Integer>();
		int s = 0;
		if (treeNodeStack.size() > 0) {
			for (int i = 0; i < treeNodeStack.size(); i++) {
				int n = treeNodeStack.get(i).val;
				s += n;
				result.add(n);
			}
		}
		if (sum == s) {
			return result;
		} else {
			return null;
		}
	}

	public static void main(String[] args) {
		PathSumII pathSumII = new PathSumII();
		TreeNode t5 = new TreeNode(5);
		TreeNode t4 = new TreeNode(4);
		TreeNode t8 = new TreeNode(8);
		TreeNode t11 = new TreeNode(11);
		TreeNode t13 = new TreeNode(13);
		TreeNode t40 = new TreeNode(4);
		TreeNode t7 = new TreeNode(7);
		TreeNode t2 = new TreeNode(2);
		TreeNode t50 = new TreeNode(5);
		TreeNode t1 = new TreeNode(1);
		t5.left = t4;
		t5.right = t8;
		t4.left = t11;
		t8.left = t13;
		t8.right = t40;
		t11.left = t7;
		t11.right = t2;
		t40.left = t50;
		t40.right = t1;
		List<List<Integer>> r = pathSumII.pathSum(t1, 0);
		System.out.println("PathSumII");
	}
}
