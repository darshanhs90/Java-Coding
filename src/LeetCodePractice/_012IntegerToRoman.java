package LeetCodePractice;

public class _012IntegerToRoman {

	public static void main(String[] args) {
		System.out.println(intToRoman(3999));
	}
	public static String intToRoman(int num) {
		String dict[] = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
		int val[] = {1000,900,500,400,100,90,50,40,10,9,5,4,1};  

		int index=0;
		StringBuilder sb=new StringBuilder();
		while(num>0)
		{
			if(num/(float)val[index]>0){
				int count=(int) (num/(float)val[index]);
				for (int i = 0; i < count; i++) {
					sb.append(dict[index]);
				}
				num=num-val[index]*count;
			}
			index++;
		}
		return sb.toString();
	}
}
