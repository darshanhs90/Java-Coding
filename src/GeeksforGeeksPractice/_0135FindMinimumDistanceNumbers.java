package GeeksforGeeksPractice;

/*
 * Link: http://www.geeksforgeeks.org/find-the-minimum-distance-between-two-numbers/
 */
public class _0135FindMinimumDistanceNumbers {
	public static void main(String[] args) {
	int arr[]={1,2};
	System.out.println(findDistance(arr,1,2));
	arr = new int[]{3, 4, 5};
	System.out.println(findDistance(arr,3,5));
	arr = new int[]{3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3};
	System.out.println(findDistance(arr,3,6));
	arr = new int[]{2, 5, 3, 5, 4, 4, 2, 3};
	System.out.println(findDistance(arr,3,2));
	
	}

	private static int findDistance(int[] arr, int firstElement, int secondElement) {
		int length=Integer.MAX_VALUE,prev=Integer.MIN_VALUE,prevIndex=0;
		for (int k = 0; k < arr.length; k++) {
			int element=arr[k];
			if(element==firstElement||element==secondElement)
			{
				if(prev!=firstElement && prev!=secondElement)
				{
					prev=element;
					prevIndex=k;
				}
				else
				{
					if(prev==element)
					{
						prev=element;
						prevIndex=k;
					}
					else{
						prev=element;
						length=length>(k-prevIndex)?k-prevIndex:length;
						prevIndex=k;
					}
				}
			}
		}
		return length;
	}

}
