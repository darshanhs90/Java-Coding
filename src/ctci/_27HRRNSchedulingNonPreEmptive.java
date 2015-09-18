package ctci;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;


/*Implementation of LFU Page Replacement Algorithm*/
public class _27HRRNSchedulingNonPreEmptive{

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
		float[] outputList=HRRNScheduler(arrivalTimeArray,serviceTimeArray);
		System.out.println(Arrays.toString(outputList));
	}

	private static float[] HRRNScheduler(int[] arrivalTimeArray,
			int[] serviceTimeArray) {
		int totalServiceTime=0;
		for (int i = 0; i < serviceTimeArray.length; i++) {
			totalServiceTime+=serviceTimeArray[i];
		}
		int turnAroundTimeArray[]=new int[serviceTimeArray.length];
		Arrays.fill(turnAroundTimeArray,0);
		int index=0,count=0;
		int finishArray[]=new int[serviceTimeArray.length];
		Arrays.fill(finishArray,0);
		int remainingArray[]=Arrays.copyOf(serviceTimeArray, serviceTimeArray.length);

		for (int i = 0; i < totalServiceTime; i++) {
			remainingArray[index]--;
			if(remainingArray[index]==0){
				finishArray[index]=i+1;
				turnAroundTimeArray[index]=finishArray[index]-arrivalTimeArray[index];
				index=findNextIndex(finishArray,i,arrivalTimeArray,serviceTimeArray);
			}
		}

		float[] outputArray=new float[arrivalTimeArray.length];
		for (int i = 0; i < turnAroundTimeArray.length; i++) {
			outputArray[i]=(float)turnAroundTimeArray[i]/serviceTimeArray[i];
		}
		return outputArray;
	}

	private static int findNextIndex(int[] finishArray, int i,
			int[] arrivalTimeArray,int[] serviceTimeArray) {
		float max=Float.MIN_VALUE;
		int returnIndex=-1;
		for (int j = 0; j < finishArray.length; j++) {
			if(finishArray[j]==0){
				if((i-arrivalTimeArray[j])>=0)
				{
					float ratio=((float)(i-arrivalTimeArray[j])+serviceTimeArray[j])/(serviceTimeArray[j]);
					if(ratio>max)
					{
						max=ratio;
						returnIndex=j;
					}	
				}
			}
		}

		return returnIndex;
	}
}