package TopCoder;

import java.util.ArrayList;

/*
 * SRM 170 Div2
 * Link:https://community.topcoder.com/stat?c=problem_statement&pm=1930&rd=4655
 */



public class SRM170RecurrenceRelation {
	public static void main(String[] args) {
		System.out.println(moduloTen(new int[]{2,1}, new int[]{9,7},6));
		System.out.println(moduloTen(new int[]{1,1}, new int[]{0,1},9));
		System.out.println(moduloTen(new int[]{2}, new int[]{1},20 ));
		System.out.println(moduloTen(new int[]{2}, new int[]{1},64));
		System.out.println(moduloTen(new int[]{25,143}, new int[]{0,0},100000));
		System.out.println(moduloTen(new int[]{9,8,7,6,5,4,3,2,1,0}, new int[]{1,2,3,4,5,6,7,8,9,10},654));
		System.out.println(moduloTen(new int[]{901,492,100}, new int[]{-6,-15,-39},0));
	}
	public static int moduloTen(int[] coefficients, int[] initial, int N){
		ArrayList<Integer> valuesList=new ArrayList<>();
		for (int i = 0; i < initial.length; i++) {
			valuesList.add(initial[i]);
		}
		for (int i = 0; i <=N-initial.length; i++) {
			int valuesCounter=valuesList.size()-1;
			long value=0;
			for (int j = 0; j < coefficients.length; j++) {
				value+=(valuesList.get(valuesCounter)*coefficients[coefficients.length-1-j]);
				valuesCounter--;
			}
			valuesList.add((int)value);
		}
		return valuesList.get(valuesList.size()-1)%10>0?valuesList.get(valuesList.size()-1)%10:((10 - (valuesList.get(valuesList.size()-1) % 10)) % 10);
	}
}
