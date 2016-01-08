package hackerRank.Algorithms.Implementation;

import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/challenges/acm-icpc-team
 */
public class _14AcmIcpcTeam {

	public static void main(String ards[])
	{
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		String inputArray[]=scanner.nextLine().split(" ");
		int N=Integer.parseInt(inputArray[0]);
		int M=Integer.parseInt(inputArray[1]);
		String teamArray[]=new String[N];
		for (int i = 0; i < N; i++) {
			teamArray[i]=scanner.nextLine();
		}
		int max=0,countOfMax=0;
		for (int i = 0; i < teamArray.length; i++) {
			for (int j = i+1; j < teamArray.length; j++) {
				String stri=teamArray[i];
				String strj=teamArray[j];
				int counter=0;
				for (int k=0;k<M;k++){
					if(stri.charAt(k)=='1' || strj.charAt(k)=='1')
						counter++;
				}
				if(counter>max){
					countOfMax=1;
					max=counter;
				}
				else if(counter==max)
					countOfMax++;
			}
		}
		System.out.println(max);
		System.out.println(countOfMax);
	}
}
