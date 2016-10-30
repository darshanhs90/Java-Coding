package hackerRank.WalmartCodeSprint;

import java.util.Scanner;

public class _03DigitMinMaxScores{
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n1=scanner.nextInt();
		int n2=scanner.nextInt();
		int sum=0;
		for (int i = n1; i <=n2; i++) {
			sum+=findMinMax(i);
		}
		System.out.println(sum);
	}

	private static int findMinMax(int i) {
		int minCount=0,maxCount=0;
		char[] cArr=(i+"").toCharArray();
		if(cArr.length<=2)
			return 0;
		for (int j = 1; j < cArr.length-1; j++) {
			char c=cArr[j];
			char cBefore=cArr[j-1];
			char cNext=cArr[j+1];
			if((Character.getNumericValue(c)>Character.getNumericValue(cBefore)) && (Character.getNumericValue(c)>Character.getNumericValue(cNext))){
				maxCount++;
			}else if((Character.getNumericValue(c)<Character.getNumericValue(cBefore)) && (Character.getNumericValue(c)<Character.getNumericValue(cNext))){
				minCount++;
			}
		}
		return minCount+maxCount;
	}


}
