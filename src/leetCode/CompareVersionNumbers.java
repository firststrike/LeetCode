package leetCode;

/**
 * Created by gengyu.bi on 2014/12/26.
 */
public class CompareVersionNumbers {
	public int compareVersion(String version1, String version2) {
		if (version1.equals("") && version2.equals("")) {
			return 0;
		}
		if (version1.equals("")) {
			return -1;
		}
		if (version2.equals("")) {
			return 1;
		}
		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");
		int index = 0;
		while (index < v1.length && index < v2.length) {
			int i1 = Integer.valueOf(v1[index]);
			int i2 = Integer.valueOf(v2[index]);
			if (i1 > i2) {
				return 1;
			}
			if (i1 < i2) {
				return -1;
			}
			index++;
		}
		if (v1.length == v2.length) {
			return 0;
		}
		String[] other;
		int r;
		if (v1.length > v2.length) {
			other = v1;
			r = 1;
		} else {
			other = v2;
			r = -1;
		}
		while (index < other.length) {
			int o = Integer.valueOf(other[index]);
			if (o > 0) {
				return r;
			}
			index++;
		}
		return 0;
	}

	public static void main(String[] args) {
		CompareVersionNumbers compareVersionNumbers = new CompareVersionNumbers();
		int r = compareVersionNumbers.compareVersion("1.0.0000.00.0.00.00.01", "1.0");
		System.out.println(r);
	}
}
