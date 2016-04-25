package yelpInterview;

public class _Array32MaxCircularSum {
	public static void main(String a[]){
		int inputArray[]=new int[]{8, -8, 9, -9, 10, -11, 12};
		System.out.println(findMaxCircularSum(inputArray));
		inputArray= new int[]{10, -3, -4, 7, 6, 5, -4, -1};
		System.out.println(findMaxCircularSum(inputArray));
		inputArray= new int[]{-1, 40, -14, 7, 6, 5, -4, -1};
		System.out.println(findMaxCircularSum(inputArray));
	}

	private static int findMaxCircularSum(int[] inputArray) {
		int kdn=findMaxCircularSumUtil(inputArray);
		int arraySum=0;
		for (int i = 0; i < inputArray.length; i++) {
			arraySum+=inputArray[i];
			inputArray[i]=-1*inputArray[i];
		}
		int kdn1=arraySum+findMaxCircularSumUtil(inputArray);
		return Math.max(kdn, kdn1);
	}

	private static int findMaxCircularSumUtil(int[] inputArray) {
		int incl=0;
		int excl=0;
		for (int i = 0; i < inputArray.length; i++) {
			incl+=inputArray[i];
			if(incl<0)
				incl=0;
			excl=Math.max(excl, incl);
		}		
		return excl;
	}
}