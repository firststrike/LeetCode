package leetCode;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new LinkedList<Integer>();
		add(list, root);
		return list;
	}

	private void add(List<Integer> list, TreeNode node) {
		if (node != null) {
			add(list, node.left);
			list.add(node.val);
			add(list, node.right);
		}
	}
}
