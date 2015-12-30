package hackerRank.Algorithms.Implementation;

import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/challenges/caesar-cipher-1
 */
public class _09CaesarCipher {

	public static void main(String ards[])
	{
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		int N=Integer.parseInt(scanner.nextLine());
		String S=scanner.nextLine();
		int K=Integer.parseInt(scanner.nextLine());
		K=K%26;
		StringBuilder sb=new StringBuilder();
		for (int i = 0; i < S.length(); i++) {
			int charValue=(int)S.charAt(i);
			if(charValue>=65 && charValue<=90)
			{
				charValue=(charValue+K>90)?(charValue+K-26):(charValue+K);	
			}
			else if(charValue>=97 && charValue<=122)
			{
				charValue=(charValue+K>122)?(charValue+K-26):(charValue+K);				
			}
			sb.append((char)charValue);
		}
		System.out.println(sb.toString());
	}
}
