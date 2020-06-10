package PracticeLeetCode;

import java.util.Arrays;

public class _066PlusOne {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(plusOne(new int[] {4,3,2,1})));
		System.out.println(Arrays.toString(plusOne(new int[] {1,2,3})));
		System.out.println(Arrays.toString(plusOne(new int[] {9,9,9,9})));
	}

	public static int[] plusOne(int[] digits) {
        StringBuilder sb = new StringBuilder();
        int carry = 1; 
        for (int i = digits.length -1; i >= 0; i--) {
			int val = digits[i] + carry;
			carry = 0;
			if(val > 9)
			{
				carry = 1;
				val = 10 -val;
			}
			sb.append(val);
		}
        
        if(carry == 1)
        {
        	sb.append("1");
        }
        
        String op = sb.toString();
        int[] outputArray = new int[op.length()];
        int outputLen = outputArray.length;
        for (int i = 0; i < outputLen; i++) {
			outputArray[i] = Integer.parseInt(op.charAt(outputLen - i - 1) + "");
		}
        return outputArray;
    }
	
}

