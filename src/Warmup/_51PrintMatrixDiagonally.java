package Warmup;

/*
 * Link: http://www.geeksforgeeks.org/print-matrix-diagonally/
*/	
public class _51PrintMatrixDiagonally {
	public static void main(String[] args) throws Exception {
		int inputArray[][] = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
                {17, 18, 19, 20},
               };
		printDiagonalMatrix(inputArray);
		
	}

	private static void printDiagonalMatrix(int[][] inputArray) {
		int rows=inputArray.length;
		int cols=inputArray[0].length;
		
		for (int line = 1; line <= rows+cols-1; line++) {
			int start_col=Math.max(0, line-rows);
			int count=Math.min(Math.min(line,cols-start_col),rows);
			for (int j=0; j<count; j++)
	            System.out.print(inputArray[Math.min(rows, line)-j-1][start_col+j]+"   ");
			System.out.println();
		}
		
	}
	
	
	
}
