package Feb2021Leetcode;

public class _0780ReachingPoints {
	public static void main(String[] args) {
		System.out.println(reachingPoints(1, 1, 3, 5));
	}

	public static boolean reachingPoints(int sx, int sy, int tx, int ty) {
		if(tx<sx || ty<sy)
			return false;
		if(sx == tx && sy == ty)
			return true;
		
		return reachingPoints(sx,sy,tx-ty,ty) || reachingPoints(sx,sy,tx,ty-tx) ;
	}

}
