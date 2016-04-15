package TopCoder;

import java.util.Arrays;

/*
 * SRM 169 Div2
 * Link:https://community.topcoder.com/stat?c=problem_statement&pm=1888&rd=4650
 */



public class SRM169Swimmers {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(getSwimTimes(new int[]{ 300, 300, 300 }, new int[]{ 1, 2, 3 },2)));
		System.out.println(Arrays.toString(getSwimTimes(new int[]{ 500, 500 }, new int[]{ 4, 5 },2)));
		System.out.println(Arrays.toString(getSwimTimes(new int[]{ 0, 0 }, new int[]{ 1, 2 },1)));
		System.out.println(Arrays.toString(getSwimTimes(new int[]{ 0, 1 }, new int[]{ 0, 0 },0 )));
		System.out.println(Arrays.toString(getSwimTimes(new int[]{ 7507, 7517, 7523, 7529, 7537, 7541, 7547, 7549, 7559, 7561, 7573, 7577, 7583,
				7589, 7591, 7603, 7607, 7621, 7639, 7643, 7649, 7669, 7673, 7681, 7687, 7691,
				7699, 7703, 7717, 7723, 7727, 7741, 7753, 7757, 7759, 7789, 7793, 7817, 7823,
				7829, 7841, 7853, 7867, 7873, 7877, 7879, 7883, 7901, 7907, 7919 }, new int[]{ 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
						73, 79, 83, 89, 97, 99, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30,
						32, 34, 36, 38, 40, 42, 44, 46, 48, 51 },6)));
	}
	public static int[] getSwimTimes(int[] distances, int[] speeds, int current){
		int outputArr[]=new int[speeds.length];
		for (int i = 0; i < outputArr.length; i++) {
			if((speeds[i]+current<0 || speeds[i]-current<=0) && distances[i]!=0)
			{
				outputArr[i]=-1;
				continue;
			}
			if(distances[i]==0 || speeds[i]+current==0 || speeds[i]-current==0)
			{
				outputArr[i]=0;
				continue;
			}
			int forwardSpeed=speeds[i]+current;
			int backwardSpeed=speeds[i]-current;
			double forwardTime=distances[i]/(double)forwardSpeed;
			double backwardTime=distances[i]/(double)backwardSpeed;
			outputArr[i]=(int)(forwardTime+backwardTime);
		}
		return outputArr;
	}
}
