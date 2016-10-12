package PracticeLeetCode;

public class _191NumberOf1Bits {
	//http://www.programcreek.com/2014/03/leetcode-number-of-1-bits-java/
	public static int hammingWeight(int n) {
		int count=0;
		for (int i = 1; i <33; i++) {
			count+=getBit(i,n)?1:0;
		}
		return count;
	}

	private static boolean getBit(int i, int n) {
		return (n &(1<<i))!=0;
	}

	public static void main(String[] args) {
		System.out.println(hammingWeight(11));
	}
}