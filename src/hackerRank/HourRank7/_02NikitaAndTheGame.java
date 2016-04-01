	package hackerRank.HourRank7;
	
	import java.util.Arrays;
import java.util.Scanner;
	
	public class _02NikitaAndTheGame {
	
	
	
		public static void main(String[] args) {
			Scanner in = new Scanner(System.in);
			int T = in.nextInt();
			for (int i = 0; i < T; i++) {
				int noOfElements=in.nextInt();
				int[] inputArray=new int[noOfElements];
				for (int j = 0; j < noOfElements; j++) {
					inputArray[j]=in.nextInt();
				}
				System.out.println(findMaxDivideCount(inputArray));
			}
		}

		private static int findMaxDivideCount(int[] inputArray) {
			if(inputArray.length==0||inputArray.length==1)
				return 0;
			int rightSum=0;
			for (int i = 0; i < inputArray.length; i++) {
				rightSum+=inputArray[i];
			}
			if(rightSum%2!=0)
				return 0;
			int leftSum=0;
			int i=0;
			boolean equal=false;
			for (i = 0; i < inputArray.length; i++) {
				leftSum+=inputArray[i];
				rightSum-=inputArray[i];
				if(leftSum==rightSum){
					equal=true;
					break;
				}
			}
			if(!equal)
				return 0;
			if(leftSum%2!=0)
				return 1;
			if(rightSum%2!=0)
				return 1;
			
			
			return 1+Math.max(findMaxDivideCount(Arrays.copyOfRange(inputArray, 0, i+1)), findMaxDivideCount(Arrays.copyOfRange(inputArray, i+1, inputArray.length)));
		}
	
		
	
	
	
	}
