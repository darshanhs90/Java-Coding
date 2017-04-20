package hackerRank.WeekOfCode31;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/contests/w31/challenges/zero-one-game
 */
public class _05CollidingCircles {
	static ArrayList<Integer> indexSum;
	static HashSet<String> set=new HashSet<>();
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] r = new int[n];
		int sum=0;
		for(int r_i=0; r_i < n; r_i++){
			r[r_i] = in.nextInt();
			sum+=r[r_i];
		}
		// Write Your Code Here
		DecimalFormat df = new DecimalFormat("#.##########");
		df.setRoundingMode(RoundingMode.FLOOR);
		if(k>=n-1)
		{
			System.out.println(df.format(Math.PI*sum*sum));
		}
		else{
			double output=0;
			int totalSize=0;
			for (int i1 = 1; i1 <=k; i1++) {

				indexSum=new ArrayList<>();
				ArrayList<ArrayList<Integer>> combinedList=doNcK(n,i1+1,0,r);
				System.out.println(indexSum);
				System.out.println(combinedList);
				output=0;
				totalSize=0;
				for (int i = 0; i < indexSum.size(); i++) {
					ArrayList<Integer> list=combinedList.get(i);
					double tempSum=0;
					for (int j = 0; j < r.length; j++) {
						if(!list.contains(j))
						{
							tempSum+=r[j]*r[j];
						}
					}
					if(i1==1){
						System.out.println(tempSum);
					}
					else{
						System.out.println(tempSum*(list.size()));
					}
					output+=(Math.PI*tempSum*(i1==1?1:list.size()));
					output+=(Math.PI*indexSum.get(i)*(i1==1?1:list.size()));
				}
				totalSize+=i1==1?indexSum.size():indexSum.size()*combinedList.get(0).size();
				System.out.println("output ->"+output+"<-totalSize->"+totalSize);
				System.out.println("****************");
			}
			System.out.println(totalSize);
			System.out.println(output);
			System.out.println(df.format(output/totalSize));

		}
	}
	public static ArrayList<ArrayList<Integer>> doNcK(int n, int k,int sum,int[] arr) {
		ArrayList<ArrayList<Integer>> allIndexes=new ArrayList<>();
		ArrayList<Integer> indexes=new ArrayList<>();
		combineUtil(n, k, 1,0,arr,0,allIndexes,indexes); 
		return allIndexes;
	}

	private static void combineUtil(int n, int k, int startIndex,int sum,int[] arr,int size,ArrayList<ArrayList<Integer>> outputList,ArrayList<Integer> list) {
		if (size == k) {
			indexSum.add(sum*sum);
			outputList.add(new ArrayList<>(list));
			return;
		}

		for (int i = startIndex; i <= n; i++) {
			size++;
			sum+=arr[i-1];
			list.add(i-1);
			combineUtil(n, k, i + 1,sum,arr,size,outputList,list);
			sum-=arr[i-1];
			list.remove(list.size()-1);
			size--;
		}
	}
}

