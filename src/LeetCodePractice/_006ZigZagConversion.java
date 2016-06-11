package LeetCodePractice;

public class _006ZigZagConversion {

	public static void main(String[] args) {
		System.out.println(convert("PAYPALISHIRING",3));
		System.out.println(convert("ABCD",2));
		System.out.println(convert("AB",1));
		System.out.println(convert("AB",2));
		
	}
	public static String convert(String s, int numRows) {
		char [][]charMatrix=new char[numRows][s.length()];
		if(numRows<=1||s.length()<2)
			return s;
		int row=0,col=0;
		boolean goingDown=true;
		for (int i = 0; i < s.length(); i++) {
			if(goingDown)//moving down
			{	

				charMatrix[row][col]=s.charAt(i);
				if(row+1==numRows)
				{
					row=row-1;
					goingDown=!goingDown;
					col=col+1;
				}
				else{
					row=row+1;
				}
			}
			else{//moving diagonally up
				charMatrix[row][col]=s.charAt(i);
				if(row-1<0)
				{
					row=row+1;
					goingDown=!goingDown;
				}
				else{
					row=row-1;
					col=col+1;
				}
			}
		}
		StringBuilder sb=new StringBuilder();
		for (int i = 0; i < charMatrix.length; i++) {
			for (int j = 0; j < charMatrix[0].length; j++) {
				if((charMatrix[i][j]+"").trim().length()>0)
					sb.append(charMatrix[i][j]);
			}
		}
		return sb.toString();
	}
}
