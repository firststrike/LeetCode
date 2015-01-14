package leetCode;

/**
 * Created by gengyu.bi on 2014/12/31.
 */
public class SearchInRotatedSortedArray {
	public int search(int[] A, int target) {
		if (A == null || A.length == 0)
			return -1;
		int start = 0;
		int end = A.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (A[mid] == target)
				return mid;
			if (A[mid] >= A[start]) {
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
		return -1;
	}

	public static void main(String[] args) {
		SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();
		int r = searchInRotatedSortedArray.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0);
		System.out.println(r);
	}
}
