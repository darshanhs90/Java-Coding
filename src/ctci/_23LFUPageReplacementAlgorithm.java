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
		System.out.println();
		performLFUReplacement(inputArray,frameLength);

	}

	private static void performLFUReplacement(String[] inputArray,
			int frameLength) {
		String frameArray[]=new String[frameLength];
		Arrays.fill(frameArray," ");
		HashMap<String,Integer> elementMap=new HashMap<String, Integer>();
		int arrayFillCount=0;
		for (int i = 0; i < inputArray.length; i++) {
			String element=inputArray[i];
			int elementIndex=-1;
			//check if element is there in frame array
			//if there leave it be and increment the count
			//if not there,check if array is filled?
			//if array is filled,get position for replacement
			//if not filled,add to counter
			if((elementIndex=checkElement(frameArray,element))!=-1){
				elementMap.put(element,elementMap.get(element)+1);
			}
			else{
				if(arrayFillCount<frameLength){
					if(!elementMap.containsKey(element)){
						frameArray[arrayFillCount]=element;
						elementMap.put(element,1);
						arrayFillCount++;
					}
				}
				else{
					int index=getReplacementPosition(frameArray,elementMap);
					frameArray[index]=element;
					if(elementMap.containsKey(element)){
						elementMap.put(element,elementMap.get(element)+1);
					}
					else{
						elementMap.put(element,1);
					}
				}
			}
			System.out.println("Adding : "+element+"  "+Arrays.toString(frameArray));
		}

	}

	private static int getReplacementPosition(String[] frameArray,
			HashMap<String, Integer> elementMap) {
		int index=0,min=Integer.MAX_VALUE;
		for (int i = 0; i < frameArray.length; i++) {
			String element=frameArray[i];
			if(elementMap.containsKey(element)){
				if(elementMap.get(element)<min)
				{
					min=elementMap.get(element);
					index=i;
				}
			}
		}
		return index;
	}

	private static int checkElement(String[] frameArray, String element) {
		for (int i = 0; i < frameArray.length; i++) {
			if(frameArray[i].contentEquals(element)){
				return i;
			}
		}
		return -1;
	}



}