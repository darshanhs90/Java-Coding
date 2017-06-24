package hackerRank.WeekOfCode32;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class _04GeometricTrick {
	static int geometricTrick(String s){
		// Complete this function
		Set<Integer> aSet=new TreeSet<>();
		Set<Integer> bSet=new TreeSet<>();
		Set<Integer> cSet=new TreeSet<>();
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)=='a')
				aSet.add(i);
			else if(s.charAt(i)=='b')
				bSet.add(i);
			else if(s.charAt(i)=='c')
				cSet.add(i);
		}
		Iterator aiter = aSet.iterator();
		Iterator biter = bSet.iterator();
		int i,j,k;
		int count=0;
		while (aiter.hasNext()) {
			i=(int) aiter.next();
			biter = bSet.iterator();
			while (biter.hasNext()) {
				j=(int) biter.next();
				double kValue=Math.pow(j+1, 2)/(double)(i+1);
				if(kValue==Math.floor(kValue) && cSet.contains((int)(kValue-1))){
					count++;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String s = in.next();
		int result = geometricTrick(s);
		System.out.println(result);
	}
}
