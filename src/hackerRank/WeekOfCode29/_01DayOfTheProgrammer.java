package hackerRank.WeekOfCode29;

import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/contests/w29/challenges/day-of-the-programmer
 */
public class _01DayOfTheProgrammer {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int y = in.nextInt();
        // your code goes here
        String leapYearValue="12.09.";
        String normalYearValue="13.09.";
        if(y>=1700 && y<=1917)
        {
        	//julian calendar
        	if(y%4==0)
        	{
        		System.out.println(leapYearValue+"."+y);
        	}
        	else{
        		System.out.println(normalYearValue+"."+y);
        	}
        }
        else if(y==1918)
        {
        	//changed stuff
        	System.out.println("26.09.1918");
        }
        else{
        	//gregorian calendar
        	if((y%400==0)||(y%4==0 && y%100!=0))
        	{
        		System.out.println(leapYearValue+"."+y);
        	}
        	else{
        		System.out.println(normalYearValue+"."+y);
        	}
        }
    }
}

