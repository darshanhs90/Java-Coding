package Warmup;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _25caesarCipher {
		public static void main(String[] args) throws Exception {
			BufferedReader scanner=new BufferedReader(new InputStreamReader(System.in));
			int N=Integer.parseInt(scanner.readLine());
			String S=scanner.readLine();
			int K=Integer.parseInt(scanner.readLine());
			String outputString="";
			if(K>26)
				K=K%26;
			for (int i = 0; i < S.length(); i++) {
				int charAsciiValue=(int)S.charAt(i);
				if(charAsciiValue>=65 && charAsciiValue<=90)
				{//upper case character
					if(charAsciiValue+K>90){
						charAsciiValue=-90+charAsciiValue+K+64;
					}
					else{
						charAsciiValue+=K;
					}
					outputString+=(char)charAsciiValue;
				}
				else if(charAsciiValue>=97 && charAsciiValue<=122)
				{//lower case character
					if(charAsciiValue+K>122){
						charAsciiValue=-122+charAsciiValue+K+96;
					}
					else{
						charAsciiValue+=K;
					}
					outputString+=(char)charAsciiValue;
				}
				else{//not a alphabet
					outputString+=S.charAt(i);
				}
			}
			System.out.println(outputString);
		}
}
