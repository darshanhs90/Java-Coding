package Warmup;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class _28gridSearch {
	public static void main(String[] args) throws Exception {
		BufferedReader scanner=new BufferedReader(new InputStreamReader(System.in));
		int noOfTestCases=Integer.parseInt(scanner.readLine());
		for (int i = 0; i < noOfTestCases; i++) {
			String firstLineArray[]=scanner.readLine().split(" ");
			boolean patternPresent=false;
			int R=Integer.parseInt(firstLineArray[0]);
			int C=Integer.parseInt(firstLineArray[1]);
			ArrayList<String> gridList=new ArrayList<String>();
			for (int j = 0; j < R; j++) {
				gridList.add(scanner.readLine());
			}	
			
			String nextLineArray[]=scanner.readLine().split(" ");
			int r=Integer.parseInt(nextLineArray[0]);
			int c=Integer.parseInt(nextLineArray[1]);
			ArrayList<String> patternList=new ArrayList<String>();
			for (int j = 0; j < r; j++) {
				patternList.add(scanner.readLine());
			}	
			
			for (int j = 0; j < gridList.size(); j++) {
				String patternLine=patternList.get(0);
				if(gridList.get(j).contains(patternLine)){//we got the first match
					gridList.get(j).indexOf(patternLine);
					
				}
				
			}
			
			
			
			
			
			if(patternPresent)
			{
				System.out.println("YES");
			}
			else{
				System.out.println("NO");

			}	
		}
	}
}
