package eBayPrep;

public class _010LongestCommonPrefix {

	public static void main(String[] args) {
		System.out.println(longestCommonPrefix(new String[]{"c","c"}));
	}
	public static String longestCommonPrefix(String[] strArray) {
		if(strArray.length==0)
			return "";
		if(strArray.length==1)
			return strArray[0];
		int maxLength=Integer.MAX_VALUE;
		for (int i = 0; i < strArray.length; i++) {
			maxLength=Math.min(strArray[i].length(), maxLength);
		}
		if(maxLength==0)return "";
		for (int i = 0; i < maxLength; i++) {
			for (int j = 0; j < strArray.length-1; j++) {
				if(strArray[j].charAt(i)!=strArray[j+1].charAt(i))
				{
					return strArray[j].substring(0, i);
				}
			}
		}
		return strArray[0].substring(0, maxLength);
	}
}
