package Warmup;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class _30modifiedKaprekarNumbers {
	public static void main(String[] args) throws Exception {
		BufferedReader scanner=new BufferedReader(new InputStreamReader(System.in));
		int p=Integer.parseInt(scanner.readLine());
		int q=Integer.parseInt(scanner.readLine());
		LinkedList<Integer> kaprekarOutput=new LinkedList<Integer>();
		for (int i = p; i <= q; i++) {
			int number=i;
			if(i==1){
				kaprekarOutput.add(i);
				continue;
			}
			Long squaredOutput=(long) (number)*(long) (number);
			String numberString=squaredOutput.toString();
			int numberLength=numberString.length();
			if(numberLength==1)
				continue;
			Long leftNumber=Long.parseLong(numberString.substring(0,numberLength/2));
			Long rightNumber=Long.parseLong(numberString.substring(numberLength/2));
			if(leftNumber+rightNumber==number)
				kaprekarOutput.add(number);
		}
		if(kaprekarOutput.size()>0)
		{
			String str="";
			for (int i = 0; i < kaprekarOutput.size(); i++) {
				str+=kaprekarOutput.get(i)+" ";
			}
			System.out.println(str.trim());
		}
		else{
			System.out.println("INVALID RANGE");
		}
	}
}
