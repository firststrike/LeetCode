package leetCode;

/**
 * Created by gengyu.bi on 2014/12/24.
 */
public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode listNode = new ListNode(0);
		ListNode result = listNode;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				listNode.next = l1;
				l1 = l1.next;
			} else {
				listNode.next = l2;
				l2 = l2.next;
			}
			listNode = listNode.next;
		}
		if (l1 == null) {
			listNode.next = l2;
		} else {
			listNode.next = l1;
		}
		return result.next;
	}

	public static void main(String[] args) {
		MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
		ListNode l1 = new ListNode(1);
		ListNode l3 = new ListNode(3);
		ListNode l5 = new ListNode(5);
		ListNode l7 = new ListNode(7);
		ListNode l2 = new ListNode(2);
		ListNode l4 = new ListNode(4);
		ListNode l6 = new ListNode(6);
		l1.next = l3;
		l3.next = l5;
		l5.next = l7;
		l2.next = l4;
		l4.next = l6;
		ListNode listNode = mergeTwoSortedLists.mergeTwoLists(null, null);
		System.out.println("MergeTwoSortedLists");
	}
}
