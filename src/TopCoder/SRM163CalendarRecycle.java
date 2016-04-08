package TopCoder;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/*
 * SRM 163 Div2
 * Link:https://community.topcoder.com/stat?c=problem_statement&pm=1847&rd=4620
 */



public class SRM163CalendarRecycle {
	public static void main(String[] args)  {
		System.out.println(useAgain(2002));
		System.out.println(useAgain(2013));
		System.out.println(useAgain(2008));
		System.out.println(useAgain(9999));
		System.out.println(useAgain(2525));
	}
	@SuppressWarnings("deprecation")
	public static int useAgain(int year){
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
		int day;
		year++;
		try {
			day = sf.parse("08/09/"+year).getDay();
			while(day!=0){
				year++;
				day = sf.parse("08/09/"+year).getDay();
			}
			return year;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
