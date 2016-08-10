package Warmup;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class _76IndeedChallenge {
	/*public static void main(String args[] ) throws Exception {
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
						for (int j = 0; j < Integer.parseInt(arr[1]); j++) {
				list.add(Integer.parseInt(arr[0]));
			}
		}
		//Collections.sort(list);
		long noOfQuantiles=Q-1;
		Iterator itr=map.entrySet().iterator();
		Entry<Integer, Integer> entry=(Entry<Integer, Integer>) itr.next();
		int startIndex=0;
		int endIndex=entry.getValue();
		for (long i = 1; i <=noOfQuantiles; i++) {
			int value=(int)Math.ceil(N*i/Q);
			//System.out.println(value);
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
	}*/
/*	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int Q = scan.nextInt();
		int M = scan.nextInt();
		int vi = 0;
		int ci = 0;
		Set<Integer> s1 = new HashSet<Integer>();
		for (int i = 0; i < M; i++) {
			vi = scan.nextInt();
			ci = scan.nextInt();
			for (int j = 0; j < ci; j++) {
				s1.add(vi);
			}
		}
		TreeSet<Integer> sortedSet=new TreeSet<Integer>(s1);
		List<Integer> list = new ArrayList<Integer>(sortedSet);
		if (Q > 2) {
			for (int l = 0; l < Q-1; l++) {
				double[] iK = new double[Q];
				//int k = Q - 1;
				iK[l] = Math.floor(list.size() * l / Q);
				System.out.println(list.get((int) iK[l]));
			}
		}
		else{
			double iK=0;
			int k=Q-1;
			iK=Math.floor(list.size()*k/Q);
			System.out.println(list.get((int)iK));
		}
	}*/


}

