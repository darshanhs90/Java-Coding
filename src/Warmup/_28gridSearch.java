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
				if(patternPresent){
					break;
				}
				String patternLine=patternList.get(0);
				if(gridList.get(j).contains(patternLine)){//we got the first match
					int firstIndex=gridList.get(j).indexOf(patternLine);
					int nextIndex=firstIndex;
					while(nextIndex!=-1 && !patternPresent){
						int m=0;
						for (int k1 = j; k1 < j+r; k1++) {
							if(gridList.get(k1).substring(firstIndex, firstIndex+c).equals(patternList.get(m))){
								m++;
							}
							else{
								break;
							}
						}
						if(m==r){
							System.out.println("YES");
							patternPresent=true;
							break;
						}
						nextIndex=gridList.get(j).indexOf(patternLine, firstIndex+1);
					}
				}
			}
			if(!patternPresent)
				System.out.println("NO");
		}
	}
}
