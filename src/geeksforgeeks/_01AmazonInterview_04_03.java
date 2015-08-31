package geeksforgeeks;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;





/*
 * http://www.geeksforgeeks.org/amazon-interview-set-3/
 * There are n frames of m data element each. The data element in each frame is arranged in increasing order.
 * You are provided m*n space in which you have to arrange all data in increasing order.
 */
public class _01AmazonInterview_04_03 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		int m=Integer.parseInt(scanner.nextLine());
		int n=Integer.parseInt(scanner.nextLine());
		scanner.close();
		ArrayList<ArrayList<Integer>> nFrames=new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < n; i++) {
			ArrayList<Integer> mElements=new ArrayList<Integer>();
			for (int j = 0; j < m; j++) {
				mElements.add(new Random().nextInt());
			}
			Object[] sortedArray=mElements.toArray();
			 mElements=new ArrayList<Integer>();
			 Arrays.sort(sortedArray);
			 for (int j = 0; j < sortedArray.length; j++) {
				mElements.add((int)sortedArray[j]);
			}
			 nFrames.add(mElements);
		}
		for (int i = 0; i < nFrames.size(); i++) {
			ArrayList<Integer> mElements=nFrames.get(i);
			for (int j = 0; j < mElements.size(); j++) {
				System.out.println(mElements.get(j)+" ");
			}
			System.out.println();
		}
		sortDataHeap();
		sortDataMergeSort(nFrames);
	}

	private static void sortDataMergeSort(ArrayList<ArrayList<Integer>> nFrames) {
			ArrayList<Integer> elementList=new ArrayList<Integer>();
			for (int i = 0; i < nFrames.size(); i++) {
				ArrayList<Integer> elementframeList=nFrames.get(i);
				for (int j = 0; j < elementframeList.size(); j++) {
					elementList.add(elementframeList.get(i));
				}
			}
			Object[] elementArray=elementList.toArray();
			//do merge sort for this data
	}

	private static void sortDataHeap() {
		// TODO Auto-generated method stub
		//add to heap and do a bfs to get the sorted elements
		
	}

}