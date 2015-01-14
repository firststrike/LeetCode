package leetCode;

/**
 * Created by gengyu.bi on 2014/12/30.
 */
public class RotateList {
	// 指针遍历链表，得到长度length，同时将链表头尾相连
	// 接着指针再继续移动length - k % length 得到结果链表的尾和头
	// 切断链表，返回头结点
	public ListNode rotateRight(ListNode head, int n) {
		if (head == null)
			return head;
		int index = 0;
		ListNode node = head;
		while (node.next != null) {
			node = node.next;
			index++;
		}
		int length = index + 1;
		index = 0;
		node.next = head;
		while (index < length - n % length) {//取余用于
			node = node.next;
			index++;
		}
		head = node.next;
		node.next = null;
		return head;
	}

	public static void main(String[] args) {
		RotateList rotateList = new RotateList();
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		rotateList.rotateRight(l1, 2);
		System.out.println("RotateList");
	}
}
