package TopCoder;

import java.util.HashMap;

/*
 * SRM 186 Div2
 * Link:
 */



public class SRM686SegmentsAndPoints {
	public static void main(String[] args) {
		System.out.println(isPossible(new int[]{1, 2},new int[]{0,0},new int[]{1,3}));
		System.out.println(isPossible(new int[]{0},new int[]{2},new int[]{3}));
		System.out.println(isPossible(new int[]{0, 1, 2},new int[]{0, 0, 1},new int[]{1, 2, 1}));
		System.out.println(isPossible(new int[]{0, 1},new int[]{-1, 0},new int[]{0, 0}));
		System.out.println(isPossible(new int[]{434, 63, 241, 418, -380, -46, 397, -205, -262, -282, 260, -106, -389, -286, 422, -75, 127, 382, 52, -383},
				new int[]{-447, -226, -411, 287, -83, -228, -390, 358, 422, 395, -461, -112, 49, 75, -160, -152, 372, -447, -337, -362},
				new int[]{-102, 348, -70, 466, 168, -61, -389, 469, 433, 471, -75, -41, 52, 236, 299, -48, 383, -353, 346, -217}));

	}
	public static String isPossible(int[] p, int[] l, int[] r){
		HashMap<Integer, Boolean> pointMap=new HashMap<>();
		for (int i = 0; i < p.length; i++) {
			pointMap.put(p[i], false);
		}
		for (int i = 0; i < l.length; i++) {
			for (int j =l[i] ; j <=r[i]; j++) {
				if(pointMap.containsKey(j))
					pointMap.put(j, true);
			}
		}
		int count=0;
		for (int i = 0; i < p.length; i++) {
			if(pointMap.get(p[i])==true)
				count++;
		}
		return count==p.length?"Possible":"Impossible";
	}
}
