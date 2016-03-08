package TopCoder;

/*
 * SRM 148 Div2
 * Link:https://community.topcoder.com/stat?c=problem_statement&pm=1741&rd=4545
 */



public class SRM148DivisorDigits {
	public static void main(String[] args) {
		System.out.println(howMany(12345));
		System.out.println(howMany(661232));
		System.out.println(howMany(52527));
		System.out.println(howMany(730000000));
	}
	public static int howMany(int number){
		int count=0;
		String str=number+"";
		for (int i = 1; i <=9; i++) {
			if(str.indexOf(i+"")>-1)
			{
				if(number%i==0)
					count++;
			}
		}
		return count;
	}
}
