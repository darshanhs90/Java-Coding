package Warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.BitSet;

public class _12acmICPCTeam {
	public static void main(String[] args) throws  IOException {
		BufferedReader scanner=new BufferedReader(new InputStreamReader(System.in));
		String firstLine=scanner.readLine();
		String flArray[]=firstLine.split(" ");
		int N=Integer.parseInt(flArray[0]);
		int M=Integer.parseInt(flArray[1]);
		ArrayList<BitSet> peopleArray=new ArrayList<BitSet>();
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
		int max=0,counter=0;
		
		for (int i = 0; i < outputArray.size(); i++) {
			BitSet opBitset=outputArray.get(i);
			if(opBitset.cardinality()>max)
			{
				max=opBitset.cardinality();
				counter=1;
			}
			else if(opBitset.cardinality()==max)
			{
				counter++;
			}
		}
		System.out.println(max);
		System.out.println(counter);
		
	}
}
