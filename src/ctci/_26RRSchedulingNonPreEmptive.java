package ctci;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;


/*Implementation of LFU Page Replacement Algorithm
 * Quantum set to 1
 * */
public class _26RRSchedulingNonPreEmptive{

	public static void main(String[] args) {
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		Integer noOfProcesses=5;//Integer.parseInt(scanner.nextLine());
		Integer quantum=1;//Integer.parseInt(scanner.nextLine());
		int arrivalTimeArray[]=new int[noOfProcesses];
		int serviceTimeArray[]=new int[noOfProcesses];
		String arrivalTimeStringArray[]={"0","2","4","6","8"};//scanner.nextLine().split(",");
		String serviceTimeStringArray[]={"3","6","4","5","2"};//scanner.nextLine().split(",");
		scanner.close();
		for (int i = 0; i < noOfProcesses; i++) {
			arrivalTimeArray[i]=Integer.parseInt(arrivalTimeStringArray[i]);
			serviceTimeArray[i]=Integer.parseInt(serviceTimeStringArray[i]);
		}
		float[] outputList=roundRobinScheduler(arrivalTimeArray,serviceTimeArray,quantum);
		System.out.println(Arrays.toString(outputList));
	}

	private static float[] roundRobinScheduler(int[] arrivalTimeArray,
			int[] serviceTimeArray,int quantum) {
		int totalServiceTime=0;
		for (int i = 0; i < serviceTimeArray.length; i++) {
			totalServiceTime+=serviceTimeArray[i];
		}
		_05queue queue=new _05queue();
		int remainingTimeArray[]=Arrays.copyOf(serviceTimeArray,serviceTimeArray.length);
		int finishTimeArray[]=new int[remainingTimeArray.length];
		int turnAroundTimeArray[]=new int[remainingTimeArray.length];
		int count=0,index=-1;
		StringBuffer sb=new StringBuffer();
		for (int i = 0; i < totalServiceTime; i++) {
			if(arrivalTimeArray[count]==i){
				queue.add(count);
				count=(count==arrivalTimeArray.length-1)?count:(count+1);
			}
			if(index!=-1 && (remainingTimeArray[index]-1)>0){
				queue.add(index);	
				remainingTimeArray[index]--;
			}
			index=queue.poll();
			sb.append(index+"");
		}
		System.out.println(sb.toString());
		String outputString=sb.reverse().toString();
		System.out.println(outputString);
		for (int i = 0; i < finishTimeArray.length; i++) {
			finishTimeArray[i]=outputString.length()-outputString.indexOf(i+"");
			turnAroundTimeArray[i]=finishTimeArray[i]-arrivalTimeArray[i];
		}
		System.out.println(Arrays.toString(finishTimeArray));
		System.out.println(Arrays.toString(turnAroundTimeArray));
		float[] outputArray=new float[arrivalTimeArray.length];
		for (int i = 0; i < turnAroundTimeArray.length; i++) {
			outputArray[i]=(float)turnAroundTimeArray[i]/serviceTimeArray[i];
		}
		return outputArray;
	}
}