package LeetCodePerformancePractice;

public class _014LongestCommonPrefix {

	public static void main(String[] args) {
		System.out.println(longestCommonPrefix(new String[]{}));
	}

	private static String longestCommonPrefix(String[] strings) {
		if(strings==null ||strings.length==0)
			return "";
		int minLength=Integer.MAX_VALUE;
		for (int i = 0; i < strings.length; i++) {
			minLength=Math.min(strings[i].length(), minLength);
		}
		for (int i = 0; i < minLength; i++) {
			char c=strings[0].charAt(i);
			for (int j = 1; j < strings.length; j++) {
				if(strings[j].charAt(i)!=c)
				{
					return strings[j].substring(0, i);
				}
			}
		}
		return strings[0].substring(0, minLength);
	}




}
