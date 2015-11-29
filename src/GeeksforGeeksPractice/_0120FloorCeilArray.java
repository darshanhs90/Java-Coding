package GeeksforGeeksPractice;

import java.util.Arrays;

/*
 * Link: http://www.geeksforgeeks.org/search-floor-and-ceil-in-a-sorted-array/
 */
public class _0120FloorCeilArray {
	public static void main(String[] args) {
		int arr[] =  {1, 2, 8, 10, 10, 12, 19};
		printFloorCeil(arr,0);
		printFloorCeil(arr,1);
		printFloorCeil(arr,5);
		printFloorCeil(arr,20);
	}

	private static void printFloorCeil(int[] arr, int key) {
		int left=0,right=arr.length-1;
		int mid=0;
		while(left<=right)
		{	
			mid=(left+right)/2;
			if(arr[mid]==key)
			{
				System.out.println("Ceil:"+key+"Floor:"+key);
				return;
			}
			else if(arr[mid]>key)
			{
				right=mid-1;
			}
			else
				left=mid+1;
		}
		if(right<0)
			System.out.println("Ceil:"+arr[left]);
		else if(left>=arr.length)
			System.out.println("Floor:"+arr[right]);
		else
			System.out.println("Floor:"+arr[right]+"Ceil:"+arr[left]);
	}


}
