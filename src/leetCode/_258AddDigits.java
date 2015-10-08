package leetCode;

/*
 * Link : https://leetcode.com/problems/add-digits/
 */

public class _258AddDigits {
	 public static int addDigits(int num) {
		 while(String.valueOf(num).length()!=1)
		 {
			 String numberVal=String.valueOf(num);
			 num=0;
			 for (int i = 0; i <numberVal.length(); i++) {
				num+=Integer.parseInt(numberVal.charAt(i)+"");
			}
		 }
		 return num;
	 }
	 public static void main(String[] args) {
		System.out.println(addDigits(38));
	}
}