package PracticeLeetCode;

public class _012IntegerToRoman {
	public static void main(String[] args) {
		System.out.println(intToRoman(3999));
	}
a
	static int[] nums=new int[]{1,4,5,9,10,40,50,90,100,400,500,900,1000};
	static String[] digits=new String[]{"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
	public static String intToRoman(int num) {
		int index=nums.length-1;
		StringBuilder sb=new StringBuilder();
		while(num>0 && index>=0){

			if(num>=nums[index])
			{
				sb.append(digits[index]);
				num-=nums[index];
			}
			else{
				index--;
			}
		}
		return sb.toString();
	}


}
