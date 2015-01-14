package leetCode;

/**
 * Created by gengyu.bi on 2015/1/8.
 */
public class RecoverBinarySearchTree {
	TreeNode node1 = null;
	TreeNode node2 = null;
	TreeNode preNode = null;

	public void recoverTree(TreeNode root) {
		inorder(root);
		int val=node1.val;
		node1.val=node2.val;
		node2.val=val;
	}

	private void inorder(TreeNode node) {
		if (node == null)
			return;
		if (node.left != null)
			inorder(node.left);
		if (preNode != null && preNode.val > node.val) {
			if (node1 == null)
				node1 = preNode;
			node2 = node;
		}
		preNode = node;
		if (node.right != null)
			inorder(node.right);
	}
}
