package leetCode;

/**
 * Created by gengyu.bi on 2014/12/29.
 */
public class FlattenBinaryTree2LinkedList {
	public void flatten(TreeNode root) {
		sort(root);
	}

	private SortedBT sort(TreeNode node) {
		if (node == null) {
			return null;
		}
		SortedBT left = sort(node.left);
		SortedBT right = sort(node.right);
		if (left == null && right == null) {
			return new SortedBT(node, node);
		}
		if (left != null && right != null) {
			left.tail.right = right.head;
			node.right = left.head;
			node.left = null;
			return new SortedBT(node, right.tail);
		}
		if (left == null) {
			node.right = right.head;
			return new SortedBT(node, right.tail);
		} else {
			node.right = left.head;
			node.left = null;
			return new SortedBT(node, left.tail);
		}
	}

	public static void main(String[] args) {
		FlattenBinaryTree2LinkedList flattenBinaryTree2LinkedList = new FlattenBinaryTree2LinkedList();
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		t1.left = t2;
//		t1.right = t5;
//		t2.left = t3;
//		t2.right = t4;
//		t5.right = t6;
		flattenBinaryTree2LinkedList.flatten(null);
		System.out.println("FlattenBinaryTree2LinkedList");
	}
}

class SortedBT {
	TreeNode head;
	TreeNode tail;

	public SortedBT(TreeNode head, TreeNode tail) {
		this.head = head;
		this.tail = tail;
	}
}
