package geeksforgeeks;



/*
 * http://www.geeksforgeeks.org/amazon-interview-3/	
 * Question was that a a matrix is given with its rows
 * and columns sorted and an element is to be searched in that matrix
 */;
 public class _01AmazonInterview_28_01 {
	 public static void main(String[] args) {
		 int [][]inputArray={{10, 20, 30, 40},
				 				{15, 25, 35, 45},
				 				{27, 29, 37, 48},
				 				{32, 33, 39, 50}};
		 System.out.println(findElement(inputArray,33));
	 }

	private static boolean findElement(int[][] inputArray, int element) {
		int topIndex=0,leftIndex=inputArray[0].length-1;
		while(topIndex<inputArray.length && leftIndex>=0)
		{
			if(element>inputArray[topIndex][leftIndex])
			{
				topIndex++;
			}else if(element<inputArray[topIndex][leftIndex]){
				leftIndex--;
			}
			else{
				System.out.println(topIndex+"//"+leftIndex);
				return true;
			}
		}
		
		
		return false;
	}
 }