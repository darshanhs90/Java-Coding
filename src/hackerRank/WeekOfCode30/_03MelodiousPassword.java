package hackerRank.WeekOfCode30;

import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/contests/w30/challenges/find-the-minimum-number
 */
public class _03MelodiousPassword {
	static String vowelsString="aeiou";
	static String consonantssString="bcdfghjklmnpqrstvwxz";
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
/*        char[] vowels=new char[]{'a','e','i','o','u'};
        char[] consonants=new char[]{'b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','x','z'};*/
        char[] vowels=new char[]{'a','e','i','o','u'};
        char[] consonants=new char[]{'a','e','i','o','u','b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','x','z'};
        performCombinations(consonants, n, 1);
        
        
        
        
    }
    public static void performCombinations(char cArr[],int n, int k) {   
    	for (int i = 0; i < n; i++) {
    		dfs(cArr, "", cArr.length, n);
    	}
    }

    public static void dfs(char cArr[], String prefix, int n, int k) {
        if (k == 0) {
            validatePrefix(prefix);
            return;
        }
        for (int i = 0; i < n; i++) {
        	dfs(cArr, prefix + cArr[i], n, k - 1); 
        }
    }
	private static void validatePrefix(String prefix) {
		boolean isVowel=vowelsString.contains(prefix.charAt(0)+"");
		for (int i = 1; i < prefix.length(); i++) {
			char c=prefix.charAt(i);
			if(isVowel)
			{
				if(consonantssString.contains(c+""))
				{
					isVowel=false;
				}
				else{
					return;
				}
			}
			else{
				if(vowelsString.contains(c+""))
				{
					isVowel=true;
				}
				else{
					return;
				}
			}
		}
		System.out.println(prefix);
		
	}
}

