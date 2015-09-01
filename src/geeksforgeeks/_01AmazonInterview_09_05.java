package geeksforgeeks;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;


/*
 * http://www.geeksforgeeks.org/amazon-interview-set-8-2/
 * Given a point P and other N points in two dimensional space, 
 * find K points out of the N points which are nearer to P.
 */;
 public class _01AmazonInterview_09_05 {
	 public static void main(String[] args) {
		 Scanner scanner=new  Scanner(new InputStreamReader(System.in));
		 String pointP=scanner.nextLine();
		 Integer N=Integer.parseInt(scanner.nextLine());
		 scanner.close();
		 int[][] inputArray=new int[N][N];
		 int K=Integer.parseInt(scanner.nextLine());
		 int elementX=10,elementY=10,inputX=20,inputY=20;
		 double outputArray[]=new double[N];
		 for(int i=0;i<N;i++){
			 outputArray[i]=Math.sqrt(Math.pow((elementX-inputX),2)+Math.pow((elementY-inputY),2));
		 }
		 Arrays.sort(outputArray);
		 for (int i = 0; i < K; i++) {
			 System.out.print(i+",");
		 }
		 System.out.println();



	 }


 }