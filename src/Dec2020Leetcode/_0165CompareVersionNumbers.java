package Dec2020Leetcode;

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

		String[] str1 = version1.split("\\.");
		String[] str2 = version2.split("\\.");
		int index = 0;
		while (index < str1.length || index < str2.length) {
			if (index < str1.length && index < str2.length) {
				if (Integer.parseInt(str1[index]) > Integer.parseInt(str2[index]))
					return 1;
				else if (Integer.parseInt(str1[index]) < Integer.parseInt(str2[index]))
					return -1;
			} else if (index < str1.length) {
				if (Integer.parseInt(str1[index]) > 0)
					return 1;
			} else {// index<str2.length
				if (Integer.parseInt(str2[index]) > 0)
					return -1;
			}
			index++;
		}

		return 0;

	}

}
