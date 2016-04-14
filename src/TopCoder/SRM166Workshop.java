package TopCoder;

import java.util.Arrays;

/*
 * SRM 166 Div2
 * Link:https://community.topcoder.com/stat?c=problem_statement&pm=1880&rd=4635
 */



public class SRM166Workshop {

	public static void main(String[] args) {
		System.out.println(pictureFrames(new int[]{1,2,3,4,5}));
		System.out.println(pictureFrames(new int[]{8,5,3}));
		System.out.println(pictureFrames(new int[]{4,23,76,22,87,3,1,99}));
		System.out.println(pictureFrames(new int[]{10000,9999,9998,9997,9996,1,2,3,4,5}));
		System.out.println(pictureFrames(new int[]{100}));
		
		
	}

	public static int pictureFrames(int[] pieces){
		int count=0;
		int k=0;
		Arrays.sort(pieces);
		for (int i = 0; i < pieces.length-2; i++) {
			k=i+2;
			for (int j = i+1; j < pieces.length; j++) {

				while(k<pieces.length && pieces[i]+pieces[j]>pieces[k])
					k++;
				count += k - j - 1;
			}
		}
		return count;
	}
}
