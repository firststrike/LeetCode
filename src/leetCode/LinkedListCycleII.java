package leetCode;

/**
 * Created by gengyu.bi on 2014/12/31.
 */
public class LinkedListCycleII {
	public ListNode detectCycle(ListNode head) {
		if (head == null)
			return null;
		ListNode fast = head;
		ListNode slow = head;
		while (true) {
			if (fast.next == null)
				return null;
			fast = fast.next;
			if (fast.next == null)
				return null;
			fast = fast.next;
			slow = slow.next;
			if (fast == slow)
				break;
		}
		while (head != slow) {
			slow = slow.next;
			head = head.next;
		}
		return head;
	}

	public static void main(String[] args) {
		LinkedListCycleII linkedListCycleII = new LinkedListCycleII();
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		//l6.next = l3;
		ListNode r = linkedListCycleII.detectCycle(l1);
		System.out.println(r.val);
	}
}
