package TopCoder;

import java.util.Arrays;

/*
 * SRM 176 Div2
 * Link:https://community.topcoder.com/stat?c=problem_statement&pm=2251&rd=4685
 */



public class SRM176Matching {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(findMatch(new String[]{"DIAMOND","BLUE","SOLID","ONE"},new String[]{"DIAMOND","GREEN","SOLID","TWO"})));
		System.out.println(Arrays.toString(findMatch(new String[]{"CIRCLE","GREEN","EMPTY","TWO"},new String[]{"DIAMOND","BLUE","STRIPED","ONE"})));
		System.out.println(Arrays.toString(findMatch(new String[]{"DIAMOND","RED","SOLID","ONE"},new String[]{"SQUIGGLE","BLUE","SOLID","TWO"})));
		System.out.println(Arrays.toString(findMatch(new String[]{"SQUIGGLE","RED","STRIPED","ONE"},new String[]{"SQUIGGLE","RED","STRIPED","ONE"})));

	}
	public static String[] findMatch(String[] first, String[] second){
		String outputArr[]=new String[4];
		for (int i = 0; i < outputArr.length; i++) {
			if(first[i].contentEquals(second[i]))
				outputArr[i]=first[i];
			else{
				outputArr[i]=findMatching(first[i],second[i],i);
			}
		}
		return outputArr;
	}
	private static String findMatching(String first, String second, int i) {
		switch(i){
		case 0:String output="DIAMONDCIRCLESQUIGGLE".replace(first, "").replace(second, "");
		return output;
		case 1: output="BLUEGREENRED".replace(first, "").replace(second, "");
		return output;
		case 2:output="SOLIDSTRIPEDEMPTY".replace(first, "").replace(second, "");
		return output;
		case 3:output="ONETWOTHREE".replace(first, "").replace(second, "");
		return output;
		default:break;
		}
		return "";
	}
}
