package Warmup;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _02isFiboAlternative {
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Long noOfTestCases=Long.parseLong(br.readLine());
		for (Long i = 0l; i < noOfTestCases; i++) {
			try{
				Integer num=Integer.parseInt(br.readLine());
				/**/
				/*double val=(float) Math.pow(num,2);
				double add=(double) Math.sqrt(5*(val)+4);
				double sub=(double) Math.sqrt(5*(val)-4);*/
				
				double val=(double) Math.pow(num,2);
				double add=(double) Math.sqrt(5*(val)+4);
				double sub=(double) Math.sqrt(5*(val)-4);
				if(add%1==0 || sub%1==0){
					System.out.println("IsFibo");
				}
				else{
					System.out.println("IsNotFibo");
				}
			}
			catch(NumberFormatException e){
				/**/System.out.println("IsNotFibo");
			}
			
			
		}
	}
}
