package TopCoder;

/*
 * SRM 155 Div2
 * Link:https://community.topcoder.com/stat?c=problem_statement&pm=1348&rd=4580
 */



public class SRM155BenfordsLaw {
	public static void main(String[] args) {
		System.out.println(questionableDigit(new int[]{ 5236,7290,200,1907,3336,9182,17,4209,8746,7932,
				6375,909,2189,3977,2389,2500,1239,3448,6380,4812 },1 ));
		System.out.println(questionableDigit(new int[]{ 1,10,100,2,20,200,2000,3,30,300 },2 ));
		System.out.println(questionableDigit(new int[]{ 9,87,765,6543,54321,43219,321987,21987,1987,345,234,123 },2 ));
		System.out.println(questionableDigit(new int[]{ 1,2,3,4,5,6,7,8,7,6,5,4,3,2,1 },8 ));
		System.out.println(questionableDigit(new int[]{ 987,234,1234,234873487,876,234562,17,
				7575734,5555,4210,678234,3999,8123 },3 ));
	}
	public static int questionableDigit(int[] transactions, int threshold){
		int []actual=new int[10];
		double expected[]=new double[10];
		for (int i = 0; i < transactions.length; i++) {
			String str=transactions[i]+"";
			actual[Integer.parseInt(str.charAt(0)+"")]++;
		}
		for (int i = 1; i <expected.length; i++) {
			expected[i]=Math.log10(1+1/(float)i)*transactions.length;
		}
		for (int i = 1; i <expected.length; i++) {
			if(expected[i]/(float)actual[i]>=threshold || actual[i]/(float)expected[i]>=threshold)
				return i;
		}
		return -1;
	}
}
