package leetCode;

public class ReorderList {
	public void reorderList(ListNode head) {
		//取中点
		if (head == null)
			return;
		ListNode slow = head;
		ListNode fast = head;
		while (true) {
			if (fast.next == null)
				break;
			fast = fast.next;
			if (fast.next == null)
				break;
			fast = fast.next;
			slow = slow.next;
		}
		//翻转
		ListNode node = slow.next;
		slow.next = null;
		ListNode l1 = head;
		ListNode l2 = null;
		while (node != null) {
			if (l2 == null) {
				l2 = node;
				node = node.next;
				l2.next = null;
			} else {
				ListNode preNode = node.next;
				node.next = l2;
				l2 = node;
				node = preNode;
			}
		}
		//合并
		while (l2 != null) {
			ListNode node_L1 = l1;
			ListNode node_L2 = l2;
			l1 = l1.next;
			l2 = l2.next;
			node_L2.next = l1;
			node_L1.next = node_L2;
		}
	}

	public static void main(String[] args) {
		ReorderList reorderList = new ReorderList();
		ListNode l1 = new ListNode(1);
		reorderList.reorderList(l1);
		System.out.println("ReorderList");
	}
}
