package LeetCodePerformancePractice;

import java.util.Arrays;

public class _066PlusOne {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(plusOne(new int[]{9,9})));
	}
	public static int[] plusOne(int[] digits) {
		int[] output=new int[digits.length+1];
		int carry=1;
		for (int i = digits.length-1; i >=0; i--) {
			int sum=digits[i]+carry;
			if(sum>9){
				output[i+1]=10-sum;
				carry=1;
			}
			else{
				output[i+1]=sum;
				carry=0;
			}
		}
		if(carry==1)
		{
			output[0]=1;
		}
		else{
			output=Arrays.copyOfRange(output, 1, output.length);
		}
		return output;
	}

}

