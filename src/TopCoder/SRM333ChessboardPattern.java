package TopCoder;

import java.util.Arrays;

/*
 * SRM 333 Div1
 * Link:https://community.topcoder.com/stat?c=problem_statement&pm=7259
 */

public class SRM333ChessboardPattern {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(makeChessboard(8, 8)));
		System.out.println(Arrays.toString(makeChessboard(1, 20)));
		System.out.println(Arrays.toString(makeChessboard(5, 1)));
		System.out.println(Arrays.toString(makeChessboard(5, 13)));
	}
	public static String[] makeChessboard(int rows, int columns){
		String[] outputArray=new String[rows];
		StringBuilder firstString=new StringBuilder();
		StringBuilder secondString=new StringBuilder();
		for (int i = 0; i < columns; i++) {
			if(i%2==0){
				firstString.append(".");
				secondString.append("X");
			}
			else{
				firstString.append("X");
				secondString.append(".");
			}
		}
		int counter=0;
		for (int i = rows-1;i>=0; i--) {
			outputArray[i]=(counter%2==0)?firstString.toString():secondString.toString();
			counter++;
		}
		return outputArray;
	}
}
