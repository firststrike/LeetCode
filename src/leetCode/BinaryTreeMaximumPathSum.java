package leetCode;

/**
 * Created by gengyu.bi on 2015/1/12.
 */
public class BinaryTreeMaximumPathSum {
	int max = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		if (root == null)
			return 0;
		getMax(root);
		return max;
	}

	private int getMax(TreeNode node) {
		if (node == null)
			return 0;
		int val = node.val;
		int left = getMax(node.left);
		int right = getMax(node.right);
		if (left > 0)
			val += left;
		if (right > 0)
			val += right;
		if (val > max)
			max = val;
		return Math.max(node.val, Math.max(node.val + left, node.val + right));
	}

	public static void main(String[] args) {
		BinaryTreeMaximumPathSum binaryTreeMaximumPathSum = new BinaryTreeMaximumPathSum();
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		t1.left = t2;
		t1.right = t3;
		int r = binaryTreeMaximumPathSum.maxPathSum(t1);
		System.out.println(r);
	}
}
