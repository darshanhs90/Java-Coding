package LeetCodePerformancePractice;

import java.util.ArrayList;
import java.util.List;

public class _089GrayCode {
	public static void main(String[] args) {
		System.out.println(grayCode(2));
	}
	public static List<Integer> grayCode(int n) {
		List<Integer> outputList=new ArrayList<>();
		List<String> stringList=new ArrayList<>();
		if(n==0){
			outputList.add(0);
			return outputList;
		}
		outputList.add(0);
		outputList.add(1);
		if(n==1)
			return outputList;
		stringList.add("0");
		stringList.add("1");
		for (int i = 2	; i <=n; i++) {
			List<String> stringListNew=new ArrayList<>();
			outputList=new ArrayList<>();
			for (int j = 0; j < stringList.size(); j++) {
				if(j%2==0)
				{
					stringListNew.add(stringList.get(j)+"0");
					outputList.add(Integer.parseInt(stringList.get(j)+"0", 2));
					stringListNew.add(stringList.get(j)+"1");
					outputList.add(Integer.parseInt(stringList.get(j)+"1", 2));					
				}
				else{
					stringListNew.add(stringList.get(j)+"1");
					outputList.add(Integer.parseInt(stringList.get(j)+"1", 2));
					stringListNew.add(stringList.get(j)+"0");
					outputList.add(Integer.parseInt(stringList.get(j)+"0", 2));
				}
			}
			stringList=stringListNew;
		}
		return outputList;



	}

}
