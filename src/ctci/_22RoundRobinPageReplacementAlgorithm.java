package ctci;

import java.io.InputStreamReader;
import java.util.Scanner;


/*Implementation of Round Robin Page Replacement Algorithm*/
public class _22RoundRobinPageReplacementAlgorithm{

	public static void main(String[] args) {
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		String inputArray[]=scanner.nextLine().split(",");
		int frameLength=Integer.parseInt(scanner.nextLine());
		scanner.close();
		for (int i = 0; i < inputArray.length; i++) {
			System.out.print(inputArray[i]+" ");
		}
		performRoundRobinReplacement(inputArray,frameLength);
	}

	private static void performRoundRobinReplacement(String[] inputArray,
			int frameLength) {
		
		
	}
}