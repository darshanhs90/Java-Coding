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
		Integer noOfProcesses=Integer.parseInt(scanner.nextLine());
		Integer quantum=Integer.parseInt(scanner.nextLine());
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
		int count=0,index=0;;
		for (int i = 0; i < totalServiceTime; i++) {
			if(arrivalTimeArray[count]==i){
				if(!queue.isEmpty())
				{
					queue.add(count);
					if(remainingTimeArray[index]!=0){
						queue.add(index);
					}
				}
				else{
					queue.add(count);
				}
				count=(count==arrivalTimeArray.length-1)?count:(count+1);
				/*index=queue.poll();
				remainingTimeArray[index]=remainingTimeArray[index]-1;*/	
			}
			else{
				index=queue.poll();
				remainingTimeArray[index]=remainingTimeArray[index]-1;
				if((i+1)!=arrivalTimeArray[count])
				{
					queue.add(index);
				}
			}
			System.out.println("Queue is :"+queue.toString());
			//System.out.println();
			System.out.println(Arrays.toString(remainingTimeArray));
		}








		return null;
	}
}