package LeetCodePractice;

import java.util.Arrays;

public class _066PlusOne {


	public static void main(String[] args) {
		System.out.println(Arrays.toString(plusOne(new int[]{9,9})));
	}


	public static int[] plusOne(int[] digits) {
		int carry=1;
		int[] output=new int[digits.length+1];
		for (int i = digits.length-1; i >=0; i--) {
			int value=digits[i]+carry;
			if(value>=10){
				output[i]=0;
				digits[i]=0;
				carry=1;
			}
			else{
				output[i]=value;
				digits[i]=value;
				carry=0;
			}
		}
		if(carry==1)
			output[0]=1;
		return carry==1?output:digits;

	}

}

