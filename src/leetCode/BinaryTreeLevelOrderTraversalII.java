package leetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class BinaryTreeLevelOrderTraversalII {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		Map<Integer, List<Integer>> depthMap = new TreeMap<Integer, List<Integer>>();
		depthFirst(root, 0, depthMap);
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		for (Entry<Integer, List<Integer>> mapEntry : depthMap.entrySet()) {
			result.add(0, mapEntry.getValue());
		}
		return result;
	}

	private void depthFirst(TreeNode node, int depth,
			Map<Integer, List<Integer>> depthMap) {
		if (node != null) {
			if (depthMap.containsKey(depth)) {
				depthMap.get(depth).add(node.val);
			} else {
				List<Integer> list = new LinkedList<Integer>();
				list.add(node.val);
				depthMap.put(depth, list);
			}
			depthFirst(node.left, depth + 1, depthMap);
			depthFirst(node.right, depth + 1, depthMap);
		}
	}
}
