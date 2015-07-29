package Warmup;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _39twoStrings {
	public static void main(String[] args) throws Exception {
		BufferedReader scanner=new BufferedReader(new InputStreamReader(System.in));
		int noOfTestCases=Integer.parseInt(scanner.readLine());
		for (int i = 0; i < noOfTestCases; i++) {
			String firstLine=scanner.readLine();
			String secondLine=scanner.readLine();
			Boolean flag=false;
			for (int j = 97; j < 123; j++) {
				char a=(char)j;
				int firstLinePrevLength=firstLine.length();
				int firstLinePostLength=firstLine.replaceAll(a+"","").length();
				int secondLinePrevLength=secondLine.length();
				int secondLinePostLength=secondLine.replaceAll(a+"","").length();
				if(firstLinePrevLength!=firstLinePostLength && secondLinePrevLength!=secondLinePostLength){
					flag=true;
					System.out.println("YES");
					break;
				}
			}
			if(flag==false){
				System.out.println("NO");
			}
		}
	}
}
