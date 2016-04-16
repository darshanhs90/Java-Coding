package TopCoder;

/*
 * SRM 175 Div2
 * Link:https://community.topcoder.com/stat?c=problem_statement&pm=2241&rd=4680
 */



public class SRM175ClockWalk {
	public static void main(String[] args) {
		System.out.println(finalPosition("hhthh"));
		System.out.println(finalPosition("hhtht"));
		System.out.println(finalPosition("hthth"));
		System.out.println(finalPosition("hthhhhh"));
		System.out.println(finalPosition("hthhthtththhtttthttthhhthtttthh"));
	}
	public static int finalPosition(String flips){
		int value=0;
		for (int i = 0; i < flips.length(); i++) {
			if(flips.charAt(i)=='h')
			{
				value+=i+1;
			}else{
				value-=(i+1);
			}
		}
		value=value%12;
		return value<=0?12+value:value;
	}
}
