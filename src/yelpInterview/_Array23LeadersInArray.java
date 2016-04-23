package yelpInterview;

public class _Array23LeadersInArray {
	public static void main(String a[]){
		int inputArray[] ={16, 17, 4, 3, 5, 2};
		printLeaders(inputArray);
	}

	private static void printLeaders(int[] inputArray) {
		int max=inputArray[inputArray.length-1];
		System.out.println(max);
		for (int i = inputArray.length-1;i>=0; i--) {
			if(inputArray[i]>max)
			{
				System.out.println(inputArray[i]);
				max=inputArray[i];
			}
		}

	}


}