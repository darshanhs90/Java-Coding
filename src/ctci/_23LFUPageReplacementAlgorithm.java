package ctci;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;


/*Implementation of LFU Page Replacement Algorithm*/
public class _23LFUPageReplacementAlgorithm{

	public static void main(String[] args) {
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		String inputArray[]=scanner.nextLine().split(",");
		int frameLength=Integer.parseInt(scanner.nextLine());
		//c,a,d,b,e,b,a,b,c,d
		//7,0,1,2,0,3,0,4,2,3,0,3,2,1,2,0,1,7,0,1
		//output:2,0,1
		scanner.close();
		for (int i = 0; i < inputArray.length; i++) {
			System.out.print(inputArray[i]+" ");
		}
		performLFUReplacement(inputArray,frameLength);

	}

	private static void performLFUReplacement(String[] inputArray,
			int frameLength) {
		String frameArray[]=new String[frameLength];
		Arrays.fill(frameArray," ");
		HashMap<String,Integer> elementMap=new HashMap<String, Integer>();
		for (int i = 0; i < inputArray.length; i++) {
			String element=inputArray[i];
			int elementIndex=-1;
			if((elementIndex=checkElement(frameArray,element))!=-1 || !elementMap.containsKey(element)){
				if(elementIndex!=-1){
					int index=getIndexForReplacement(elementMap,frameArray,element);
					frameArray[index]=element;
					elementMap.put(element,elementMap.get(inputArray[i])+1);
				}
				else{
					frameArray=addToArrayStart(frameArray,element);
					elementMap.put(element,1);
				}
			}
			System.out.println(Arrays.toString(frameArray));
		}

	}

	private static String[] addToArrayStart(String[] frameArray, String element) {
		String newArray[]=new String[frameArray.length];
		Arrays.fill(newArray," ");
		newArray[0]=element;
		for (int i = 1; i < newArray.length; i++) {
			newArray[i]=frameArray[i-1];
		}
		return newArray;
	}

	private static int checkElement(String[] frameArray, String element) {
		for (int i = 0; i < frameArray.length; i++) {
			if(frameArray[i].contentEquals(element))
				return i;
		}
		return -1;
	}

	private static int getIndexForReplacement(
			HashMap<String, Integer> elementMap, String[] frameArray,
			String element) {
		int index=-1,min=Integer.MAX_VALUE;
		for (int i = 0; i < frameArray.length; i++) {
			if(elementMap.containsKey(frameArray[i]))
			{
				if(elementMap.get(frameArray[i])<min){
					index=i;
					min=elementMap.get(frameArray[i]);
				}
			}
		}
		return index;
	}


}