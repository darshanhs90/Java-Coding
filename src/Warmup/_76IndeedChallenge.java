package Warmup;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class _76IndeedChallenge {
	public static void main(String args[] ) throws Exception {
		Scanner scanner=new Scanner(System.in);
		long Q=Long.parseLong(scanner.nextLine());
		int M=Integer.parseInt(scanner.nextLine());
		List<Integer> list=new ArrayList<>();
		TreeMap<Integer, Integer> map=new TreeMap<>();
		long N=0;
		for (int i = 0; i < M; i++) {
			String arr[]=scanner.nextLine().split(" ");
			map.put(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
			N+=Integer.parseInt(arr[1]);
			/*for (int j = 0; j < Integer.parseInt(arr[1]); j++) {
				list.add(Integer.parseInt(arr[0]));
			}*/
		}
		long noOfQuantiles=Q-1;
		Iterator itr=map.entrySet().iterator();
		Entry<Integer, Integer> entry=(Entry<Integer, Integer>) itr.next();
		int startIndex=0;
		int endIndex=entry.getValue();
		for (long i = 1; i <=noOfQuantiles; i++) {
			int value=(int)Math.ceil(N*i/Q);
			if(value>=startIndex && value<=endIndex)
			{
				System.out.println(entry.getKey());
				continue;
			}
			if(itr.hasNext()){
				entry=(Entry<Integer, Integer>) itr.next();
				startIndex=endIndex;
				endIndex+=entry.getValue();
				i--;
			}
		}
	}


}

