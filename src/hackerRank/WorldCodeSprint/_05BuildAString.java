package hackerRank.WorldCodeSprint;


import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/contests/worldcodesprint/challenges/print-string
 */
public class _05BuildAString {

	public static void main(String ards[])
	{
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		int noOfTestCases=Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < noOfTestCases; i++) {
			String splitStringArray[]=scanner.nextLine().split(" ");
			int N=Integer.parseInt(splitStringArray[0]);
			int A=Integer.parseInt(splitStringArray[1]);
			int B=Integer.parseInt(splitStringArray[2]);
			int length=0,cost=0;
			String str="";
			String mainString=scanner.nextLine();
			while(length<N)
			{
				if(str.length()==0){
					cost+=A;
					str+=mainString.charAt(length);
					length+=1;
				}
				else{
					int subLength=checkSubstring(mainString,str,length);
					//System.out.println(subLength);
					if(subLength==0)
					{
						cost+=A;
						str+=mainString.charAt(length);
						length+=1;
					}
					else if(subLength==1)
					{
						cost+=Math.min(A,B);
						str+=mainString.charAt(length);
						length+=1;
					}
					else{
						if(subLength==-1)
						{
							//System.out.println(length);
							subLength=mainString.length()-length;
						}
						cost+=Math.min(subLength*A,B);
						str+=mainString.substring(length,length+subLength);
						length+=subLength;
					}
				}
			}
			System.out.println(cost);
		}
	}

	private static int checkSubstring(String mainString, String str, int length) {
		String strn="";
		for (int i = length; i < mainString.length(); i++) {
			strn+=mainString.charAt(i);
			if(str.indexOf(strn)==-1)
			{
				return i-length;
			}
		}	
		return -1;
	}
}
