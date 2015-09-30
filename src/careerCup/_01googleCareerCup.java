package careerCup;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Main Link:  http://www.careercup.com/page?pid=google-interview-questions
 * Problem Link:  http://www.careercup.com/question?id=5200686994161664
*/
public class _01googleCareerCup {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		String inputString=scanner.nextLine();
		Integer min=Integer.parseInt(scanner.nextLine());
		Integer max=Integer.parseInt(scanner.nextLine());
		scanner.close();
		String inputStringArray[]=inputString.split(",");
		naiveAlgo(inputStringArray,min,max);
	}

	private static void naiveAlgo(String[] inputStringArray, Integer min, Integer max) {
		for (int i = 0; i < inputStringArray.length; i++) {
			int sum=Integer.parseInt(inputStringArray[i]);
			if(sum>=min && sum<=max)
				System.out.println(inputStringArray[i]);
			for (int j = i+1; j < inputStringArray.length; j++) {
				sum+=Integer.parseInt(inputStringArray[j]);
				if(sum>=min && sum<=max){
					Integer end=(j<inputStringArray.length)?j+1:j;
					System.out.println(Arrays.toString(Arrays.copyOfRange(inputStringArray, i,end)));
				}
			}
		}
		
	}
}
