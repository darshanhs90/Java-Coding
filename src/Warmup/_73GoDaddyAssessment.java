package Warmup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class _73GoDaddyAssessment {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(sortIntersect(new int[]{7000,7000,6900,1234},new int[]{7000,7000,6900})));
	}



	static int[] sortIntersect(int[] f,int[] m){
		HashMap<Integer, Integer> elementCount=new HashMap<>();
		for (int i = 0; i < f.length; i++) {
			if(elementCount.containsKey(f[i])){
				elementCount.put(f[i], elementCount.get(f[i])+1);
			}
			else{
				elementCount.put(f[i], 1);
			}
		}
		ArrayList<Integer> aList=new ArrayList<>();
		for (int i = 0; i < m.length; i++) {
			if(elementCount.containsKey(m[i]) && elementCount.get(m[i])>0){
				elementCount.put(m[i], elementCount.get(m[i])-1);
				aList.add(m[i]);
			}
		}
		Object[] output=(aList.toArray());
		Arrays.sort(output,Collections.reverseOrder());
		int op[]=new int[output.length];
		for (int i = 0; i < output.length; i++) {
			op[i]=(int) output[i];
		}
		return op;
	}
}
