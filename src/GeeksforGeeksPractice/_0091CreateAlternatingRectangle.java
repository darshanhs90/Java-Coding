package GeeksforGeeksPractice;

import java.util.Arrays;

/*
 * Link : http://www.geeksforgeeks.org/create-a-matrix-with-alternating-rectangles-of-0-and-x/
 */
public class _0091CreateAlternatingRectangle {
	static char[][] mat;
	public static void main(String[] args) {
		createAlternatingRectangles(3,3);System.out.println("-****************-");
		createAlternatingRectangles(4,5);System.out.println("-****************-");
		createAlternatingRectangles(5,5);System.out.println("-****************-");
		createAlternatingRectangles(6,7);
	}






	private static void createAlternatingRectangles(int noOfRows, int noOfCols) {
		mat=new char[noOfRows][noOfCols];
		int k=0,l=noOfRows,m=0,n=noOfCols;
		char x='X';
		while(k<l && m<n)
		{
			//first row
			for (int i = m; i <n; i++) {
				mat[k][i]=x;
			}
			k++;
			//last column
			for (int i = k; i < l; i++) {
				mat[i][n-1]=x;
			}
			n--;


			//last row-under condition
			if(m<n)
				for (int i = n-1; i >=m; i--) {
					mat[l-1][i]=x;
				}
			l--;


			//first column-under condition
			if(k<l)
				for (int i = l-1; i >=k; i--) {
					mat[i][m]=x;
				}
			m++;

			x=x=='X'?'O':'X';





		}
		printMatrix(mat);
	}






	private static void printMatrix(char[][] s) {
		for (int i = 0; i < s.length; i++) {
			System.out.println(Arrays.toString(s[i]));
		}

	}


}
