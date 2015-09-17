package ctci;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;


/*	Implementation of FCFS Scheduling Algorithm
 *	Assuming the arrays are sorted	*/
public class _23FCFSSchedulingNonPreEmptive{

	public static void main(String[] args) {
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		Integer noOfProcesses=Integer.parseInt(scanner.nextLine());
		int arrivalArray[]=new int[noOfProcesses];
		int serviceArray[]=new int[noOfProcesses];
		String arrivalTimeStringArray[]={"0","2","4","6","8"};//scanner.nextLine().split(",");
		String serviceTimeStringArray[]={"3","6","4","5","2"};//scanner.nextLine().split(",");
		scanner.close();
		for (int i = 0; i < noOfProcesses; i++) {
			arrivalArray[i]=Integer.parseInt(arrivalTimeStringArray[i]);
			serviceArray[i]=Integer.parseInt(serviceTimeStringArray[i]);
		}
		float[] outputList=fcfsScheduleSorted(arrivalArray,serviceArray);
		System.out.println(Arrays.toString(outputList));

		arrivalArray=new int[] {2,6,8,4,0};
		serviceArray=new int[] {6,5,2,4,3};
		outputList=fcfsScheduleNonSorted(arrivalArray,serviceArray);
		System.out.println(Arrays.toString(outputList));


	}

	private static float[] fcfsScheduleNonSorted(int[] arrivalArray,
			int[] serviceArray) {
		int sortedFinishArray[]=new int[arrivalArray.length];
		int sortedTurnaroundArray[]=new int[arrivalArray.length];
		int sortedArrivalArray[]=Arrays.copyOf(arrivalArray, arrivalArray.length);
		Arrays.sort(sortedArrivalArray);
		for (int i = 0; i < sortedArrivalArray.length; i++) {
			int element=sortedArrivalArray[i];
			int index=getIndex(element,arrivalArray);
			if(i==0)
			{
				sortedFinishArray[i]=serviceArray[index];
			}
			else{
				sortedFinishArray[i]=sortedFinishArray[i-1]+serviceArray[index];
			}
			sortedTurnaroundArray[i]=sortedFinishArray[i]-sortedArrivalArray[i];
		}
		float outputArray[]=new float[sortedFinishArray.length];
		for (int i = 0; i < arrivalArray.length; i++) {
			int index=getIndex(sortedArrivalArray[i], arrivalArray);
			outputArray[i]=(float)sortedTurnaroundArray[i]/serviceArray[index];
		}
		return outputArray;
	}

	private static int getIndex(int element, int[] arrivalArray) {
		for (int i = 0; i < arrivalArray.length; i++) {
			if(arrivalArray[i]==element)
				return i;
		}
		return 0;
	}

	private static float[] fcfsScheduleSorted(int[] arrivalArray, int[] serviceArray) {
		int finishArray[]=new int[arrivalArray.length];
		int turnAroundArray[]=new int[arrivalArray.length];

		for (int i = 0; i < arrivalArray.length; i++) {
			if(i==0)
			{
				finishArray[i]=serviceArray[i];
			}
			else{
				finishArray[i]=finishArray[i-1]+serviceArray[i];
			}
		}
		for (int i = 0; i < turnAroundArray.length; i++) {
			turnAroundArray[i]=finishArray[i]-arrivalArray[i];
		}
		float outputArray[]=new float[finishArray.length];
		for (int i = 0; i < turnAroundArray.length; i++) {
			outputArray[i]=(float)turnAroundArray[i]/serviceArray[i];
		}
		return outputArray;
	}


}