package TopCoder;

import java.util.Arrays;

/*
 * SRM 176 Div2
 * Link:https://community.topcoder.com/stat?c=problem_statement&pm=2251&rd=4685
 */



public class SRM176RGBColor {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(getComplement(new int[]{255,0,0})));
		System.out.println(Arrays.toString(getComplement(new int[]{115,115,143})));
		System.out.println(Arrays.toString(getComplement(new int[]{115,115,144})));
		System.out.println(Arrays.toString(getComplement(new int[]{153,12,55})));
	}
	public static int[] getComplement(int[] rgb){
		int[] rgbcomplement=new int[3];
		int count=0;
		for (int i = 0; i < rgbcomplement.length; i++) {
			rgbcomplement[i]=255-rgb[i];
			if(Math.abs(rgbcomplement[i]-rgb[i])<=32){
				count++;
			}
		}
		if(count==3)
			for (int i = 0; i < rgbcomplement.length; i++) {
				rgbcomplement[i]=rgb[i]-128>=0?rgb[i]-128:rgb[i]+128;
			}
		return rgbcomplement;
	}
}
