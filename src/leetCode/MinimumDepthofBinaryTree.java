package leetCode;

public class MinimumDepthofBinaryTree {
	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return getMin(root, 1, Integer.MAX_VALUE);
	}

	private int getMin(TreeNode node, int depth, int minDepth) {
		if (node.left != null) {
			if (depth < minDepth) {
				minDepth = getMin(node.left, depth + 1, minDepth);
			}
		}
		if (node.right != null) {
			if (depth < minDepth) {
				minDepth = getMin(node.right, depth + 1, minDepth);
			}
		}
		if (node.left == null && node.right == null) {
			if (depth < minDepth) {
				minDepth = depth;
			}
		}
		return minDepth;
	}
}
