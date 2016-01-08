package hackerRank.Algorithms.Implementation;

import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/challenges/the-time-in-words
 */
public class _17TimeInWords {

	public static void main(String ards[])
	{
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		int H=Integer.parseInt(scanner.nextLine());
		int M=Integer.parseInt(scanner.nextLine());
		String hour=decodeHour(H);
		String minutes=decodeMinutes(M);
		if(M==0){
			System.out.println(hour+" "+minutes);
		}
		else if(minutes.contains("to"))
		{
			System.out.println(minutes+" "+decodeHour(H+1));
		}
		else
		{
			System.out.println(minutes+" "+hour);
		}
	}

	private static String decodeMinutes(int m) {
		String connector="";
		if(m<=30)
			connector="past";
		else{
			m=60-m;
			connector="to";
		}
		switch (m) {
		case 0:return "o' clock";
		case 1:return "one minute "+connector;
		case 2:return "two minutes "+connector;
		case 3:return "three minutes "+connector;
		case 4:return "four minutes "+connector;
		case 5:return "five minutes "+connector;
		case 6:return "six minutes "+connector;
		case 7:return "seven minutes "+connector;
		case 8:return "eight minutes "+connector;
		case 9:return "nine minutes "+connector;
		case 10:return "ten minutes "+connector;
		case 11:return "eleven minutes "+connector;
		case 12:return "twelve minutes "+connector;
		case 13:return "thirteen minutes "+connector;
		case 14:return "fourteen minutes "+connector;
		case 15:return "quarter "+connector;
		case 16:return "sixteen minutes "+connector;
		case 17:return "seventeen minutes "+connector;
		case 18:return "eighteen minutes "+connector;
		case 19:return "nineteen minutes "+connector;
		case 20:return "twenty minutes "+connector;
		case 21:return "twenty one minutes "+connector;
		case 22:return "twenty two minutes "+connector;
		case 23:return "twenty three minutes "+connector;
		case 24:return "twenty four minutes "+connector;
		case 25:return "twenty five minutes "+connector;
		case 26:return "twenty six minutes "+connector;
		case 27:return "twenty seven minutes "+connector;
		case 28:return "twenty eight minutes "+connector;
		case 29:return "twenty nine minutes "+connector;
		case 30:return "half "+connector;
		}
		return "";
	}

	private static String decodeHour(int h) {
		switch (h) {
		case 1:return "one";
		case 2:return "two";
		case 3:return "three";
		case 4:return "four";
		case 5:return "five";
		case 6:return "six";
		case 7:return "seven";
		case 8:return "eight";
		case 9:return "nine";
		case 10:return "ten";
		case 11:return "eleven";
		}
		return "";
	}
}
