package eBayPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _228SummaryRanges{
	public static void main(String[] args) {
		List<String> outputList=summaryRanges(new int[]{-1000000000,-9999,0,1,2,10,100,1000,999999999,1000000000});
		System.out.println(Arrays.toString(outputList.toArray()));
		outputList=summaryRanges(new int[]{0,1,2,4,5,7});
		System.out.println(Arrays.toString(outputList.toArray()));		
	}

	private static List<String> summaryRanges(int[] arr) {
		List<String> list=new ArrayList<>();
		if(arr==null||arr.length==0)
			return list;
		int startValue=arr[0],endValue=arr[0];
		for (int i = 1; i < arr.length; i++) {
			if(arr[i]==endValue+1)
			{
				endValue=arr[i];
			}
			else{
				if(startValue==endValue)
					list.add(startValue+"");
				else{
					list.add(startValue+"->"+endValue);
				}
				startValue=arr[i];
				endValue=arr[i];
			}
		}
		if(startValue==endValue)
			list.add(startValue+"");
		else{
			list.add(startValue+"->"+endValue);
		}
		return list;
	}

}

