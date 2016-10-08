package PracticeLeetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class _066PlusOne {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(plusOne(new int[]{9,9})));
	}
	public static int[] plusOne(int[] digits) {
		ArrayList<Integer> list=new ArrayList<>();
		int carry=1;
		for (int i = digits.length-1; i>=0;i--) {
			int sum=digits[i]+carry;
			if(sum>9)
				carry=1;
			else
				carry=0;
			sum=sum%10;
			list.add(sum);
		}
		if(carry==1)
			list.add(carry);
		int[] output=new int[list.size()];
		for (int i = 0; i < output.length; i++) {
			output[output.length-1-i]=list.get(i);
		}
		return output;
	}
}

