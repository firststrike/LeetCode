package leetCode;

/**
 * Created by gengyu.bi on 2015/1/9.
 */
public class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x) {
		val = x;
	}

	@Override
	public String toString() {
		return "TreeLinkNode{" +
				"val=" + val +
				'}';
	}
}
