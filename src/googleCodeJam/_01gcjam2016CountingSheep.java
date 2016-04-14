package googleCodeJam;

import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

/*
 * Main Link: https://code.google.com/codejam/contests.html
 * Problem Link:https://code.google.com/codejam/contest/6254486/dashboard#s=p0
 */
public class _01gcjam2016CountingSheep {


	public static void main(String[] args) {
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		Integer noOfTestCases=Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < noOfTestCases; i++) {
			int number=Integer.parseInt(scanner.nextLine());
			System.out.println("Case #"+(i+1)+": "+findCount(number));
		}
		scanner.close();
	}

	private static String findCount(int number) {
		String output="INSOMNIA";
		int product=number*1;
		if(product==0)
			return output;
		HashSet<Integer> set=new HashSet<>();
		String prodString=product+"";
		for (int i = 0; i < prodString.length(); i++) {
			set.add(Integer.parseInt((prodString.charAt(i)+"")));
		}
		int counter=1;
		while((product>0 && product<Integer.MAX_VALUE)&&set.size()<10){
			counter++;
			product=number*counter;
			prodString=product+"";
			for (int i = 0; i < prodString.length(); i++) {
				set.add(Integer.parseInt((prodString.charAt(i)+"")));
			}
			output=counter*number+"";
		}
		return output;
	}


}
