package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gengyu.bi on 2015/1/9.
 */
public class PopulatingNextRightPointersInEachNodeII {
	public void connect(TreeLinkNode root) {
		if (root == null)
			return;
		add(root);
		connect(root.left);
		connect(root.right);
	}

	private void add(TreeLinkNode node) {
		List<TreeLinkNode> nodeList = new ArrayList<TreeLinkNode>();
		while (node != null) {
			if (node != null) {
				if (node.left != null)
					nodeList.add(node.left);
				if (node.right != null)
					nodeList.add(node.right);
			}
			node = node.next;
		}
		for (int i = 0; i < nodeList.size() - 1; i++) {
			nodeList.get(i).next = nodeList.get(i + 1);
		}
	}

	public static void main(String[] args) {
		PopulatingNextRightPointersInEachNodeII populatingNextRightPointersInEachNodeII = new PopulatingNextRightPointersInEachNodeII();
		TreeLinkNode t1 = new TreeLinkNode(1);
		TreeLinkNode t2 = new TreeLinkNode(2);
		TreeLinkNode t3 = new TreeLinkNode(3);
		TreeLinkNode t4 = new TreeLinkNode(4);
		TreeLinkNode t5 = new TreeLinkNode(5);
		TreeLinkNode t6 = new TreeLinkNode(6);
		TreeLinkNode t7 = new TreeLinkNode(7);
		TreeLinkNode t8 = new TreeLinkNode(8);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		t3.right = t6;
		t4.left = t7;
		t6.right = t8;
		populatingNextRightPointersInEachNodeII.connect(t1);
		System.out.println("Populating Next Right Pointers in Each Node II");
	}
}
