package TopCoder.Div1;

/*
 * SRM 144 Div2
 * Link:https://community.topcoder.com/stat?c=problem_statement&pm=1708&rd=4515
 */



public class Time {
	/*public static void main(String[] args) {
		System.out.println(whatTime(0));
		System.out.println(whatTime(3661));
		System.out.println(whatTime(5436));
		System.out.println(whatTime(86399));
	}*/
	public static String whatTime(int seconds){
		int secondsValue=(seconds%60);
		int hoursValue=(seconds/3600);
		int minutesValue=(seconds/60)%60;
		return hoursValue+":"+minutesValue+":"+secondsValue;
	}
}
