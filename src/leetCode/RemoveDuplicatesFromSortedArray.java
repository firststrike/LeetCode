package leetCode;

public class RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		int index = 1;
		for (int i = 1; i < A.length; i++) {
			if (A[i] != A[i - 1]) {
				A[index] = A[i];
				index++;
			}
		}
		return index;
	}

	public static void main(String[] args) {
		RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray();
		int r = removeDuplicatesFromSortedArray.removeDuplicates(new int[]{1, 1, 2, 2, 2, 3});
		System.out.println(r);
	}
}
