package LeetCodePerformancePractice;

public class _038CountAndSay {
	public static void main(String[] args) {
		System.out.println(countAndSay(4));

	}
	public static String countAndSay(int n) {
		if(n<1)
			return "";
		String str="1";
		for (int i = 1; i < n; i++) {
			int count=1;
			char c=str.charAt(0);
			StringBuilder sb=new StringBuilder();
			for (int j = 1; j < str.length(); j++) {
				char ch=str.charAt(j);
				if(ch==c)
					count++;
				else
				{
					sb.append(count+""+c);
					c=ch;
					count=1;
				}
			}
			sb.append(count+""+c);
			str=sb.toString();
		}
		return str;
	}
}

