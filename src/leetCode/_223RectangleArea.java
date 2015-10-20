package leetCode;

/*
 * Link : https://leetcode.com/problems/rectangle-area/
 */

public class _223RectangleArea {
	public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		if(C<E||G<A )
	        return (G-E)*(H-F) + (C-A)*(D-B);
	 
	    if(D<F || H<B)
	        return (G-E)*(H-F) + (C-A)*(D-B);
	 
	    int right = Math.min(C,G);
	    int left = Math.max(A,E);
	    int top = Math.min(H,D);
	    int bottom = Math.max(F,B);
	 
	    return (G-E)*(H-F) + (C-A)*(D-B) - (right-left)*(top-bottom);
	}

	public static void main(String[] args) {
		System.out.println(computeArea(-3, 0,3, 4, 0, -1, 9, 2));
	}
}