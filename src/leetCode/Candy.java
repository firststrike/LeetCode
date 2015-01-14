package leetCode;

/**
 * Created by gengyu.bi on 2014/12/23.
 */
public class Candy {
	public int candy(int[] ratings) {
		if (ratings == null || ratings.length == 0) {
			return 0;
		}
		int[] candy = new int[ratings.length];
		candy[0] = 1;
		int sum = 0;
		for (int i = 1; i < candy.length; i++) {
			if (ratings[i] > ratings[i - 1]) {
				candy[i] = candy[i - 1] + 1;
			} else {
				candy[i] = 1;
			}
		}
		for (int i = candy.length - 1; i > 0; i--) {
			sum += candy[i];
			if (ratings[i - 1] > ratings[i]) {
				candy[i - 1] = Math.max(candy[i] + 1, candy[i - 1]);
			}
		}
		sum += candy[0];
		return sum;
	}

	public static void main(String[] args) {
		Candy candy = new Candy();
		int r = candy.candy(new int[]{2, 2});
		System.out.println(r);
	}
}
