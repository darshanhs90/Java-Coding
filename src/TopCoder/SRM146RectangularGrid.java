package TopCoder;

/*
 * SRM 146 Div1
 * Link:https://community.topcoder.com/stat?c=problem_statement&pm=1589
 */



public class SRM146RectangularGrid {
	public static void main(String[] args) {
		System.out.println(countRectangles(3, 3));
		System.out.println(countRectangles(5, 2));
		System.out.println(countRectangles(10, 10));
		System.out.println(countRectangles(1, 1));
		System.out.println(countRectangles(592, 964));

	}
	public static long countRectangles(int width, int height){
		int m=Math.min(width, height);
		long noOfSquares=(width*m*height)-((long)(width+height)*m*(m-1)/2)+((long)(m-1)*m*(2*m-1)/6);
		long noOfRectangles=(width*width+width)*(long)(height*height+height)/(long)4;
		return noOfRectangles-noOfSquares;
	}
}
