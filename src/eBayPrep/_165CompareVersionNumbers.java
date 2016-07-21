package LeetCodePractice;

import java.util.Arrays;

public class _165CompareVersionNumbers {

	public static void main(String[] args) {
		System.out.println(compareVersion("0.1", "1.2"));
	}

	public static int compareVersion(String version1, String version2) {
		String v1Arr[]=version1.split("\\.");
		String v2Arr[]=version2.split("\\.");
		System.out.println(Arrays.toString(v1Arr));
		System.out.println(Arrays.toString(v2Arr));
		
		if(v1Arr.length>v2Arr.length)
		{
			for (int i = 0; i < v2Arr.length; i++) {
				if(Integer.parseInt(v1Arr[i]+"")>Integer.parseInt(v2Arr[i]+""))
					return 1;
				else if(Integer.parseInt(v1Arr[i]+"")<Integer.parseInt(v2Arr[i]+""))
					return -1;
			}
			for (int i = v2Arr.length; i < v1Arr.length; i++) {
				if(Integer.parseInt(v1Arr[i]+"")>0)
					return 1;
			}
			return 0;
		}
		else
		{
			for (int i = 0; i < v1Arr.length; i++) {
				if(Integer.parseInt(v1Arr[i]+"")>Integer.parseInt(v2Arr[i]+""))
					return 1;
				else if(Integer.parseInt(v1Arr[i]+"")<Integer.parseInt(v2Arr[i]+""))
					return -1;
			}
			for (int i = v1Arr.length; i < v2Arr.length; i++) {
				if(Integer.parseInt(v2Arr[i]+"")>0)
					return -1;
			}
			return 0;
		}
	}
}

