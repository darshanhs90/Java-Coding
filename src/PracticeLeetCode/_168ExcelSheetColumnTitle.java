package PracticeLeetCode;

public class _168ExcelSheetColumnTitle {
	//http://www.programcreek.com/2014/03/leetcode-excel-sheet-column-title-java/
    public static String convertToTitle(int n) {
    	if(n==0)
    		return "";
    	StringBuilder sb=new StringBuilder();
    	while(n>0)
    	{
    		n--;
    		sb.append((char)(n%26+'A'));
    		n=n/26;
    	}
    	return sb.reverse().toString();
    }
    
    public static void main(String[] args) {
		System.out.println(convertToTitle(277));
	}
}
