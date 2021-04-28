package May2021PrepLeetcode;

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
		String[] ver1Parts = version1.split("\\.");
		String[] ver2Parts = version2.split("\\.");
		int index1 = 0, index2 = 0;
		while (index1 < ver1Parts.length || index2 < ver2Parts.length) {
			int ver1 = 0;
			if (index1 < ver1Parts.length) {
				ver1 = Integer.parseInt(ver1Parts[index1]);
				index1++;
			}
			int ver2 = 0;
			if (index2 < ver2Parts.length) {
				ver2 = Integer.parseInt(ver2Parts[index2]);
				index2++;
			}
			if (ver1 < ver2) {
				return -1;
			} else if (ver1 > ver2) {
				return 1;
			}
		}
		return 0;
	}

}
