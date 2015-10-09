package leetCode;

/*
 * Link : https://leetcode.com/problems/excel-sheet-column-number/
 */

public class _171ExcelSheetColumnNumber {
	public static int titleToNumber(String s) {
		int value=0;
		for (int i = s.length()-1; i >=0; i--) {
			int charCount=((int)s.charAt(i))-64;
			value+=Math.pow(26, s.length()-1-i)*charCount;
		}
		return value;
	}
	public static void main(String[] args) {
		System.out.println(titleToNumber("ZAA"));
	}
}