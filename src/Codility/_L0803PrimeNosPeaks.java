package Codility;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Author : Haridarshan H.S.
 * Link : https://codility.com/programmers/task/peaks
 */

public class _L0803PrimeNosPeaks {
	public static void main(String[] args) {
		System.out.println(solution(new int[]{1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2}));
	}
	public static int solution(int[] A){
		//find the number of peaks
		ArrayList<Integer> peakIndexList=new ArrayList<>();
		for (int i = 1; i < A.length-1; i++) {
			if(A[i]>A[i-1] && A[i]>A[i+1])
			{
				peakIndexList.add(i);
			}
		}
		System.out.println(Arrays.toString(peakIndexList.toArray()));
		int arraySize=A.length;
		for (int size = 1; size <=A.length; size++) {
			//check if the blocks of equal length can be divided or not
			if(arraySize%size!=0)
				continue;
			//blocks can be divided
			int noOfBlocks=arraySize/size;
			int elementCount=0;
			//now check if each of the block contains atleast one peak element or not
			for (int i = 0; i < peakIndexList.size(); i++) {
				if(peakIndexList.get(i)/size>elementCount)
					break;
				if(peakIndexList.get(i)/size==elementCount)
					elementCount++;
			}
			if(elementCount==noOfBlocks)
				return noOfBlocks;	
		}
		return 0;
	}
}