package geeksforgeeks;





/*
 * http://www.geeksforgeeks.org/amazon-interview-set-34/
 * Given an array and two numbers x and y, find minimum distance
 * between two numbers x and y. assume that x and y always exist in
 * array and it may be that x and y are same also
 */;
 public class _01AmazonInterview_34_01 {
	 public static void main(String[] args) {
		 int inputArray[]={1,4,10,2,3,4,6,7,6,2};
		 System.out.println(findDifference(inputArray,4,2));
		 System.out.println(findDifference(inputArray,4,4));
	 }

	private static int findDifference(int[] inputArray, int x, int y) {
		if(x==y)
			return 0;
		else
		{
			int prevX=-1;
			int prevY=-1;
			int prev=-1;
			int diff=Integer.MAX_VALUE;
			for (int i = 0; i < inputArray.length; i++) {
				if(inputArray[i]==x && (prev==x||prev==-1)){
					prevX=i;
					prev=x;
				}
				else if(inputArray[i]==y && (prev==y||prev==-1)){
					prevY=i;
					prev=y;
				}
				else if((inputArray[i]==y && prev==x)||(inputArray[i]==x && prev==y)){
					prev=inputArray[i];
					if(inputArray[i]==x)
						prevX=i;
					else
						prevY=i;
					if(Math.abs(prevX-prevY)<diff)
					{
						diff=Math.abs(prevX-prevY);
					}
				}
			}
			return diff;
		}
	}
 }