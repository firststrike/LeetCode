package leetCode;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> treeList = new LinkedList<List<Integer>>();
		addNode(treeList, root, 0);
		return treeList;
	}

	private void addNode(List<List<Integer>> treeList, TreeNode root, int level) {
		if (root != null) {
			List<Integer> nodeList;
			if (treeList.size() - 1 < level) {
				nodeList = new LinkedList<Integer>();
				treeList.add(nodeList);
			} else {
				nodeList = treeList.get(level);
			}
			nodeList.add(root.val);
			addNode(treeList, root.left, level + 1);
			addNode(treeList, root.right, level + 1);
		}
	}
}
