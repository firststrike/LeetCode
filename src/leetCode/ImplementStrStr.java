package leetCode;

/**
 * Created by gengyu.bi on 2014/12/24.
 */
public class ImplementStrStr {
	public int strStr(String haystack, String needle) {
		return indexOf(haystack.toCharArray(), haystack.length(), needle.toCharArray(), needle.length(), 0);
	}

	private int indexOf(char[] source, int sourceCount, char[] target, int targetCount, int fromIndex) {
		if (fromIndex >= sourceCount) {
			return (targetCount == 0 ? sourceCount : -1);
		}
		if (fromIndex < 0) {
			fromIndex = 0;
		}
		if (targetCount == 0) {
			return fromIndex;
		}

		char first = target[0];
		int max = sourceCount - targetCount;

		for (int i = fromIndex; i <= max; i++) {
		    /* Look for first character. */
			if (source[i] != first) {
				while (++i <= max && source[i] != first) {
					;
				}
			}

            /* Found first character, now look at the rest of v2 */
			if (i <= max) {
				int j = i + 1;
				int end = j + targetCount - 1;
				for (int k = 1; j < end && source[j] == target[k]; j++, k++) {
					;
				}

				if (j == end) {
	                /* Found whole string. */
					return i;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		ImplementStrStr implementStrStr = new ImplementStrStr();
		int r = implementStrStr.strStr("12fs213fdw21sd3213", "213");
		System.out.println(r);
	}
}
