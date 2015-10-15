package leetCode;

/*
 * Link : https://leetcode.com/problems/excel-sheet-column-title/
 */

public class _168ExcelSheetColumnTitle {
	public static String convertToTitle(int n) {
		StringBuffer sb=new StringBuffer();
		while(n>0)
		{	
			n--;
			sb.append((char)(n%26+'A'));
			n=n/26;
		}
		return sb.reverse().toString();
	}
	public static void main(String[] args) {
		System.out.println(convertToTitle(26));
	}
}