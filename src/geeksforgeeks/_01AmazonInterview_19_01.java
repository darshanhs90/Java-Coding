package geeksforgeeks;




/*
 * http://www.geeksforgeeks.org/amazon-interview-set-18/
 * Determine if a matrix is a cross-matrix.
 * A cross-matrix is a one in which all the diagonal elements 
 * are same and not repeated anywhere else.
 */;
 public class _01AmazonInterview_19_01 {
	 public static void main(String[] args) {
		 int inputMatrix1[][]={	{1,2,3},
				 				{2,1,3},
				 				{2,2,1}	};
		 System.out.println("Cross Matrix :"+checkMatrix(inputMatrix1));
		 int inputMatrix2[][]={	{1,2,3},
	 							{2,1,3},
	 							{2,1,1}	};
		 System.out.println("Cross Matrix :"+checkMatrix(inputMatrix2)); 

	 }

	private static boolean checkMatrix(int[][] inputMatrix) {
		// TODO Auto-generated method stub
		int element=inputMatrix[0][0];
		for (int i = 0; i < inputMatrix.length; i++) {
			for (int j = 0; j < inputMatrix[0].length; j++) {
				if(i==j){
					if(inputMatrix[i][j]!=element)
						return false;
				}else{
					if(inputMatrix[i][j]==element)
						return false;
				}
			}
		}
		return true;
	}

	
 }