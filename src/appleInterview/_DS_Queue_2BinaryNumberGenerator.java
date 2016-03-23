package appleInterview;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class _DS_Queue_2BinaryNumberGenerator {


	public static void main(String[] args) {
		generateBinary(2);
		generateBinary(5);
	}

	private static void generateBinary(int i) {
		PriorityQueue<Integer> pq=new PriorityQueue<>();
		pq.add(1);
		int size=1;
		int counter=0;
		while(pq.size()<i) {
			LinkedList<Integer> lowerValue=new LinkedList<Integer>();
			LinkedList<Integer> upperValue=new LinkedList<Integer>();
			LinkedList<Integer> tempValue=new LinkedList<Integer>();
			int total=(int)Math.pow(2, size-1);
			size++;
			Object arr[]=pq.toArray();
			for (int k = 0; k < total; k++) {
				String strNew=arr[counter]+"";
				counter++;
				lowerValue.add(Integer.valueOf(strNew+"0"));
				upperValue.add(Integer.valueOf(strNew+"1"));
			}
			for (int k = 0; k < lowerValue.size(); k++) {
				pq.add(lowerValue.get(k));
				pq.add(upperValue.get(k));
			}
		}
		while(!pq.isEmpty())
		{
			System.out.print(pq.poll()+"/");
		}
		System.out.println();
	}

}
