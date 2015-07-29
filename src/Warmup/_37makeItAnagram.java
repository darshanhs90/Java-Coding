package Warmup;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _37makeItAnagram {
	public static void main(String[] args) throws Exception {
		BufferedReader scanner=new BufferedReader(new InputStreamReader(System.in));
		String firstLine=(scanner.readLine());
		String secondLine=(scanner.readLine());
		char[] chars = firstLine.toCharArray();
		Arrays.sort(chars);
		firstLine = new String(chars);
		chars = secondLine.toCharArray();
		Arrays.sort(chars);
		secondLine = new String(chars);



		int deletionCount=0;
		String mainString=firstLine;
		String comparisonString=secondLine;

		int firstStringCounter=0,secondStringCounter=0;
		while(firstStringCounter!=firstLine.length() && secondStringCounter!=secondLine.length()){
			//choose a main string,if its char at its ocunter is > another stig char at its counter,flip,
			//else if its less,delte,else if equal increase counter
			System.out.println(mainString+" "+firstStringCounter);
			System.out.println(comparisonString+" "+secondStringCounter);
			StringBuilder str1=new StringBuilder(firstLine);
			if((int)mainString.charAt(firstStringCounter)<(int)comparisonString.charAt(secondStringCounter))
			{
				//swap strings
				String swapString=mainString;
				mainString=comparisonString;
				comparisonString=swapString;
				int swapcounter=firstStringCounter;
				firstStringCounter=secondStringCounter;
				secondStringCounter=swapcounter;

				System.exit(1);
			}
			else{
				Boolean flag=false;
				for (int i = firstStringCounter; i < mainString.length(); i++) {
					System.out.println("i is"+i);
					for (int j = secondStringCounter; j < comparisonString.length(); j++) {
						System.out.println("j is"+j);
						if(comparisonString.charAt(j)<mainString.charAt(i)){
							System.out.println("deletion count increased");
							deletionCount++;
						}
						else if(comparisonString.charAt(j)>mainString.charAt(i)){
							System.out.println("swap the strings");
							secondStringCounter=j;
							flag=true;
							break;
						}
						else{
							secondStringCounter=j;
							break;
						}
						
					}
					if(flag){
						firstStringCounter=i;
						break;
					}
				}
			}
		}
		System.out.println(deletionCount);
		//start comparison and count deletions
	}
}
