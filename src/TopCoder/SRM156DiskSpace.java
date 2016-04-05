package TopCoder;

import java.util.Arrays;

/*
 * SRM 156 Div2
 * Link:https://community.topcoder.com/stat?c=problem_statement&pm=1777&rd=4585
 */



public class SRM156DiskSpace {
	public static void main(String[] args) {
		System.out.println(minDrives(new int[]{300,525,110}, new int[]{350,600,115}));
		System.out.println(minDrives(new int[]{1,200,200,199,200,200}, new int[]{1000,200,200,200,200,200}));
		System.out.println(minDrives(new int[]{750,800,850,900,950}, new int[]{800,850,900,950,1000}));
		System.out.println(minDrives(new int[]{49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,
				49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49},
				new int[]{50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,
						50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50}));
		System.out.println(minDrives(new int[]{331,242,384,366,428,114,145,89,381,170,329,190,482,246,2,38,220,290,402,385}, 
				new int[]{992,509,997,946,976,873,771,565,693,714,755,878,897,789,969,727,765,521,961,906}));
	}
	public static int minDrives(int[] used, int[] total){
		int count=0;
		int totalUsedSpace=0;
		for (int i = 0; i < used.length; i++) {
			totalUsedSpace+=used[i];
		}
		Arrays.sort(total);
		for (int i = total.length-1; i >=0; i--) {
			if(totalUsedSpace<=0)
				break;
			totalUsedSpace=-total[i]+totalUsedSpace;
			count++;
		}
		return count;
	}
}
