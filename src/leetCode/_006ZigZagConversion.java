package leetCode;

/*
 * Link : https://leetcode.com/problems/zigzag-conversion/
 */

public class _006ZigZagConversion {
	public static String convert(String s, int numRows) {
		if(numRows==1)
			return s;
		
		
		char[][] elementArray=new char[numRows][s.length()];
		boolean backFlag=false;
		int rowIndex=0,colIndex=0;
		for (int i = 0; i < s.length(); i++) {

			if(rowIndex>numRows-1){
				rowIndex--;
				rowIndex--;
				backFlag=true;
				colIndex++;
			}
			else if(backFlag)
			{
				rowIndex--;
				colIndex++;
			}
			if(rowIndex<0)
			{
				rowIndex++;
				rowIndex++;
				backFlag=false;
				colIndex--;
			}
			elementArray[rowIndex][colIndex]=s.charAt(i);
			if(!backFlag)
				rowIndex++;
		}
		StringBuffer sb=new StringBuffer();
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < s.length(); j++) {
				if(elementArray[i][j]!=' ')
					sb.append(String.valueOf(elementArray[i][j]).trim());
			}
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		System.out.println(convert("paypalishiring",3));
	}
}