package leetCode;

/**
 * Created by gengyu.bi on 2014/12/30.
 */
public class ConvertSortedArray2BinarySearchTree {
	public TreeNode sortedArrayToBST(int[] num) {
		return add(num, 0, num.length - 1);
	}

	private TreeNode add(int[] num, int start, int end) {
		if (start > end)
			return null;
		if (start == end)
			return new TreeNode(num[start]);
		int root = (start + end) / 2;
		TreeNode node = new TreeNode(num[root]);
		node.left = add(num, start, root - 1);
		node.right = add(num, root + 1, end);
		return node;
	}

	public static void main(String[] args) {
		ConvertSortedArray2BinarySearchTree convert = new ConvertSortedArray2BinarySearchTree();
		TreeNode result = convert.sortedArrayToBST(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
		System.out.println("ConvertSortedArray2BinarySearchTree");
	}
}
