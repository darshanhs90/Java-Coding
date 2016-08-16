package LeetCodePerformancePractice;

public class _014LongestCommonPrefix {

	public static void main(String[] args) {
		System.out.println(longestCommonPrefix(new String[]{}));
	}
	public static String longestCommonPrefix(String[] strs) {
		int minLength=Integer.MAX_VALUE;
		for (int i = 0; i < strs.length; i++) {
			minLength=Math.min(minLength, strs[i].length());
		}
		if(strs.length>0)
			for (int i = 0; i < minLength; i++) {
				char c=strs[0].charAt(i);
				for (int j = 1; j < strs.length; j++) {
					if(c!=strs[j].charAt(i))
					{
						return strs[j].substring(0, i);
					}
				}
			}
		return strs.length>0?strs[0].substring(0, minLength):"";
	}
}
