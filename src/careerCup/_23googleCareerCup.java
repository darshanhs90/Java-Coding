package careerCup;

/*
 * Link: http://www.careercup.com/question?id=244743
 * Find the median of 2 sorted arrays
 * http://www.geeksforgeeks.org/median-of-two-sorted-arrays/
 */
public class _23googleCareerCup {
	public static void main(String[] args) {
		int inputArray1[]=new int[]{1,5,7,10,13};
		int inputArray2[]=new int[]{11,15,23,30,45};
		System.out.println(findMedian(inputArray1,inputArray2,0,inputArray1.length-1,inputArray1.length));
	}

	private static int findMedian(int[] ar1, int[] ar2, int left, int right, int n) {
		int i,j;
		i=(left+right)/2;
		j=n-i-1;
		if (left > right)
			return findMedian(ar2, ar1, 0, n-1, n);
		if (ar1[i] > ar2[j] && (j == n-1 || ar1[i] <= ar2[j+1]))
		{
			if (i == 0 || ar2[j] > ar1[i-1])
				return (ar1[i] + ar2[j])/2;
			else
				return (ar1[i] + ar1[i-1])/2;
		}
		else if (ar1[i] > ar2[j] && j != n-1 && ar1[i] > ar2[j+1])
			return findMedian(ar1, ar2, left, i-1, n);
		else 
			return findMedian(ar1, ar2, i+1, right, n);
	}
}
