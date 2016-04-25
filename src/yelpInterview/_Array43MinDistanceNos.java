package yelpInterview;

public class _Array43MinDistanceNos {
	public static void main(String a[]){
		int[] inputArray=new int[]{1, 2};
		int x = 1, y = 2;
		System.out.println(findMinDistance(inputArray,x,y));
		inputArray=new int[]{3, 4, 5};
		x = 3; y = 5;
		System.out.println(findMinDistance(inputArray,x,y));
		inputArray=new int[]{3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3};
		x = 3; y = 6;
		System.out.println(findMinDistance(inputArray,x,y));
		inputArray=new int[]{2, 5, 3, 5, 4, 4, 2, 3};
		x = 3; y = 2;
		System.out.println(findMinDistance(inputArray,x,y));
	}

	private static int findMinDistance(int[] inputArray, int x, int y) {
		int prev=-1,prevIndex=-1;
		int distance=Integer.MAX_VALUE;
		for (int i = 0; i < inputArray.length; i++) {
			if(inputArray[i]==x || inputArray[i]==y)
			{
				if(prev==-1)
				{
					prev=inputArray[i];
					prevIndex=i;
				}
				else if(inputArray[i]!=prev){
					distance=Math.min(distance, i-prevIndex);
					prev=inputArray[i];
					prevIndex=i;
				}
				else{
					prevIndex=i;
				}
			}
		}
		return distance;
	}


}