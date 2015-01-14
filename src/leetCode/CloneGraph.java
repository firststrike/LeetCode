package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gengyu.bi on 2015/1/9.
 */
public class CloneGraph {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		Map<Integer, UndirectedGraphNode> nodeMap = new HashMap<Integer, UndirectedGraphNode>();
		UndirectedGraphNode result = dfs(node, nodeMap);
		return result;
	}

	private UndirectedGraphNode dfs(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> nodeMap) {
		if (node == null)
			return null;
		if (nodeMap.containsKey(node.label))
			return nodeMap.get(node.label);
		UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
		nodeMap.put(node.label, clone);
		List<UndirectedGraphNode> graphNodes = new ArrayList<UndirectedGraphNode>();
		for (UndirectedGraphNode neighbors : node.neighbors) {
			graphNodes.add(dfs(neighbors, nodeMap));
		}
		clone.neighbors = graphNodes;
		return clone;
	}

	public static void main(String[] args) {
		CloneGraph cloneGraph=new CloneGraph();

	}
}
