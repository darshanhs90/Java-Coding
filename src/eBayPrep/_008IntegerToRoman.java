package eBayPrep;

public class _008IntegerToRoman {

	public static void main(String[] args) {
		System.out.println(intToRoman(3999));
	}
	public static String intToRoman(int num) {
		String dict[] = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
		int val[] = {1000,900,500,400,100,90,50,40,10,9,5,4,1};  
		StringBuilder sb=new StringBuilder();
		int currIndex=0;
		while(num>0)
		{
			if(num<val[currIndex])
			{
				currIndex++;
			}
			else{
				sb.append(dict[currIndex]);
				num-=val[currIndex];
			}
		}
		return sb.toString();
	}
}
