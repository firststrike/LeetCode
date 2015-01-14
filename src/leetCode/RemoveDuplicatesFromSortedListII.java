package leetCode;

/**
 * Created by gengyu.bi on 2015/1/4.
 */
public class RemoveDuplicatesFromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode result = new ListNode(0);
		ListNode node = result;
		int count = 1;
		while (head != null) {
			if (head.next == null) {
				if (count == 1)
					node.next = head;
				else
					node.next = null;
				break;
			}
			if (head.next.val == head.val) {
				count++;
			} else {
				if (count > 1) {
					count = 1;
				} else {
					node.next = head;
					node = node.next;
				}
			}
			head = head.next;
		}
		return result.next;
	}

	public static void main(String[] args) {
		RemoveDuplicatesFromSortedListII removeDuplicatesFromSortedListII = new RemoveDuplicatesFromSortedListII();
		ListNode l1 = new ListNode(0);
		ListNode l21 = new ListNode(1);
		ListNode l22 = new ListNode(2);
		ListNode l3 = new ListNode(2);
		ListNode l41 = new ListNode(4);
		ListNode l42 = new ListNode(4);
		ListNode l43 = new ListNode(5);
		ListNode l5 = new ListNode(5);
		l1.next = l21;
		l21.next = l22;
		l22.next = l3;
		l3.next = l41;
		l41.next = l42;
		l42.next = l43;
		l43.next = l5;
		removeDuplicatesFromSortedListII.deleteDuplicates(l1);
		System.out.println("Remove Duplicates from Sorted List II");
	}
}
