package leetCode;

public class IntersectionOfTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		int lengthA = 0;
		int lengthB = 0;
		ListNode a = headA;
		ListNode b = headB;
		while (a != null) {
			lengthA++;
			a = a.next;
		}
		while (b != null) {
			lengthB++;
			b = b.next;
		}
		if (lengthA > lengthB) {
			for (int i = 0; i < lengthA - lengthB; i++) {
				headA = headA.next;
			}
		} else if (lengthB > lengthA) {
			for (int i = 0; i < lengthB - lengthA; i++) {
				headB = headB.next;
			}
		}
		while (headA != null && headB != null) {
			if (headA == headB) {
				return headA;
			}
			headA = headA.next;
			headB = headB.next;
		}
		return null;
	}
}
