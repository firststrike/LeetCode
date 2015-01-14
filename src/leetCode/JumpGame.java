package leetCode;

/**
 * Created by gengyu.bi on 2014/12/23.
 */
public class JumpGame {
	public boolean canJump(int[] A) {
		if (A.length <= 1) {
			return true;
		}
		if (A[0] >= A.length - 1) {
			return true;
		}
		int maxlength = A[0];
		if (maxlength == 0) {
			return false;
		}
		for (int i = 1; i < A.length - 1; i++) {
			if (maxlength >= i && i + A[i] >= A.length - 1) {
				return true;
			}
			if (maxlength <= i && A[i] == 0) {
				return false;
			}
			if ((i + A[i]) > maxlength) {
				maxlength = i + A[i];
			}
		}
		return false;
	}

	public static void main(String[] args) {
		JumpGame jumpGame = new JumpGame();
		boolean r = jumpGame.canJump(new int[]{3, 2, 1, 0, 4});
		System.out.println(r);
	}
}
