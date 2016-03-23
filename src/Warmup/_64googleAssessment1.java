package Warmup;
public class _64googleAssessment1 {
	public static void main(String[] args) {
		int value=1223336226;
		System.out.println(geMaxValue(value));
	}

	private static int geMaxValue(int value) {
		System.out.println(value);
		int max=Integer.MIN_VALUE;
		String str=value+"";
		char c=str.charAt(0);
		for (int i = 1; i < str.length(); i++) {
			if(c==str.charAt(i)){
				String str1=str.substring(0,i)+str.substring(i+1);
				max=Math.max(max, Integer.parseInt(str1));
			}
			else{
				c=str.charAt(i);
			}
		}
		return max;
	}
	


}
