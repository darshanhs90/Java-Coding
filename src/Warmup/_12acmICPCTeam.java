package Warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.BitSet;

import javax.print.attribute.standard.MediaSize.Other;

public class _12acmICPCTeam {
	public static void main(String[] args) throws  IOException {
		BufferedReader scanner=new BufferedReader(new InputStreamReader(System.in));
		String firstLine=scanner.readLine();
		String flArray[]=firstLine.split(" ");
		int N=Integer.parseInt(flArray[0]);
		int M=Integer.parseInt(flArray[1]);
		ArrayList<BitSet> peopleArray=new ArrayList<BitSet>();
		/*BigInteger bigInteger=new BigInteger("10101010101010101010101010101010111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
		System.out.println(bigInteger);
		*/
		for (int noOfTestCases = 0; noOfTestCases < N; noOfTestCases++) {
			String str=scanner.readLine();
			BitSet bitSet=new BitSet(M+1);
			for (int i = 0; i < M; i++) {
				if(str.charAt(i)=='1')
					bitSet.set(i);
			}
			peopleArray.add(bitSet);
		}
		ArrayList<BitSet> outputArray=new ArrayList<BitSet>();
		//perform or operation
		int noOfComparisons=N*(N-1)/2;
		for (int i = 0; i < N-1; i++) {
			BitSet a=peopleArray.get(i);
			for (int j = i+1; j < N; j++) {
				BitSet b=peopleArray.get(j);
				BitSet op=new BitSet();
				for (int k = 0; k < b.size(); k++) {
					if((a.get(k)|b.get(k))==true)
						op.set(k);
				}
				outputArray.add(op);
			}
		}
		for (int i = 0; i < outputArray.size(); i++) {
			
		}
		ArrayList<BitSet> arrayList=new ArrayList<BitSet>();
		
		
	}
}
