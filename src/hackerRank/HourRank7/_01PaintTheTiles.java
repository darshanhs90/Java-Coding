	package hackerRank.HourRank7;
	
	import java.util.Scanner;
	
	public class _01PaintTheTiles {
	
	
	
		public static void main(String[] args) {
			Scanner in = new Scanner(System.in);
			int N = Integer.parseInt(in.nextLine());
			String str =(in.nextLine());
			System.out.println(findStrokes(str));
		}
	
		private static int findStrokes(String str) {
			int count=0;
			char c=str.charAt(0);
			count=1;
			char c1 = 0;
			for (int i = 1; i < str.length(); i++) {
				c1=str.charAt(i);
				if(c1!=c)
				{
					c=c1;
					count++;
				}
			}
			return count;
		}
	
	
	
	}
