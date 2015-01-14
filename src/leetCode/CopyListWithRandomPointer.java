package leetCode;

/**
 * Created by gengyu.bi on 2015/1/12.
 */
public class CopyListWithRandomPointer {
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) {
			return null;
		}
		RandomListNode result = null;
		RandomListNode rNode = null;
		RandomListNode node = head;

		while (node != null) {
			rNode = new RandomListNode(node.label);
			if (result == null) {
				result = rNode;
			}
			rNode.next = node.next;
			node.next = rNode;
			node = node.next.next;
		}

		node = head;
		rNode = result;
		while (node != null) {
			if (node.random != null) {
				rNode.random = node.random.next;
			}
			node = node.next.next;
			if (rNode.next != null) {
				rNode = rNode.next.next;
			}
		}

		node = head;
		rNode = result;
		while (node != null) {
			node.next = node.next.next;
			if (rNode.next != null) {
				rNode.next = rNode.next.next;
			}
			node = node.next;
			rNode = rNode.next;
		}

		return result;
	}

	public static void main(String[] args) {
		CopyListWithRandomPointer copyListWithRandomPointer = new CopyListWithRandomPointer();
		RandomListNode r1 = new RandomListNode(1);
		RandomListNode r2 = new RandomListNode(2);
		//RandomListNode r3 = new RandomListNode(3);
		//RandomListNode r4 = new RandomListNode(4);
		r1.next = r2;
		//r2.next = r3;
		//r3.next = r4;
		//r1.random = r3;
		//r2.random = r4;
		copyListWithRandomPointer.copyRandomList(r1);
		System.out.println("Copy List with Random Pointer");
	}
}
