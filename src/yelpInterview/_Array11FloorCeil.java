package yelpInterview;

public class _Array11FloorCeil {
	public static void main(String a[]){
		int arr1[] = new int[]{1, 2, 8, 10, 10, 12, 19};
		printFloorCeil(arr1,0);
		printFloorCeil(arr1,1);
		printFloorCeil(arr1,5);
		printFloorCeil(arr1,20);
	}

	private static void printFloorCeil(int[] arr1, int i) {
		int left=0;
		int right=arr1.length-1;
		int mid=0;
		System.out.println("####"+i+"####");
		while(left<=right)
		{
			mid=(left+right)/2;
			if(arr1[mid]==i)
				break;
			else if(arr1[mid]>i)
			{
				right=mid-1;
			}
			else
				left=mid+1;
		}
		if(arr1[mid]==i)
		{
			System.out.println("Floor:"+arr1[mid]);
			System.out.println("Ceil:"+arr1[mid]);
		}
		else if(arr1[mid]>i)
		{
			System.out.println("Ceil:"+arr1[mid]);
			if(mid-1>=0)
				System.out.println("Floor:"+arr1[mid-1]);
			else
				System.out.println("No Floor");
		}
		else if(arr1[mid]<i)
		{
			System.out.println("Floor:"+arr1[mid]);
			if(mid+1<arr1.length)
				System.out.println("Floor:"+arr1[mid+1]);
			else
				System.out.println("No Ceil");
		}
	}



}