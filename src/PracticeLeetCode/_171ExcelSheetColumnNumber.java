package PracticeLeetCode;

public class _171ExcelSheetColumnNumber {
	//http://www.programcreek.com/2014/03/leetcode-excel-sheet-column-number-java/
	public static int titleToNumber(String s) {
		int value=0;
		int index=0;
		while(index<s.length())
		{
			value=value*26+(s.charAt(index)-'A'+1);
			index++;
		}
		return value;
	}

	public static void main(String[] args) {
		System.out.println(titleToNumber("JQ"));	
	}
}
