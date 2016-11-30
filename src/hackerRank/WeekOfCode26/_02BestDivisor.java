package hackerRank.WeekOfCode26;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/contests/w26/challenges/best-divisor
 */
public class _02BestDivisor {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		List<String> list=findDivisors(n);
		list.add(n+"");
		Collections.sort(list,new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.length()==1 && o2.length()==1)
					return Integer.compare(Integer.parseInt(o1),Integer.parseInt(o2));
				else
				{
					int o1Value=0;
					if(o1.length()>1)
					{
						for (int i = 0; i < o1.length(); i++) {
							o1Value+=Character.getNumericValue(o1.charAt(i));
						}
					}
					else{
						o1Value=Integer.parseInt(o1);
					}

					int o2Value=0;
					if(o2.length()>1)
					{
						for (int i = 0; i < o2.length(); i++) {
							o2Value+=Character.getNumericValue(o2.charAt(i));
						}
					}
					else{
						o2Value=Integer.parseInt(o2);
					}

					if(o1Value==o2Value)
						return Integer.compare(o2Value, o1Value);
					return Integer.compare(o1Value, o2Value);
				}
			}

		});
		//System.out.println(list);
		System.out.println(list.get(list.size()-1));

	}

	private static List<String> findDivisors(int n) {
		List<String> list=new ArrayList<>();
		for (int i = 1; i <=(n/2); i++) {
			if(n%i==0)
				list.add(i+"");
		}
		return list;
	}
}

