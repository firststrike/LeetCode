package leetCode;

/**
 * Created by gengyu.bi on 2015/1/8.
 */
public class PartitionList {
	public ListNode partition(ListNode head, int x) {
		if (head == null || head.next == null)
			return head;
		ListNode result = new ListNode(0);
		result.next = head;
		ListNode node = result;
		ListNode insert = result;
		while (node.next != null && node.next.val < x) {
			node = node.next;
			insert = insert.next;
		}
		while (node.next != null) {
			if (node.next.val < x) {
				ListNode thisNode = node.next;
				node.next = thisNode.next;
				thisNode.next = insert.next;
				insert.next = thisNode;
				insert = insert.next;
			} else
				node = node.next;
		}
		return result.next;
	}

	public static void main(String[] args) {
		PartitionList partitionList = new PartitionList();
		ListNode l1 = new ListNode(1);
		ListNode l4 = new ListNode(4);
		ListNode l3 = new ListNode(3);
		ListNode l21 = new ListNode(2);
		ListNode l5 = new ListNode(5);
		ListNode l22 = new ListNode(2);
		ListNode l2 = new ListNode(2);
		l1.next = l4;
		l4.next = l3;
		l3.next = l21;
		l21.next = l5;
		l5.next = l22;
		partitionList.partition(l1, 3);
		System.out.println("Partition List");
	}
}
