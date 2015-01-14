package leetCode;

public class MaximumDepthofBinaryTree {
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return getMax(root, 1, 0);
	}

	private int getMax(TreeNode node, int depth, int maxDepth) {
		if (node.left == null && node.right == null) {
			if (depth > maxDepth) {
				maxDepth = depth;
			}
		}
		if (node.left != null) {
			maxDepth = getMax(node.left, depth + 1, maxDepth);
		}
		if (node.right != null) {
			maxDepth = getMax(node.right, depth + 1, maxDepth);
		}
		return maxDepth;
	}
}
