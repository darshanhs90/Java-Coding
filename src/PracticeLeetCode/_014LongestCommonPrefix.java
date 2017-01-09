package PracticeLeetCode;

public class _014LongestCommonPrefix {

	public static void main(String[] args) {
		System.out.println(longestCommonPrefix(new String[]{"abb","abc"}));
	}
	public static String longestCommonPrefix(String[] strs) {
		if(strs==null||strs.length==0)
			return "";
		int minLength=Integer.MAX_VALUE;
		for (int i = 0; i < strs.length; i++) {
			minLength=Math.min(strs[i].length(), minLength);
		}
		for (int i = 0; i < minLength; i++) {
			char c=strs[0].charAt(i);
			for (int j = 1; j < strs.length; j++) {
				if(c!=strs[j].charAt(i))
					return strs[j].substring(0, i);
			}
		}
		return strs[0].substring(0, minLength);
	}

}
