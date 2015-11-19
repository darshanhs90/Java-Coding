package careerCup;

/*
 * Link: http://www.careercup.com/question?id=62221
 * Identify the regular expression in a given string such that the pattern does not repeat.
 * For example, to identify the pattern 'foo' only once in an input.
 * 'jhkhfoojkkj' should be identified right
 * 'kjhfooaaaaafoo' should not be
 */
public class _09googleCareerCup {

	public static void main(String[] args) {
		System.out.println(doRegex("foo","jhkhfoojkkj"));
		System.out.println(doRegex("foo","kjhfooaaaaafoo"));
		
	}

	private static boolean doRegex(String regexString,String mainString) {
		int count=0;
		for (int i = 0; i < mainString.length(); i++) {
			if(mainString.charAt(i)==regexString.charAt(0))
			{
				if(mainString.substring(i,i+regexString.length()).contentEquals(regexString))
					count++;
				if(count>1)
					return false;
			}
		}
		return true;
	}
	
	
}
