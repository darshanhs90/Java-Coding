package TopCoder;

/*
 * SRM 320 Div2
 * Link:https://community.topcoder.com/stat?c=problem_statement&pm=6442
 */

public class SRM320StringSegment {
	public static void main(String[] args) {
		System.out.println(average("aaabbaaac"));
		System.out.println(average("aabbccdd"));
		System.out.println(average("abba"));
	}
	public static double average(String s){
		if(s.length()==0)
			return 0.0;
		int elementCount=0,total=0;
		char c=s.charAt(0);
		total++;
		elementCount++;
		for (int i = 1; i < s.length(); i++) {
			if(s.charAt(i)==c)
			{
				total++;
			}
			else{
				c=s.charAt(i);
				elementCount++;
				total++;
			}
		}
		return total/(double)elementCount;
	}
}
