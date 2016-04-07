package TopCoder;

/*
 * SRM 161 Div2
 * Link:https://community.topcoder.com/stat?c=problem_statement&pm=1801&rd=4610
 */



public class SRM162LCMRange {
	public static void main(String[] args)  {
		System.out.println(lcm(1,5));
		System.out.println(lcm(4,5));
		System.out.println(lcm(1,12));
	}
	public static int lcm(int first, int last){
		int num=1;
		for (int i = first; i <=last; i++) {
			num=findLcm(num,i);
		}
		return num;
	}
	private static int findLcm(int a, int b)
	{
		return a * (b / gcd(a, b));
	}
	private static int gcd(int a, int b)
	{
		while (b > 0)
		{
			int temp = b;
			b = a % b; 
			a = temp;
		}
		return a;
	}
}
