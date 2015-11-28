package GeeksforGeeksPractice;

/*
 * Link : http://www.geeksforgeeks.org/find-the-number-occurring-odd-number-of-times/
 */
public class _0103OddTimesNumberArray {
	public static void main(String[] args) {
		int inputArray[]={1, 2, 3, 2, 3, 1, 3};
		System.out.println(findOddTimedNumber(inputArray));
		
	}

	private static int findOddTimedNumber(int[] inputArray) {
		int result=inputArray[0];
		for (int i = 1; i < inputArray.length; i++) {
			result^=inputArray[i];
		}
		return result;
	}




}
