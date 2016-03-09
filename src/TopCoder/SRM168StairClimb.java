package TopCoder;

/*
 * SRM 149 Div2
 * Link:https://community.topcoder.com/stat?c=problem_statement&pm=1331&rd=4550
 */



public class SRM168StairClimb {
	public static int stridesTaken(int[] flights, int stairsPerStride)
	{
		int count=0;
		for(int i=0;i<flights.length;i++){
			if(flights[i]%stairsPerStride==0){
				count+=flights[i]/stairsPerStride;
			}
			else{
				count+=flights[i]/stairsPerStride;
				count++;
			}
			count+=2;
		}
		return count-2;
	}

	public static void main(String[] args) {
		System.out.println(stridesTaken(new int[]{15},2));
		System.out.println(stridesTaken(new int[]{15,15},2));
		System.out.println(stridesTaken(new int[]{5,11,9,13,8,30,14},3));
	}
}
