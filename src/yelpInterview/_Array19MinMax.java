package yelpInterview;

import java.util.Arrays;

public class _Array19MinMax {
	static class minMax{
		int min,max;
	}
	public static void main(String a[]){
		int inputArray[] = {1000, 11, 445, 1, 330, 3000};
		minMax mm=printMinMax(inputArray);
		System.out.println(mm.min);
		System.out.println(mm.max);
	}

	private static minMax printMinMax(int[] inputArray) {
		if(inputArray.length==1)
		{
			minMax mm=new minMax();
			mm.min=inputArray[0];
			mm.max=inputArray[0];
			return mm;
		}
		else if(inputArray.length==2)
		{
			minMax mm=new minMax();
			if(inputArray[0]>inputArray[1])
			{
				mm.min=inputArray[1];
				mm.max=inputArray[0];
			}
			else{
				mm.min=inputArray[0];
				mm.max=inputArray[1];
			}
			return mm;
		}
		else{
			minMax mm1=printMinMax(Arrays.copyOf(inputArray, inputArray.length/2));
			minMax mm2=printMinMax(Arrays.copyOfRange(inputArray, inputArray.length/2,inputArray.length));

			minMax output=new minMax();
			if(mm1.min<mm2.min)
				output.min=mm1.min;
			else
				output.min=mm2.min;
			if(mm1.max>mm2.max)
				output.max=mm1.max;
			else
				output.max=mm2.max;
			return output;
		}
	}


}