package Warmup;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _23timeConversion {
	public static void main(String[] args) throws Exception {
		BufferedReader scanner=new BufferedReader(new InputStreamReader(System.in));
		String timeInput=scanner.readLine();
		String timeZone=(timeInput.substring(timeInput.length()-2,timeInput.length()));
		if(timeZone.equals("AM")){
			int hours=Integer.parseInt(timeInput.substring(0, 2));
			if(hours==12){
				System.out.println("00"+timeInput.substring(2,timeInput.length()-2));
			}
			else{
			System.out.println(timeInput.substring(0,timeInput.length()-2));
			}
		}
		else
		{
			int hours=Integer.parseInt(timeInput.substring(0, 2));
			if(hours!=12)
			hours+=12;
			System.out.println(hours+timeInput.substring(2,timeInput.length()-2));
		}
	}
}
