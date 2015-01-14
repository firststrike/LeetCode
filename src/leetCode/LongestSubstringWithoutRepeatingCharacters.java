package leetCode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int max = Integer.MIN_VALUE;
		do {
			Result result = getLength(s);
			if (result.length > max) {
				max = result.length;
			}
			if (max >= 93) {
				return max;
			}
			if (result.repeatIndex < 0) {
				break;
			} else {
				s = result.str;
			}
		} while (1 > 0);
		return max;
	}

	private Result getLength(String str) {
		char[] chars = str.toCharArray();
		Map<Character, Integer> charIndex = new HashMap<Character, Integer>();
		int length = str.length();
		for (int i = 0; i < chars.length; i++) {
			char c = chars[i];
			if (charIndex.get(c) == null) {
				charIndex.put(c, i);
			} else {
				length = i;
				int repeatIndex = charIndex.get(c) + 1;
				str = str.substring(repeatIndex);
				return new Result(length, repeatIndex, str);

			}
		}
		return new Result(length, -1, str);
	}
}

class Result {
	int length;
	int repeatIndex;
	String str;

	public Result(int length, int repeatIndex, String str) {
		this.length = length;
		this.repeatIndex = repeatIndex;
		this.str = str;
	}
}
