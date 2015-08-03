package Warmup;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _43squirrelAndNut {
	static int noOfNuts;
	static int totalSteps;
	public static void main(String[] args) throws Exception {

		BufferedReader scanner = new BufferedReader(new InputStreamReader(
				System.in));
		String squirrelPosn=scanner.readLine();

		String mat[][]=new String[2][3];
		String str[]=squirrelPosn.split(" ");
		int squirrelX=Integer.parseInt(str[0]);
		int squirrelY=Integer.parseInt(str[1]);
		mat[Integer.parseInt(str[0])][Integer.parseInt(str[1])]="S";
		String treePosn=scanner.readLine();
		str=treePosn.split(" ");
		mat[Integer.parseInt(str[0])][Integer.parseInt(str[1])]="T";
		int treeX=Integer.parseInt(str[0]);
		int treeY=Integer.parseInt(str[1]);
		totalSteps=0;
		noOfNuts=Integer.parseInt(scanner.readLine());
		for (int i = 0; i < noOfNuts; i++) {
			String nutPosn=scanner.readLine();
			str=nutPosn.split(" ");
			mat[Integer.parseInt(str[0])][Integer.parseInt(str[1])]="N";
		}
		
		//find distance to nuts
		//get the minimum distance from squirrel to nut
		//get the distance from nut to tree
		
		//replace that nut with B
		//add the steps to mainSteps
		while(noOfNuts!=0){
			totalSteps+=getNutWithMindistance();
			totalSteps+=getTreeDistance();
			
			
		}
		System.out.println(totalSteps);
		//		for (int i = 0; i < mat.length; i++) {
		//			for (int j = 0; j < mat[0].length; j++) {
		//				if(mat[i][j]!=null)
		//					System.out.println(mat[i][j]);
		//				else
		//					System.out.println("B");
		//			}
		//		}


	}
	public static int getNutWithMindistance(){

		noOfNuts--;
		return 0;
	}
	public static int getTreeDistance(){
		
		
		return 0;
	}
}
