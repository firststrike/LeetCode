package leetCode;

/**
 * Created by gengyu.bi on 2014/12/30.
 */
public class SearchForARange {
	public int[] searchRange(int[] A, int target) {
		int[] result = new int[]{-1, -1};
		if (A == null || A.length == 0)
			return result;
		int[] start = new int[]{0, A.length - 1};
		int[] end = new int[]{0, A.length};
		if (A[0] > target || A[A.length - 1] < target)
			return result;
		while (start[0] < start[1]) {
			int mid = (start[0] + start[1]) / 2;
			if (A[mid] < target) {
				start[0] = mid + 1;
				continue;
			}
			start[1] = mid;
		}
		if (A[start[0]] != target)
			return result;
		end[0] = start[1];
		while (end[0] < end[1]) {
			int mid = (end[0] + end[1]) / 2;
			if (A[mid] > target) {
				end[1] = mid;
				continue;
			}
			end[0] = mid + 1;
		}
		return new int[]{start[0], end[0] - 1};
	}

	public static void main(String[] args) {
		SearchForARange searchForARange = new SearchForARange();
		int[] r = searchForARange.searchRange(new int[]{1}, 1);
		System.out.println(r);
	}
}
