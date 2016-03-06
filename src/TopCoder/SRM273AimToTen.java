package TopCoder;

/*
 * SRM 273 Div1
 * Link:https://community.topcoder.com/stat?c=problem_statement&pm=5879
 */

public class SRM273AimToTen {
	public static void main(String[] args) {
		System.out.println(need(new int[]{9, 10, 10, 9}));
		System.out.println(need(new int[]{8,9}));
		System.out.println(need(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
		System.out.println(need(new int[]{10, 10, 10, 10}));
	}
	public static int need(int[] marks){
		float average=0;
		int total=0;
		for (int i = 0; i < marks.length; i++) {
			total+=marks[i];
		}
		average=total/(float)marks.length;
		if(average>=9.5)
		{
			return 0;
		}
		else{
			int count=marks.length;
			while(average<9.5){
				count++;
				total+=10;
				average=total/(float)count;
			}
			return count-marks.length;
		}
	}
}
