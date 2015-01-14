package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gengyu.bi on 2014/12/23.
 */
public class MajorityElement {
	public int majorityElement(int[] num) {
		Map<Integer, Integer> count = new HashMap<Integer, Integer>();
		for (int i = 0; i < num.length; i++) {
			if (count.containsKey(num[i])) {
				count.put(num[i], count.get(num[i]) + 1);
			} else {
				count.put(num[i], 1);
			}
		}
		for (Map.Entry<Integer, Integer> integer : count.entrySet()) {
			if (integer.getValue() >= num.length / 2 + 1) {
				return integer.getKey();
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		MajorityElement majorityElement = new MajorityElement();
		int r = majorityElement.majorityElement(new int[]{3, 2, 7, 1, 1, 3, 5, 1, 1, 1, 1, 1, 1, 2, 3, 3, 1, 1, 1, 1});
		System.out.println(r);
	}
}
