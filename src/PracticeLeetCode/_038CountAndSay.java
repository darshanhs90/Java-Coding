package PracticeLeetCode;

public class _038CountAndSay {
	public static void main(String[] args) {
		System.out.println(countAndSay(4));
	}
	public static String countAndSay(int n) {
		if(n==1)
			return "1";
		String input="1";
		int count=0;
		for (int i = 1; i <n; i++) {
			char currChar=input.charAt(0);
			count=1;
			StringBuilder sb=new StringBuilder();
			for (int j = 1; j < input.length(); j++) {
				char c=input.charAt(j);
				if(currChar==c)
				{
					count++;
				}
				else{
					sb.append(count);
					sb.append(currChar);
					currChar=c;
					count=1;
				}
			}
			sb.append(count);
			sb.append(currChar);
			input=sb.toString();
		}
		return input;
	}

}

