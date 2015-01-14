package leetCode;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class SortList {
	public ListNode sortList(ListNode head) {
		if (head == null) {
			return null;
		}
		SortedMap<ListNode, Integer> listNodes = new TreeMap<ListNode, Integer>(
				new Comparator<ListNode>() {
					public int compare(ListNode o1, ListNode o2) {
						return o1.val - o2.val;
					}
				});
		while (head != null) {
			if (listNodes.get(head) != null) {
				int num = listNodes.get(head);
				listNodes.put(head, num + 1);
			} else {
				listNodes.put(head, 1);
			}
			head = head.next;
		}
		ListNode first = null;
		ListNode last = null;
		for (Map.Entry<ListNode, Integer> listNode : listNodes.entrySet()) {
			int count = listNode.getValue();
			for (int i = 0; i < count; i++) {
				ListNode key = new ListNode(listNode.getKey().val);
				if (last == null) {
					first = key;
				} else {
					last.next = key;
				}
				last = key;
				last.next = null;
			}
		}
		return first;
	}
}
