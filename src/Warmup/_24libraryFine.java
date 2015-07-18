package Warmup;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _24libraryFine {
		public static void main(String[] args) throws Exception {
			BufferedReader scanner=new BufferedReader(new InputStreamReader(System.in));
			String actualreturnDate=scanner.readLine();
			String expectedReturnDate=scanner.readLine();
			String[] actualreturnDateArray=actualreturnDate.split(" ");
			String[] expectedReturnedDateArray=expectedReturnDate.split(" ");	
			
			int actualReturnedDay=Integer.parseInt(actualreturnDateArray[0].trim());
			int actualReturnedMonth=Integer.parseInt(actualreturnDateArray[1].trim());
			int actualReturnedYear=Integer.parseInt(actualreturnDateArray[2].trim());
			int expectedReturnedDay=Integer.parseInt(expectedReturnedDateArray[0].trim());
			int expectedReturnedMonth=Integer.parseInt(expectedReturnedDateArray[1].trim());
			int expectedReturnedYear=Integer.parseInt(expectedReturnedDateArray[2].trim());
			if(actualReturnedYear<expectedReturnedYear){
				System.out.println("0");
			}
			else if(actualReturnedYear>expectedReturnedYear){
				System.out.println("10000");
			}
			else{//year is same
				if(actualReturnedMonth<expectedReturnedMonth){
					System.out.println("0");
				}
				else if(actualReturnedMonth>expectedReturnedMonth){
					System.out.println((actualReturnedMonth-expectedReturnedMonth)*500);
				}
				else{//same month
					if(actualReturnedDay<=expectedReturnedDay){
						System.out.println("0");
					}
					else if(actualReturnedDay>expectedReturnedDay){
						System.out.println((actualReturnedDay-expectedReturnedDay)*15);
					}
				}
			}
		}
}
