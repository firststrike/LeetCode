package leetCode;

/**
 * Created by gengyu.bi on 2015/1/4.
 */
public class RemoveDuplicatesFromSortedArrayII {
	public int removeDuplicates(int[] A) {
		if (A == null || A.length == 0)
			return 0;
		int count = 1;
		int index = 0;
		for (int i = 1; i < A.length; i++) {
			if (A[index] == A[i]) {
				if (count == 2) {
					continue;
				}
				count++;
			} else {
				count = 1;
			}
			A[++index] = A[i];
		}
		return index + 1;
	}

	public static void main(String[] args) {
		RemoveDuplicatesFromSortedArrayII removeDuplicatesFromSortedArrayII = new RemoveDuplicatesFromSortedArrayII();
		removeDuplicatesFromSortedArrayII.removeDuplicates(new int[]{1, 1, 1, 1, 2, 2, 2, 3, 4, 4, 4});
		System.out.println("Remove Duplicates from Sorted Array II");
	}
}
