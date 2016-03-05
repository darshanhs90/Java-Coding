package TopCoder.Div1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/*
 * SRM 144 Div1
 * Link:https://community.topcoder.com/stat?c=problem_statement&pm=1659&rd=4515
 */



public class Lottery {
/*	public static void main(String[] args) {
		System.out.println(Arrays.toString(sortByOdds(new String[]{"INDIGO: 93 8 T F",
			 "ORANGE: 29 8 F T",
			 "VIOLET: 76 6 F F",
			 "BLUE: 100 8 T T",
			 "RED: 99 8 T T",
			 "GREEN: 78 6 F T",
			 "YELLOW: 75 6 F F"})));
	}*/
	public static String[] sortByOdds(String[] rules){
		String[] outputArray=new String[rules.length];
		TreeMap<Double,ArrayList<String>> scoreMap=new TreeMap<>();
		for (int i = 0; i < outputArray.length; i++) {
			String inputLine=rules[i];
			String splitString[]=inputLine.split(":");
			String name=splitString[0];
			String valueArray[]=splitString[1].trim().split(" ");
			int choices=Integer.parseInt(valueArray[0]);
			int blanks=Integer.parseInt(valueArray[1]);
			boolean sorted=(valueArray[2].contentEquals("F")?false:true);
			boolean unique=(valueArray[3].contentEquals("F")?false:true);	
			double value=0;
			if(!sorted && !unique){
				value = Math.pow(choices,blanks);
			}else if(!sorted && unique){
				value=permutation(choices,blanks);
			}else if(sorted && unique){
				value=binomial(choices,choices-blanks);
			}else{
				value=binomial(choices - 1 + blanks, choices - 1);
			}
			if(scoreMap.containsKey(value)){
				ArrayList<String> list=scoreMap.get(value);
				list.add(name);
				scoreMap.put(value,list);
			}
			else{
				ArrayList<String> list=new ArrayList<>();
				list.add(name);
				scoreMap.put(value,list);
			}
		}
		TreeMap<Double,ArrayList<String>> map = scoreMap;
		int counter=0;
		for (Map.Entry<Double,ArrayList<String>> entry : map.entrySet())
		{
			Double key=entry.getKey();
			ArrayList<String> values=entry.getValue();
			Object[] valueArray=(Object[]) values.toArray();
			Arrays.sort(valueArray);
			for (int i = 0; i < valueArray.length; i++) {
				outputArray[counter]=(String) valueArray[i];
				counter++;
			}
		}
		return outputArray;
	}
	private static Double binomial(int n, int k) {
		if (k > n - k) {
			k = n - k;
		}
		Double result = (double) 1;
		for (int i = 0; i < k; i++) {
			result = result*(n - i)/(i + 1);
		}
		return result;
	}
	private static double permutation(int choices, int blanks) {
		blanks=choices-blanks;
		double output=1;
		for(int i=1;i<=choices;i++){
			output*=i;
		}
		for(int i=1;i<=blanks;i++){
			output/=i;
		}
		return output;
	}	
}
