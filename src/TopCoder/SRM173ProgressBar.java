package TopCoder;

/*
 * SRM 173 Div2
 * Link:https://community.topcoder.com/stat?c=problem_statement&pm=1975&rd=4670
 */



public class SRM173ProgressBar {
	public static void main(String[] args) {
		//System.out.println(showProgress(new int[]{19,6,23,17},3));
		//System.out.println(showProgress(new int[]{2,3,7,1,4,3},4));
		//System.out.println(showProgress(new int[]{553,846,816,203,101,120,161,818,315,772},4));
		//System.out.println(showProgress(new int[]{7,60,468,489,707,499,350,998,1000,716,457,104,597,583,396,862},2));
		//System.out.println(showProgress(new int[]{419,337,853,513,632,861,336,594,94,367,336,297,966,627,399,433,846,859,80,2},19));
	}
	public static String showProgress(int[] taskTimes, int tasksCompleted){
		int total=0;
		int completed=0;
		for (int i = 0; i < taskTimes.length; i++) {
			if(i<tasksCompleted)
				completed+=taskTimes[i];
			total+=taskTimes[i];
		}
		double percentComplete=20*(completed/(float)total);
		int percent=(int)Math.floor(percentComplete);
		StringBuilder sb=new StringBuilder();
		for (int i = 1; i <=20; i++) {
			if(i<=percent)
				sb.append("#");
			else
				sb.append(".");
		}
		return sb.toString();
	}
}
