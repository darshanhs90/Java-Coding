package yelpInterview;

public class _Leetcode04ZigZagConversion {


	public static void main(String[] args) {
		System.out.println(convert("ABC", 1));
	}


	public static String convert(String s, int numRows) {
		char[][] charMatrix=new char[numRows][s.length()];
		boolean down=true;
		int rowIndex=0,colIndex=0;
		if(numRows<=1)
			return s;
		for (int i = 0; i < s.length(); i++) {
			if(down)//down straight
			{	
				if(rowIndex<0)
					rowIndex=0;
				charMatrix[rowIndex][colIndex]=s.charAt(i);
				rowIndex++;
				if(rowIndex==numRows){
					rowIndex=charMatrix.length-2;
					colIndex++;
					down=!down;
				}
			}
			else{//up diagonal
				if(rowIndex<0)
					rowIndex=0;
				charMatrix[rowIndex][colIndex]=s.charAt(i);
				rowIndex--;
				if(rowIndex<0)
				{
					rowIndex+=2;
					down=!down;
				}
				colIndex++;
				if(rowIndex==0){
					down=!down;
				}
			}
		}
		StringBuffer sb=new StringBuffer();
		for (int i = 0; i < charMatrix.length; i++) {
			for (int j = 0; j < charMatrix[0].length; j++) {
				if(charMatrix[i][j]!=' ')
					sb.append(String.valueOf(charMatrix[i][j]).trim());
			}
		}
		return sb.toString();
	}



}

