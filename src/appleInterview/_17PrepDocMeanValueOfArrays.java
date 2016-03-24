package appleInterview;

public class _17PrepDocMeanValueOfArrays {
	public static void main(String[] args) {
		System.out.println(findMean(new int[]{1,3,5,7,9},new int[]{2,4,6,8}));
	}

	private static double findMean(int[] is, int[] is2) {
		int total=0;
		int count=is.length+is2.length;
		for (int i = 0; i < is.length; i++) {
			total+=is[i];
		}
		for (int i = 0; i < is2.length; i++) {
			total+=is2[i];
		}
		return total/count;
	}


}
