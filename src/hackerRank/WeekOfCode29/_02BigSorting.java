package hackerRank.WeekOfCode29;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/contests/w29/challenges/big-sorting
 */
public class _02BigSorting {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<String> list=new ArrayList<>();
        for(int unsorted_i=0; unsorted_i < n; unsorted_i++){
            list.add(in.next());
        }
        // your code goes here
        Collections.sort(list,new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(o1.length()!=o2.length())
					return o1.length()-o2.length();
				return new BigInteger(o1).compareTo(new BigInteger(o2));
			}
		});
        for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
    }
}

