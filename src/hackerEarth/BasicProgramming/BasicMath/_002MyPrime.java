package hackerEarth.BasicProgramming.BasicMath;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
 * Link:https://www.hackerearth.com/problem/algorithm/my-prime/
 */
public class _002MyPrime {
	public static void main(String args[] ) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int N = Integer.parseInt(line);
		int inputArray[]=new int[N];
		String iArr[]=br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			inputArray[i]=Integer.parseInt(iArr[i]);
		}

		for (int i = 0; i <N; i++) {
			boolean divided=false;
			for(int j=0;j<N;j++)
			{
				if(j!=i && inputArray[i]%inputArray[j]==0)
					divided=true;
			}
			if(!divided)
				System.out.print(inputArray[i]+" ");
		}

	}
}
