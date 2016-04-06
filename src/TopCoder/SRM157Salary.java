package TopCoder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/*
 * SRM 157 Div2
 * Link:https://community.topcoder.com/stat?c=problem_statement&pm=1790&rd=4590
 */



public class SRM157Salary {
	public static void main(String[] args) throws ParseException {
		System.out.println(howMuch(new String[]{"08:00:00","13:00:00","19:27:32"}, new String[]{"12:00:00","17:00:00","20:48:10"},1000 ));
		System.out.println(howMuch(new String[]{"01:05:47","16:48:12"},new String[]{"09:27:30","21:17:59"},2000));
		System.out.println(howMuch(new String[]{"00:00:00"}, new String[]{"23:59:59"},10000 ));
		System.out.println(howMuch(new String[]{"10:00:00"}, new String[]{"18:00:00"},10000));
		System.out.println(howMuch(new String[]{"22:19:46"}, new String[]{"23:12:46"},5320 ));
	}
	public static int howMuch(String[] arrival, String[] departure, int wage) throws ParseException{
		double value=0;
		SimpleDateFormat s=new SimpleDateFormat("HH:mm:ss");
		Date beforeTime=s.parse("06:00:00");
		Date afterTime=s.parse("18:00:00");
		TimeUnit timeUnit=TimeUnit.MINUTES;
		for (int i = 0; i < departure.length; i++) {
			Date date1=s.parse(arrival[i]);
			Date date2=s.parse(departure[i]);
			double seconds=0;
			long beforeDiff=0l;
			if(date1.before(beforeTime)){
				if(date2.after(afterTime)){
					beforeDiff=beforeTime.getTime()-date1.getTime();
					seconds+=((timeUnit.convert(beforeDiff,TimeUnit.MINUTES)*1.5*wage/(double)3600000));
					beforeDiff=afterTime.getTime()-beforeTime.getTime();
					seconds+=((timeUnit.convert(beforeDiff,TimeUnit.MINUTES)*1*wage/(double)3600000));
					beforeDiff=date2.getTime()-afterTime.getTime();
					seconds+=((timeUnit.convert(beforeDiff,TimeUnit.MINUTES)*1.5*wage/(double)3600000));
				}
				else if(date2.before(beforeTime)){
					beforeDiff=date2.getTime()-date1.getTime();
					seconds+=((timeUnit.convert(beforeDiff,TimeUnit.MINUTES)*1.5*wage/(double)3600000));
				}
				else{
					beforeDiff=beforeTime.getTime()-date1.getTime();
					seconds+=((timeUnit.convert(beforeDiff,TimeUnit.MINUTES)*1.5*wage/(double)3600000)); 
					beforeDiff=date2.getTime()-beforeTime.getTime();
					seconds+=((timeUnit.convert(beforeDiff,TimeUnit.MINUTES)*1*wage/(double)3600000));
				}
			}
			else if(date2.after(afterTime)){
				if(date1.after(afterTime)){
					beforeDiff=date2.getTime()-date1.getTime();
					seconds+=((timeUnit.convert(beforeDiff,TimeUnit.MINUTES)*1.5*wage/(double)3600000));
				}
				else{
					beforeDiff=afterTime.getTime()-date1.getTime();
					seconds+=((timeUnit.convert(beforeDiff,TimeUnit.MINUTES)*1*wage/(double)3600000));
					beforeDiff=date2.getTime()-afterTime.getTime();
					seconds+=((timeUnit.convert(beforeDiff,TimeUnit.MINUTES)*1.5*wage/(double)3600000));
				}
			}
			else{
				beforeDiff = date2.getTime() - date1.getTime();
				seconds+=((timeUnit.convert(beforeDiff,TimeUnit.MINUTES)*1*wage/(double)3600000));
			}
			value+=seconds;
		}
		return (int)(value);
	}
}
