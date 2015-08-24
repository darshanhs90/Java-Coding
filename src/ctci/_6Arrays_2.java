package ctci;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;


/*Implementation of CTCI 1.3*/
public class _6Arrays_2 {
	public static void main(String args[]){
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		String inputString1=scanner.nextLine();
		String inputString2=scanner.nextLine();
		scanner.close();
		System.out.println("String are in Permuted Order Count: "+isPermutationCount(inputString1, inputString2));
		System.out.println("String are in Permuted Order Sort: "+isPermutationSort(inputString1, inputString2));

	}
	public static boolean isPermutationCount(String inputString1,String inputString2){
		int inputArray1[]=new int[256];
		int inputArray2[]=new int[256];
		Arrays.fill(inputArray1,0);
		Arrays.fill(inputArray2,0);
		if(inputString1.length()!=inputString2.length())
			return false;
		else{
			for (int i = 0; i < inputString1.length(); i++) {
				inputArray1[(int)inputString1.charAt(i)]++;
			}
			for (int i = 0; i < inputString2.length(); i++) {
				inputArray2[(int)inputString2.charAt(i)]++;
			}
			for (int i = 0; i < inputArray1.length; i++) {
				if(inputArray1[i]!=inputArray2[i])
					return false;
			}
		}
		return true;
	}
	public static boolean isPermutationSort(String inputString1,String inputString2){
		char[] inputArray1=inputString1.toCharArray();
		char[] inputArray2=inputString2.toCharArray();
		
		Arrays.sort(inputArray1);
		Arrays.sort(inputArray2);
		if(inputArray1.length!=inputArray2.length)
			return false;
		else{
			for (int i = 0; i < inputArray1.length; i++) {
				if(inputArray1[i]!=inputArray2[i])
				{
					return false;
				}
			}
		}
		return true;
	}
}
