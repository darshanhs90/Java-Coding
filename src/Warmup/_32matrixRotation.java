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
			Stack<Integer> stack=new Stack<Integer>();
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
		int rotations=R%boxList.size();
		ArrayList<Integer> modifiedBoxList=new ArrayList<Integer>();
		int counter=-1;
		Boolean flag=false;
		System.out.println("**********");
		for (int j = 0; j < boxList.size(); j++) {
			int position=(j-rotations);
			if(position<0 )
			{
				position=boxList.size()+position;
			}
			System.out.println(boxList.get(position));
			modifiedBoxList.add(boxList.get(position));	
		}
		System.out.println("**********");
		counter=0;
		for (int j = bottomIndex-1; j >=topIndex; j--) {
			if(j==topIndex||j==bottomIndex-1){
				for (int j2 = leftIndex; j2 < rightIndex; j2++) {
					//get arraylists
					if(j==bottomIndex-1)
						finalArray[j][j2]=(modifiedBoxList.get(counter));
					else
						finalArray[j][j2]=(modifiedBoxList.get((counter+stackSize)%modifiedBoxList.size()));
					counter++;
				}
			}
			else{
				finalArray[j][leftIndex]=(modifiedBoxList.get((counter+stackSize)%modifiedBoxList.size()));
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
