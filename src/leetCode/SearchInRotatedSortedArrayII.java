package leetCode;

/**
 * Created by gengyu.bi on 2015/1/7.
 */
public class SearchInRotatedSortedArrayII {
	public boolean search(int[] A, int target) {
		if (A == null || A.length == 0)
			return false;
		int start = 0;
		int end = A.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (A[mid] == target)
				return true;
			if (A[mid] == A[start]) {
				start++;
			} else if (A[mid] >= A[start]) {
				if (A[start] <= target && target <= A[mid])
					end = mid - 1;
				else
					start = mid + 1;
			} else {
				if (A[mid] >= target || target >= A[start])
					end = mid - 1;
				else
					start = mid + 1;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		SearchInRotatedSortedArrayII searchInRotatedSortedArray = new SearchInRotatedSortedArrayII();
		boolean r = searchInRotatedSortedArray.search(new int[]{1, 3, 1, 1, 1}, 1);
		System.out.println(r);
	}
}
