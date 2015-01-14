package leetCode;

/**
 * Created by gengyu.bi on 2014/12/24.
 */
public class SwapNodesInPairs {
	public ListNode swapPairs(ListNode head) {
		ListNode start = new ListNode(0);
		start.next = head;
		ListNode listNode = start;
		while (swap(listNode)) {
			listNode = listNode.next.next;
		}
		return start.next;
	}

	private boolean swap(ListNode listNode) {
		if (listNode.next == null || listNode.next.next == null) {
			return false;
		}
		ListNode listNode1 = listNode.next;
		ListNode listNode2 = listNode1.next;
		listNode.next = listNode2;
		listNode1.next = listNode2.next;
		listNode2.next = listNode1;
		return true;
	}

	public static void main(String[] args) {
		SwapNodesInPairs swapNodesInPairs = new SwapNodesInPairs();
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		l1.next = l2;
		l2.next = l3;
		//l3.next = l4;
		ListNode r = swapNodesInPairs.swapPairs(null);
		System.out.println("SwapNodesInPairs");
	}
}
