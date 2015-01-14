package leetCode;

import java.util.Stack;

/**
 * Created by gengyu.bi on 2015/1/4.
 */
public class ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		int i = 0;
		ListNode result = new ListNode(0);
		ListNode pre = null;
		while (++i < m) {
			pre = head;
			head = head.next;
			if (i == 1)
				result.next = pre;
		}
		Stack<ListNode> stack = new Stack<ListNode>();
		for (i = m; i <= n; i++) {
			stack.push(head);
			head = head.next;
		}
		ListNode next = head;
		while (!stack.isEmpty()) {
			if (pre == null) {
				pre = stack.pop();
				result.next = pre;
			} else {
				pre.next = stack.pop();
				pre = pre.next;
			}
		}
		pre.next = next;
		return result.next;
	}

	public static void main(String[] args) {
		ReverseLinkedListII reverseLinkedListII = new ReverseLinkedListII();
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		reverseLinkedListII.reverseBetween(l1, 1, 3);
		System.out.println("Reverse Linked List II");
	}
}
