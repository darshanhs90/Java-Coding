package PracticeLeetCode;

public class _014LongestCommonPrefix {

	public static void main(String[] args) {
		System.out.println(longestCommonPrefix(new String[]{"abb","abc"}));
	}
	public static String longestCommonPrefix(String[] strs) {
		if(strs==null||strs.length==0)
			return "";
		int minPrefixLength=strs[0].length();
		for (int i = 0; i < strs.length; i++) {
			minPrefixLength=Math.min(minPrefixLength,strs[i].length());
		}

		for (int i = 0; i < minPrefixLength; i++) {
			char c=strs[0].charAt(i);
			for (int j = 1; j < strs.length; j++) {
				if(strs[j].charAt(i)!=c)
				{
					return strs[j].substring(0, i);
				}
			}
		}
		return strs[0].substring(0, minPrefixLength);
	}



}
