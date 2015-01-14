package leetCode;

public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		if (isBalanced(root.left) && isBalanced(root.right)
				&& getDifference(root) <= 1) {
			return true;
		} else {
			return false;
		}
	}

	private int getDifference(TreeNode root) {
		if (root == null)
			return 0;
		int left = getHeight(root.left);
		int right = getHeight(root.right);
		return Math.abs(left - right);
	}

	private int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return getMax(getHeight(root.left), getHeight(root.right)) + 1;
	}

	private int getMax(int leftHeight, int rightHeight) {
		if (leftHeight > rightHeight) {
			return leftHeight;
		} else {
			return rightHeight;
		}
	}
}

