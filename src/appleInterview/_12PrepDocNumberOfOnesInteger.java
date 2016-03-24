package appleInterview;

public class _12PrepDocNumberOfOnesInteger {
	public static void main(String[] args) {
		Integer x=123123;
		System.out.println(findOnes(x));
		System.out.println(findOnesBit(x));
	}

	private static int findOnesBit(Integer x) {
		int count=0;
		while(x>0)
		{
			count += x & 1;
			x >>= 1;
		}
		return count;
	}

	private static int findOnes(Integer x) {
		System.out.println(Integer.toBinaryString(x));
		return Integer.bitCount(x);
	}

}
