package PracticeLeetCode;

public class _038CountAndSay {
	public static void main(String[] args) {
		System.out.println(countAndSay(4-2));
	}
	public static String countAndSay(int n) {
		if(n==1)
			return n+"";
		String str="1";
		for (int i = 2; i <=n; i++) {
			char c=str.charAt(0);
			int count=1;
			StringBuilder sb=new StringBuilder();
			for (int j = 1; j < str.length(); j++) {
				char c1=str.charAt(j);
				if(c1==c)
				{
					count++;
				}
				else{
					sb.append(count+""+c);
					count=1;
					c=c1;
				}
			}
			sb.append(count+""+c);
			str=sb.toString();
		}
		return str;
	}

}

