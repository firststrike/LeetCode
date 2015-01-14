package leetCode;

public class RemoveDuplicatesFromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode node = head;
		ListNode result = head;
		while (node.next != null) {
			if (node.next.val == node.val) {
				node.next = node.next.next;
			}else {
				node = node.next;
			}
		}
		return result;
	}
}
