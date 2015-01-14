package leetCode;

public class LengthOfLastWord {
	public int lengthOfLastWord(String s) {
		if (s == null) {
			return 0;
		} else {
			s = s.trim();
			if (s.equals("")) {
				return 0;
			} else {
				char[] charArray = s.toCharArray();
				int space = -1;
				for (int i = charArray.length - 1; i >= 0; i--) {
					char c = charArray[i];
					if (c == 32) {
						space = i;
						break;
					}
				}
				if (space == -1) {
					return charArray.length;
				} else {
					return charArray.length - space - 1;
				}
			}
		}
	}
}
