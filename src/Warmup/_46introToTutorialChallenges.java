package Warmup;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class _46introToTutorialChallenges {
	public static void main(String[] args) throws Exception {
		BufferedReader scanner=new BufferedReader(new InputStreamReader(System.in));
		int V=Integer.parseInt(scanner.readLine());
		int n=Integer.parseInt(scanner.readLine());
		String numbersList=scanner.readLine();
		String numbersArray[]=numbersList.split(" ");
		for (int i = 0; i < numbersArray.length; i++) {
			if(Integer.parseInt(numbersArray[i])==V){
				System.out.println(i);
				break;
			}
		}
	}
}
