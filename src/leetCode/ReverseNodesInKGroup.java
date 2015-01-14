package leetCode;

import java.util.Stack;

/**
 * Created by gengyu.bi on 2014/12/31.
 */
public class ReverseNodesInKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || head.next == null || k <= 1)
			return head;
		ListNode result = null;
		ListNode index = head;
		ListNode tail = null;
		Stack<ListNode> stack = new Stack<ListNode>();
		while (index != null) {
			int i = 0;
			ListNode start = null;
			while (i < k && index != null) {
				i++;
				if (i == 1)
					start = index;
				stack.push(index);
				index = index.next;
			}
			if (i == k) {
				while (!stack.isEmpty()) {
					if (tail == null) {
						result = stack.pop();
						tail = result;
					} else {
						tail.next = stack.pop();
						tail = tail.next;
						tail.next = null;
					}
				}
			} else {
				if (tail == null)
					return head;
				else
					tail.next = start;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		ReverseNodesInKGroup reverseNodesInKGroup = new ReverseNodesInKGroup();
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		reverseNodesInKGroup.reverseKGroup(l1, 2);
		System.out.println("Reverse Nodes in k-Group");
	}
}
