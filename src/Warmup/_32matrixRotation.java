package Warmup;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class _32matrixRotation {
	public static void main(String[] args) throws Exception {
		BufferedReader scanner=new BufferedReader(new InputStreamReader(System.in));
		String input=scanner.readLine();
		String inputArray[]=input.split(" ");
		int M=Integer.parseInt(inputArray[0]);
		int N=Integer.parseInt(inputArray[1]);
		long R=Long.parseLong(inputArray[2]);
		Long mainArray[][]=new Long[M][N];
		Long finalArray[][]=new Long[M][N];
		for (int i = 0; i < M; i++) {
			String rowValue=scanner.readLine();
			String rowArray[]=rowValue.split(" ");
			for (int j = 0; j < N; j++) {
				mainArray[i][j]=Long.parseLong(rowArray[j]);
			}
		}
		int leftIndex=0;
		int rightIndex=N;
		int topIndex=0;
		int bottomIndex=M;
		//M/2 is the number of inner matrices
		for (int i = 0; i < M/2; i++) {//number of outer regions
			leftIndex=i;
			ArrayList<Long> boxList=new ArrayList<Long>();
			Stack<Long> stack=new Stack<Long>();
			for (int j = bottomIndex-1; j >=topIndex; j--) {
				if(j==topIndex||j==bottomIndex-1){
					for (int j2 = leftIndex; j2 < rightIndex; j2++) {
						if(j==bottomIndex-1)
							boxList.add(mainArray[j][j2]);
						else
							stack.push(mainArray[j][j2]);
					}
				}
				else{
					stack.push(mainArray[j][leftIndex]);
					boxList.add(mainArray[j][rightIndex-1]);
				}
			}
			int stackSize=stack.size();
			while(!stack.isEmpty()){
				boxList.add(stack.pop());
			}
			long rotations=R%boxList.size();
			ArrayList<Long> modifiedBoxList=new ArrayList<Long>();
			int counter=-1;
			Boolean flag=false;
			//System.out.println("**********");
			for (int j = 0; j < boxList.size(); j++) {
				long position=(j-rotations);
				if(position<0)
				{
					position=boxList.size()+position;
				}
				//System.out.println(boxList.get(position));
				modifiedBoxList.add(boxList.get((int)position));	
			}
			//System.out.println("**********");
			counter=0;
			int lastCounter=modifiedBoxList.size()-1;
			for (int j = bottomIndex-1; j >=topIndex; j--) {
				if(j==topIndex||j==bottomIndex-1){
					for (int j2 = leftIndex; j2 < rightIndex; j2++) {
						//get arraylists
						if(j==bottomIndex-1){//this is working fine
							finalArray[j][j2]=(modifiedBoxList.get(counter));
							counter++;
						}
						else{//this is for first row
							finalArray[j][j2]=(modifiedBoxList.get(lastCounter));
							lastCounter--;
						}
					}
				}
				else{
					finalArray[j][leftIndex]=(modifiedBoxList.get(lastCounter));
					lastCounter--;
					finalArray[j][rightIndex-1]=(modifiedBoxList.get(counter));
					counter++;
				}
			}
			topIndex++;
			bottomIndex--;
			rightIndex--;
			//System.exit(0);
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(finalArray[i][j]+" ");
			}
			System.out.println();
		}
	}
	
}
