package Warmup;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class _29timeInWords {
	public static void main(String[] args) throws Exception {
		BufferedReader scanner=new BufferedReader(new InputStreamReader(System.in));
		int H=Integer.parseInt(scanner.readLine());
		int M=Integer.parseInt(scanner.readLine());
		String hourString="";
		String minuteString="";
		boolean minuteFirst=true;
		String connector="";
		if(M==0){
			connector="o' clock";
			minuteFirst=false;
		}else if(M==1){
			connector="minute past";
		}else if(M>=2 && M<15 || M>15 && M<30){
			connector="minutes past";
		}else if(M==15){
			connector="quarter past";
		}else if(M==30){
			connector="half past";
		}else if(M>30 && M<44||M>45 && M<=58){
			connector="minutes to";
		}else if(M==45){
			connector="quarter to";
		}else if(M>58){
			connector="minute to";
		}
		hourString=getNumberString(H);
		if(M>30){
			M=60-M;
			if(H==12){
				H=0;
			}
			hourString=getNumberString(H+1);
		}
		minuteString=getNumberString(M);
		if(minuteFirst)
			System.out.println((minuteString+" "+connector+" "+hourString).trim());
		else
			System.out.println((hourString+" "+connector+" "+minuteString).trim());
			
	}

	public static String getNumberString(int value){
		if(value==1){
			return "one";
		}else if(value==2){
			return "two";
		}else if(value==3){
			return "three";
		}else if(value==4){
			return "four";
		}else if(value==5){
			return "five";
		}else if(value==6){
			return "six";
		}else if(value==7){
			return "seven";
		}else if(value==8){
			return "eight";
		}else if(value==9){
			return "nine";
		}else if(value==10){
			return "ten";
		}else if(value==11){
			return "eleven";
		}else if(value==12){
			return "twelve";
		}else if(value==13){
			return "thirteen";
		}else if(value==14){
			return "fourteen";
		}else if(value==16){
			return "sixteen";
		}else if(value==17){
			return "seventeen";
		}else if(value==18){
			return "eightteen";
		}else if(value==19){
			return "nineteen";
		}else if(value==20){
			return "twenty";
		}else if(value==21){
			return "twenty one";
		}else if(value==22){
			return "twenty two";
		}else if(value==23){
			return "twenty three";
		}else if(value==24){
			return "twenty four";
		}else if(value==25){
			return "twenty five";
		}else if(value==26){
			return "twenty six";
		}else if(value==27){
			return "twenty seven";
		}else if(value==28){
			return "twenty eight";
		}else if(value==29){
			return "twenty nine";
		}else {
			return "";
		}
	}
}
