package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gengyu.bi on 2014/12/30.
 */
public class GrayCode {
	public List<Integer> grayCode(int n) {
		List<Integer> result = new ArrayList<Integer>();
		if (n == 0) {
			result.add(0);
			return result;
		}
		result = grayCode(n - 1);
		int highestBit = 1 << (n - 1);
		int length = result.size();
		for (int i = 0; i < length; i++) {
			result.add(highestBit + result.get(length - 1 - i));
		}
		return result;
	}

	public static void main(String[] args) {
		GrayCode grayCode = new GrayCode();
		grayCode.grayCode(3);
		System.out.println("GrayCode");
	}
}
