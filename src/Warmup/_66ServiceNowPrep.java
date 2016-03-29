package Warmup;

import java.util.Arrays;

public class _66ServiceNowPrep {
	public static void main(String[] args) {
		int[] arr=new int[]{1,0,3,5,0,0,34,5,0,36};
		arr=inplaceMove(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static int[] inplaceMove(int[] arr) {
		int index=arr.length-1;
		for (int i = arr.length-1;i>=0; i--) {
			if(arr[i]==0)
			{
				arr[index]=arr[i]^arr[index];
				arr[i]=arr[i]^arr[index];
				arr[index]=arr[i]^arr[index];
				index--;
			}
		}
		return arr;
	}
}






