package yelpInterview;

public class _Array20SecondSmallest {

	public static void main(String a[]){
		int inputArray[] ={12, 13, 1, 10, 34, 1};
		findSmallest(inputArray);
	}

	private static void findSmallest(int[] inputArray) {
		int first=Integer.MAX_VALUE;
		int second=Integer.MAX_VALUE;
		for (int i = 0; i < inputArray.length; i++) {
			if(inputArray[i]<first)
			{
				first=inputArray[i];
			}
			else if(inputArray[i]>first && inputArray[i]<second && first!=second)
			{
				second=inputArray[i];
			}
		}
		System.out.println(first);
		System.out.println(second);
		
	}

	


}