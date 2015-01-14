package leetCode;

/**
 * Created by gengyu.bi on 2014/12/31.
 */
public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode result = null;
		ListNode node = head;
		while (node != null) {
			ListNode thisNode = node;
			node = node.next;
			thisNode.next = null;
			result = insert(result, thisNode);
		}
		return result;
	}

	private ListNode insert(ListNode head, ListNode node) {
		if (head == null)
			return node;
		if (node.val <= head.val) {
			node.next = head;
			return node;
		} else {
			ListNode index = head;
			while (index.next != null) {
				if (node.val > index.next.val) {
					index = index.next;
				} else {
					node.next = index.next;
					index.next = node;
					return head;
				}
			}
			index.next = node;
			return head;
		}
	}

	public static void main(String[] args) {
		InsertionSortList insertionSortList = new InsertionSortList();
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);
		ListNode l7 = new ListNode(7);
		ListNode l8 = new ListNode(8);
		ListNode l9 = new ListNode(9);
		l5.next = l1;
		l1.next = l4;
		l4.next = l9;
		l9.next = l3;
		l3.next = l7;
		l7.next = l2;
		l2.next = l8;
		l8.next = l6;
		insertionSortList.insertionSortList(l5);
		System.out.println("InsertionSortList");
	}
}
