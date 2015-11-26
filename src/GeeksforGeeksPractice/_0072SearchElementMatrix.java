package GeeksforGeeksPractice;

/*
 * Link : http://www.geeksforgeeks.org/find-number-of-employees-under-every-manager/
 */
public class _0072SearchElementMatrix {

	public static void main(String[] args) {
		int mat[][] = new int[][]{ {10, 20, 30, 40},
			{15, 25, 35, 45},
			{27, 29, 37, 48},
			{32, 33, 39, 50}};
			System.out.println(searchMatrix(mat,29));
	}

	private static boolean searchMatrix(int[][] mat, int element) {
		int rowIndex=0,colIndex=mat.length-1;
		while(rowIndex<mat.length && colIndex>=0)
		{
			if(mat[rowIndex][colIndex]>element)
				colIndex--;
			else if(mat[rowIndex][colIndex]<element)
				rowIndex++;
			else
				return true;
		}
		return false;
	}





}
