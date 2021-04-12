package April2021Leetcode;

public class _0043MultiplyStrings {

	public static void main(String[] args) {
		System.out.println(multiply("2", "3"));
		System.out.println(multiply("123", "456"));
		System.out.println(multiply("140", "721"));
	}

	public static String multiply(String num1, String num2) {
		if(num1.equals("0")|| num2.equals("0"))
			return "0";
		int[] out = new int[num1.length()+num2.length()];
		char[] cArr1 = num1.toCharArray();
		char[] cArr2 = num2.toCharArray();
		
		for (int i = cArr1.length-1; i >=0; i--) {
			for (int j = cArr2.length-1; j >=0; j--) {
				
				int index1 = i+j+1;
				int index2 = i+j;
				int val1 = Integer.parseInt(cArr1[i]+"");
				int val2 = Integer.parseInt(cArr2[j]+"");
				
				
				int sum = out[index1]+val1*val2;
				
				out[index2] += sum/10;
				out[index1] = sum%10;
			}
		}
		
		StringBuilder sb  = new StringBuilder();
		for (int i = 0; i < out.length; i++) {
			sb.append(out[i]);
		}
		
		while(sb.length()>0 && sb.charAt(0) == '0')
			sb.deleteCharAt(0);
		return sb.toString();
	}
}
