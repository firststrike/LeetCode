package leetCode;

/**
 * Created by gengyu.bi on 2014/12/30.
 */
public class SearchInsertPosition {
	public int searchInsert(int[] A, int target) {
		if (A == null || A.length == 0)
			return 0;
		if (A[0] > target)
			return 0;
		if (A[A.length - 1] < target)
			return A.length;
		int start = 0;
		int end = A.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (A[mid] == target)
				return mid;
			if (A[mid] < target) {
				if (mid == A.length - 1)
					return A.length;
				if (A[mid + 1] > target)
					return mid + 1;
				start = mid + 1;
			} else {
				end = mid-1;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
		int i = searchInsertPosition.searchInsert(new int[]{1, 3}, 4);
		System.out.println(i);
	}
}
