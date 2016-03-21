package TopCoder;

/*
 * SRM 150 Div2
 * Link:https://community.topcoder.com/stat?c=problem_statement&pm=1346&rd=4555
 */



public class SRM150WidgetRepairs {
	public static void main(String[] args) {
		System.out.println(days(new int[]{10, 0, 0, 4, 20 },8));
		System.out.println(days(new int[]{0, 0, 0},10));
		System.out.println(days(new int[]{100, 100},10));
		System.out.println(days(new int[]{27, 0, 0, 0, 0, 9},9));
		System.out.println(days(new int[]{6, 5, 4, 3, 2, 1, 0, 0, 1, 2, 3, 4, 5, 6},3));
	}
	public static int days(int[] arrivals, int numPerDay){
		int count=0;
		int extras=0;
		for (int i = 0; i < arrivals.length; i++) {
			extras+=arrivals[i];
			if(extras!=0)
			{
				count++;
				if(extras>=numPerDay)
					extras-=numPerDay;
				else
					extras=0;
			}
		}
		return count+(int)Math.ceil(extras/(float)numPerDay);
	}
}
