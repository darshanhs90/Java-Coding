package appleInterview;

public class _06PrepDocFindTwoMissingElements {
	public static void main(String[] args) {
		findTwoMissingElements(new int[]{1,2,4});
	}

	private static void findTwoMissingElements(int[] is) {
		int sum=0;
		int product=1;
		int N=is.length+2;
		int fullSum=0,fullProduct=1;
		for (int i = 0; i < is.length; i++) {
			product*=is[i];
			sum+=is[i];
			fullProduct*=i+1;
		}
		fullProduct*=N;
		fullProduct*=N-1;
		fullSum=N*(N+1)/2;
		int SUM=fullSum-sum;
		int PRODUCT=fullProduct/product;
		System.out.println((int)(SUM/2 + Math.sqrt(SUM*SUM - 4*PRODUCT)/(double)2));
		System.out.println((int)(SUM/2 - Math.sqrt(SUM*SUM - 4*PRODUCT)/2));
	}



}
