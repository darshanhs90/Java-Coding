package eBayPrep;

public class _171ExcelSheetColumnNumber {

	public static void main(String[] args) {
		System.out.println(titleToNumber("Z"));
		System.out.println(titleToNumber("ABA"));
	}

	public static int titleToNumber(String s) {
		int value=0;
		for (int i = 0; i < s.length(); i++) {
			value+=Math.pow(26,s.length()-1-i)*(s.charAt(i)-'A'+1);
		}
		return value;
		
	}
}

