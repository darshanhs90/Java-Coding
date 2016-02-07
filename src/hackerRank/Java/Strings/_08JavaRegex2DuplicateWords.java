package hackerRank.Java.Strings;

import java.util.Scanner;
import java.util.regex.Pattern;

/*
 * Link:https://www.hackerrank.com/challenges/duplicate-word
 */

public class _08JavaRegex2DuplicateWords {

	public static void main(String []args)
	{
		Scanner in = new Scanner(System.in);
		while(in.hasNext())
		{
			String IP = in.next();
			System.out.println(IP.matches(new myRegex().pattern));
			System.out.println(IP.matches("[0-255]"+"."+"[0-255]"+"."+"[0-255]"+"."+"[0-255]"));
		}

	}
	static class myRegex{
		String pattern;
		public myRegex(){
			this.pattern="[0-255]"+"."+"[0-255]"+"."+"[0-255]"+"."+"[0-255]";

		}


	}
}
