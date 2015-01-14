package leetCode;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}

	public boolean hasSum(int sum) {
		if (left == null && right == null && sum == val) {
			return true;
		}
		if (left != null && left.hasSum(sum - val)) {
			return true;
		}
		if (right != null && right.hasSum(sum - val)) {
			return true;
		}
		return false;

	}
}
