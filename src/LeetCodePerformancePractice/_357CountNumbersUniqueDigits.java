package LeetCodePerformancePractice;

public class _357CountNumbersUniqueDigits {
	public static void main(String[] args) {
		System.out.println(countNumbersWithUniqueDigits(100));
	}
	public static int countNumbersWithUniqueDigits(int n) {
		int[] arr=new int[n+1];
		arr[0]=1;
		for(int i=1;i<=n;i++)
		{
			arr[i]=9;
			for(int j=9;j>=11-i;j--){
				arr[i]*=j;
			}
		}
		int result=0;
		for(int i=0;i<arr.length;i++)
			result+=arr[i];
		return result;
	}
}
