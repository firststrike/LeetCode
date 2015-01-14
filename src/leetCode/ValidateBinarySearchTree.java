package leetCode;

import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree {
	public boolean isValidBST(TreeNode root) {
		if (root == null || (root.left == null && root.right == null)) {
			return true;
		}
		List<Integer> numList = new ArrayList<Integer>();
		addNum(root, numList);
		for (int i = 1; i < numList.size(); i++) {
			int left = numList.get(i - 1);
			int right = numList.get(i);
			if (left == right) {
				return false;
			}
			if (left < right) {
				continue;
			}
			if (left > right) {
				return false;
			}
		}
		return true;
	}

	private void addNum(TreeNode node, List<Integer> numList) {
		if (node.left != null) {
			addNum(node.left, numList);
		}
		numList.add(node.val);
		if (node.right != null) {
			addNum(node.right, numList);
		}
	}
}
