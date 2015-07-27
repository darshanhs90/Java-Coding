package Warmup;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class _32matrixRotation_Extra {
	public static void main(String[] args) throws Exception {
		BufferedReader scanner=new BufferedReader(new InputStreamReader(System.in));
		String input=scanner.readLine();
		String inputArray[]=input.split(" ");
		int M=Integer.parseInt(inputArray[0]);
		int N=Integer.parseInt(inputArray[1]);
		int R=Integer.parseInt(inputArray[2]);
		int mainArray[][]=new int[M][N];
		int finalArray[][]=new int[M][N];
		for (int i = 0; i < M; i++) {
			String rowValue=scanner.readLine();
			String rowArray[]=rowValue.split(" ");
			for (int j = 0; j < N; j++) {
				mainArray[i][j]=Integer.parseInt(rowArray[j]);
			}
		}
		int leftIndex=0;
		int rightIndex=N;
		int topIndex=0;
		int bottomIndex=M;
		//M/2 is the number of inner matrices
		for (int i = 0; i < M/2; i++) {//number of outer regions
			leftIndex=i;
			ArrayList<Integer> boxList=new ArrayList<Integer>();
			for (int j = topIndex; j < bottomIndex; j++) {
				if(j==topIndex||j==bottomIndex-1){
					for (int j2 = leftIndex; j2 < rightIndex; j2++) {
						boxList.add(mainArray[j][j2]);

					}
				}
				else{
					boxList.add(mainArray[j][leftIndex]);
					boxList.add(mainArray[j][rightIndex-1]);
				}
			}
			int rotations=R%boxList.size();
			ArrayList<Integer> modifiedBoxList=new ArrayList<Integer>();
			int counter=-1;
			Boolean flag=false;
			for (int j = 0; j < boxList.size(); j++) {
				int position=j+rotations;
				if(position>boxList.size()-1 || flag==true)
				{
					position=counter+1;
					counter++;
					flag=true;
				}
			modifiedBoxList.add(boxList.get(position));	
			}
			counter=0;
			for (int j = topIndex; j < bottomIndex; j++) {
				if(j==topIndex||j==bottomIndex-1){
					for (int j2 = leftIndex; j2 < rightIndex; j2++) {
						//get arraylists

						finalArray[j][j2]=(modifiedBoxList.get(counter));
						counter++;
					}
				}
				else{
					finalArray[j][leftIndex]=(modifiedBoxList.get(counter));
					counter++;
					finalArray[j][rightIndex-1]=(modifiedBoxList.get(counter));
					counter++;
				}
			}
			topIndex++;
			bottomIndex--;
			rightIndex--;
		}
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(finalArray[i][j]+" ");
			}
			System.out.println();
		}
	}
}
