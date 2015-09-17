package ctci;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;


/*Implementation of LFU Page Replacement Algorithm*/
public class _25SPNSchedulingNonPreEmptive{

	public static void main(String[] args) {
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		Integer noOfProcesses=Integer.parseInt(scanner.nextLine());
		int arrivalTimeArray[]=new int[noOfProcesses];
		int serviceTimeArray[]=new int[noOfProcesses];
		String arrivalTimeStringArray[]={"0","2","4","6","8"};//scanner.nextLine().split(",");
		String serviceTimeStringArray[]={"3","6","4","5","2"};//scanner.nextLine().split(",");
		scanner.close();
		for (int i = 0; i < noOfProcesses; i++) {
			arrivalTimeArray[i]=Integer.parseInt(arrivalTimeStringArray[i]);
			serviceTimeArray[i]=Integer.parseInt(serviceTimeStringArray[i]);
		}
		float[] outputList=spnScheduler(arrivalTimeArray,serviceTimeArray);
		System.out.println(Arrays.toString(outputList));
	}

	private static float[] spnScheduler(int[] arrivalTimeArray,
			int[] serviceTimeArray) {
		boolean visited[]=new boolean[arrivalTimeArray.length];
		int remainingTimeArray[]=new int[arrivalTimeArray.length];
		int finishTimeArray[]=new int[arrivalTimeArray.length];
		int turnAroundTimeArray[]=new int[arrivalTimeArray.length];
		
		Arrays.fill(remainingTimeArray,0);
		Arrays.fill(visited,false);
		int totalServiceTime=0;
		for (int i = 0; i < serviceTimeArray.length; i++) {
			totalServiceTime+=serviceTimeArray[i];
		}
		int count=0;
		int index=0;
		for (int i = 0; i < totalServiceTime; i++) {
			if(arrivalTimeArray[count]==i)
			{
				remainingTimeArray[count]=serviceTimeArray[count];
				count=(count==arrivalTimeArray.length-1)?count:(count+1);
			}
			remainingTimeArray[index]--;
			if(remainingTimeArray[index]==0)
			{	
				finishTimeArray[index]=i+1;
				turnAroundTimeArray[index]=finishTimeArray[index]-arrivalTimeArray[index];
				index=findNextIndex(remainingTimeArray);
			}
		}
		float[] outputArray=new float[arrivalTimeArray.length];
		for (int i = 0; i < turnAroundTimeArray.length; i++) {
			turnAroundTimeArray[i]=finishTimeArray[i]-arrivalTimeArray[i];
			outputArray[i]=(float)turnAroundTimeArray[i]/serviceTimeArray[i];
		}
		return outputArray;
	}

	private static int findNextIndex(int[] remainingTimeArray) {
		int index=0,min=Integer.MAX_VALUE;
		for (int i = 0; i < remainingTimeArray.length; i++) {
			if(remainingTimeArray[i]!=0 && remainingTimeArray[i]<min)
			{
				min=remainingTimeArray[i];
				index=i;
			}
		}
		return index;
	}
}