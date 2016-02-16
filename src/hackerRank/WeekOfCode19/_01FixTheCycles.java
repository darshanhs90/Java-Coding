package hackerRank.WeekOfCode19;


import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/contests/w19/challenges/fix-the-cycles
 */
public class _01FixTheCycles {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int a=scanner.nextInt();
		int b=scanner.nextInt();
		int c=scanner.nextInt();
		int d=scanner.nextInt();
		int e=scanner.nextInt();
		int f=scanner.nextInt();
		int cycle=a+b+f;
		int cycle2=e+d+a;
		int cycle3=a+b+c+d;;
		if(cycle>0 && cycle2>0 && cycle3>0)
			System.out.println("0");
		else{
			int min=Integer.MAX_VALUE;
			if(a<0)
			{
				min=Math.min(Math.abs(Math.min(Math.min(a+b+f,a+d+e),a+b+c+d)),min);
			}
			if(b<0 && (cycle<0 || cycle3<0) && cycle2>=0)
			{
				min=Math.min(Math.abs(Math.min(b+(f+a),b+c+d+a)),min);				
			}
			if(c<0 && cycle3<0 && cycle>=0 && cycle2>=0)
			{
				min=Math.min(min,Math.abs(c+a+b+d));
			}
			if(d<0 && cycle>=0 && (cycle3<0 || cycle2<0))
			{
				min=Math.min(Math.abs(Math.min(d+a+e,d+a+b+c)),min);
			}
			if(e<0 && cycle>=0 && cycle3>=0 && cycle2<0)
			{
				min=Math.min(Math.abs(e+d+a),min);
			}
			if(f<0 && cycle<0 && cycle3>=0 && cycle2>=0)
			{
				min=Math.min(Math.abs(f+b+a),min);
			}
			System.out.println(min);
		}
	}
}
