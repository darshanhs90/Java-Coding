package servicenowPrep;

public class _058SumPairArray
{

	public static void main(String[] args) {
		int inputArray[]=new int[] {1, 4,7,8, 10, 18};
		System.out.println(findSum(inputArray,175));
	}

	private static boolean findSum(int[] inputArray, int outputSum) {
		int left=0,right=inputArray.length-1;
		while(left<right)
		{
			int sum=inputArray[left]+inputArray[right];
			if(sum==outputSum)
				return true;
			else if(sum>outputSum)
				right--;
			else
				left++;
		}
		return false;
	}
}