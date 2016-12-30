package PracticeLeetCode;

public class _038CountAndSay {
	public static void main(String[] args) {
		System.out.println(countAndSay(4-2));
	}
	public static String countAndSay(int n) {
		if(n==1)
			return n+"";
		String str="1";
		for (int i = 1; i <n; i++) {
			StringBuilder sb=new StringBuilder();
			char c=str.charAt(0);
			int count=1;
			for (int j = 1; j < str.length(); j++) {
				if(str.charAt(j)==c)
				{
					count++;
				}
				else{
					sb.append(count+""+c);
					c=str.charAt(j);
					count=1;
				}
			}
			sb.append(count+""+c);
			str=sb.toString();
		}
		return str;
	}

}

