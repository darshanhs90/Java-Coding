package servicenowPrep;

import java.util.Arrays;

public class _060SwapOnes
{

	public static void main(String[] args) {
		int[] arr=new int[]{1,0,3,5,0,0,34,5,0,36};
		arr=moveZeros(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static int[] moveZeros(int[] arr) {
		int left=0,right=arr.length-1;
		while(left<right)
		{
			if(arr[right]==0)
				right--;
			else if(arr[left]==0){
				arr[left]=arr[left]^arr[right];
				arr[right]=arr[left]^arr[right];
				arr[left]=arr[left]^arr[right];
				left++;
				right--;
			}else
			{
				left++;
			}
		}
		return arr;
	}

	
}