package TopCoder;

import java.util.Arrays;
import java.util.TreeMap;

/*
 * SRM 159 Div2
 * Link:https://community.topcoder.com/stat?c=problem_statement&pm=1753&rd=4600
 */



public class SRM159Sets {
	public static void main(String[] args)  {
		System.out.println(Arrays.toString(operate(new int[]{1,2,3,4}, new int[]{3,4,5,6},"INTERSECTION")));
		System.out.println(Arrays.toString(operate(new int[]{1,2,3,4}, new int[]{3,4,5,6},"UNION")));
		System.out.println(Arrays.toString(operate(new int[]{432,756,123}, new int[]{534,76,1209},"INTERSECTION")));
		System.out.println(Arrays.toString(operate(new int[]{6,5,7,4}, new int[]{7,6,4,10},"SYMMETRIC DIFFERENCE" )));
		System.out.println(Arrays.toString(operate(new int[]{342,654,897,312,76,23,78}, new int[]{21,43,87,98,23,756,897,234,645,876,123},"SYMMETRIC DIFFERENCE")));
	}
	public static int[] operate(int[] A, int[] B, String operation){
		int[] output = null;
		TreeMap<Integer, Integer> elementCount=new TreeMap<>();
		int count=0,counter=0;
		Object arr[]=null;
		switch(operation){
		case "UNION":
			count=0;
			for (int i = 0; i < A.length; i++) {
				elementCount.put(A[i], 1);
			}
			for (int i = 0; i < B.length; i++) {
				elementCount.put(B[i], 1);
			}
			counter=0;
			arr=elementCount.keySet().toArray();
			output=new int[arr.length];
			for (int i = 0; i < arr.length; i++) {
				output[counter]=(int) arr[i];
				counter++;
			}
			break;
		case "INTERSECTION":
			count=0;
			for (int i = 0; i < A.length; i++) {
				elementCount.put(A[i], 1);
			}
			for (int i = 0; i < B.length; i++) {
				if(elementCount.containsKey(B[i])){
					count++;
					elementCount.put(B[i], 2);
				}
			}
			counter=0;
			arr=elementCount.keySet().toArray();
			output=new int[count];
			for (int i = 0; i < arr.length; i++) {
				if(elementCount.get(arr[i])==2){
					output[counter]=(int) arr[i];
					counter++;
				}
			}
			break;
		case "SYMMETRIC DIFFERENCE":
			count=0;
			for (int i = 0; i < A.length; i++) {
				elementCount.put(A[i], 1);
				count++;
			}
			for (int i = 0; i < B.length; i++) {
				if(elementCount.containsKey(B[i])){
					elementCount.put(B[i], 2);
					count--;
				}
				else{
					elementCount.put(B[i], 1);
					count++;
				}
			}
			output=new int[count];
			counter=0;
			arr=elementCount.keySet().toArray();
			for (int i = 0; i < arr.length; i++) {
				if(elementCount.get(arr[i])==1){
					output[counter]=(int) arr[i];
					counter++;
				}
			}
			break;
		}			
		return output;


	}
}
