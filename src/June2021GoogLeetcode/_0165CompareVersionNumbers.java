package June2021GoogLeetcode;

public class _0165CompareVersionNumbers {

	public static void main(String[] args) {
		System.out.println(compareVersion("1.01", "1.001"));
		System.out.println(compareVersion("1.0", "1.0.0"));
		System.out.println(compareVersion("0.1", "1.1"));
		System.out.println(compareVersion("1.0.1", "1"));
		System.out.println(compareVersion("7.5.2.4", "7.5.3"));
		System.out.println(compareVersion("100", "100"));
		System.out.println(compareVersion("100", "200"));
		System.out.println(compareVersion("200", "100"));
	}

	public static int compareVersion(String version1, String version2) {
		// If version1 < version2, return -1.
		// If version1 > version2, return 1.
		// Otherwise, return 0.
		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");
		int index1 = 0, index2 = 0;
		while (index1 < v1.length || index2 < v2.length) {
			if (index1 < v1.length && index2 < v2.length) {
				int val1 = Integer.parseInt(v1[index1]);
				int val2 = Integer.parseInt(v2[index2]);

				if (val1 == val2) {
					index1++;
					index2++;
				} else {
					return val1 > val2 ? 1 : -1;
				}
			} else if (index1 < v1.length) {
				int val1 = Integer.parseInt(v1[index1]);
				int val2 = 0;

				if (val1 == val2) {
					index1++;
				} else {
					return val1 > val2 ? 1 : -1;
				}
			} else {
				int val1 = 0;
				int val2 = Integer.parseInt(v2[index2]);

				if (val1 == val2) {
					index2++;
				} else {
					return val1 > val2 ? 1 : -1;
				}
			}
		}
		return 0;
	}

}
