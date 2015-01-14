package leetCode;

import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {
	public ListNode mergeKLists(List<ListNode> lists) {
		if (lists.isEmpty() || lists.size() == 0) {
			return null;
		}
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		for (int i = 0; i < lists.size(); i++) {
			ListNode listNode = lists.get(i);
			while (listNode != null) {
				queue.add(listNode.val);
				listNode = listNode.next;
			}
		}
		if (!queue.isEmpty()) {
			ListNode result = new ListNode(queue.poll());
			ListNode node = result;
			while (!queue.isEmpty()) {
				ListNode listNode = new ListNode(queue.poll());
				node.next = listNode;
				node = node.next;
			}
			return result;
		}else {
			return null;
		}
	}
}
