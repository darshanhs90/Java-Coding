package hackerRank.Algorithms.Implementation;

import java.util.HashMap;
import java.util.Scanner;
/*
 * https://www.hackerrank.com/challenges/bon-appetit
 */
public class _29SockMerchant {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int count=0;
		HashMap<Integer, Integer> map=new HashMap<>();
		for(int c_i=0; c_i < n; c_i++){
			int value=in.nextInt();
			if(map.containsKey(value))
			{
				if(map.get(value)==1)
				{
					count++;
					map.remove(value);
				}
			}
			else{
				map.put(value, 1);
			}
		}
		System.out.println(count);
	}
}
