package leetCode;

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		ListNode listNode = new ListNode(2);
		ListNode result = listNode;
		int carry = 0;
		do {
			listNode.next = new ListNode(0);
			listNode = listNode.next;
			int m, n;
			if (l1 != null) {
				m = l1.val;
				l1 = l1.next;
			} else {
				m = 0;
			}
			if (l2 != null) {
				n = l2.val;
				l2 = l2.next;
			} else {
				n = 0;
			}
			int r = (m + n + carry) % 10;
			carry = (m + n + carry) / 10;
			listNode.val = r;
		} while (l1 != null || l2 != null);
		if (carry == 1) {
			listNode.next = new ListNode(1);
		}
		return result.next;
	}

	public static void main(String[] args) {
		AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
		ListNode l2 = new ListNode(2);
		ListNode l4 = new ListNode(4);
		ListNode l3 = new ListNode(3);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);
		ListNode l1 = new ListNode(1);
		l2.next = l4;
		l4.next = l3;
		l5.next = l6;
		l6.next = l1;
		ListNode r = addTwoNumbers.addTwoNumbers(l2, l5);
		System.out.println("AddTwoNumbers");
	}
}