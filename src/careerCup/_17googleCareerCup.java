package careerCup;

/*
 * Link: http://www.careercup.com/question?id=198698
 * Given 2 sorted array print their intersection.
 */
public class _17googleCareerCup {

	public static void main(String[] args) {
		int inputArray1[]=new int[]{1,2,4,5,6,8,11,12,15,20};
		int inputArray2[]=new int[]{9,6,8,4,8,11,12,15,20};
		System.out.println(findIntersection(inputArray1,inputArray2));
	}

	private static int findIntersection(int[] inputArray1, int[] inputArray2) {
		int size1=inputArray1.length;
		int size2=inputArray2.length;
		int diff=Math.abs(size1-size2);
		if(size1<size2)
		{	
			int temp[]=inputArray2;
			inputArray2=inputArray1;
			inputArray1=temp;
		}
		int count=0;
		for (int i = diff; i < inputArray1.length; i++) {
			if(inputArray1[i]==inputArray2[count])
				return i;
			count++;
		}
		return -1;
	}
	

}
