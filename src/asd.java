import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class asd {
	/*	public static void main(String[] args) {

	}*/
	//1 7 10 6
	static int minValue=Integer.MIN_VALUE;
	static void permute(List<Integer> arr, int k,int min){
		for(int i = k; i < arr.size(); i++){
			Collections.swap(arr, i, k);
			permute(arr, k+1,min);
			Collections.swap(arr, k, i);
		}
		if (k == arr.size() -1){
			int sum=0;
			for (int i = 0; i < arr.size()-1; i++) {
				String number1=arr.get(i)+"";
				String number2=arr.get(i+1)+"";
				for (int j = 0; j <min; j++) {
					sum+=(int)Math.abs(Integer.parseInt(number1.charAt(number1.length()-1-j)+"")-Integer.parseInt(number2.charAt(number2.length()-1-j)+""));
				}
			}
			System.out.println(Arrays.toString(arr.toArray())+"<-sum->"+sum);
			minValue=Math.max(sum, minValue);
		}
	}
	public static void main(String[] args){
		Scanner scanner =new Scanner(System.in);
		int n=scanner.nextInt();
		List<Integer> aList = null;
		for (int i = 0; i < n; i++) {
			aList=new ArrayList<>();
			minValue=Integer.MIN_VALUE;
			int x=scanner.nextInt();
			int min =Integer.MAX_VALUE;
			for (int j = 0; j < x; j++) {
				aList.add(scanner.nextInt());
				min=Math.min(min, (aList.get(j)+"").length());
			}
			asd.permute(aList, 0,min);
		}
		System.out.println(minValue);

	}

}
