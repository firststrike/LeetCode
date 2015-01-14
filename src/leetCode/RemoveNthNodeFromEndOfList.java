package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gengyu.bi on 2014/12/23.
 */
public class RemoveNthNodeFromEndOfList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null) {
			return null;
		}
		Map<Integer, ListNode> listNodeMap = new HashMap<Integer, ListNode>();
		ListNode listNode = head;
		int index = 0;
		while (listNode != null) {
			listNodeMap.put(index, listNode);
			listNode = listNode.next;
			index++;
		}
		index = index - n;
		if (index == 0) {
			return listNodeMap.get(1);
		} else {
			listNodeMap.get(index - 1).next = listNodeMap.get(index + 1);
			return listNodeMap.get(0);
		}
	}

	public static void main(String[] args) {
		RemoveNthNodeFromEndOfList removeNthNodeFromEndOfList = new RemoveNthNodeFromEndOfList();
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode listNode = removeNthNodeFromEndOfList.removeNthFromEnd(l1, 1);
		System.out.println("RemoveNthNodeFromEndOfList");
	}
}
