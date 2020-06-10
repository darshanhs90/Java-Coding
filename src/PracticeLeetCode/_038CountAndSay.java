package PracticeLeetCode;

public class _038CountAndSay {
	public static void main(String[] args) {
		System.out.println(countAndSay(1));
		System.out.println(countAndSay(2));
		System.out.println(countAndSay(3));
		System.out.println(countAndSay(4));
		System.out.println(countAndSay(5));
	}
	
    public static String countAndSay(int n) {
        String startingString = "1";
    	for (int i = 1; i < n; i++) {
    		char startChar = startingString.charAt(0);
    		int charCount = 1;
    		StringBuilder sb =new StringBuilder();
			for (int j = 1; j < startingString.length(); j++) {
				char currentChar = startingString.charAt(j);
				if(currentChar == startChar)
				{
					charCount++;
				}
				else {
					sb.append(charCount+""+startChar);
					startChar = currentChar;
					charCount = 1;
				}
			}
			sb.append(charCount+""+startChar);
			startingString = sb.toString();
		}
    	return startingString;
    }
}

