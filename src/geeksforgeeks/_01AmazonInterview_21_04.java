package geeksforgeeks;





/*
 * http://www.geeksforgeeks.org/amazon-interview-set-21/
 * A robot is there in 2D space, which can move to its left direction.
 * You are given with an array which are moves of robot, which starts from origin(0,0).
 * Find the rectangle covered by it.
 * I/P: { 2,3,4,5,6,1,3,5,5} starts at (0,0)
 * O/P: rectangle points: ( -4,4 ) to (4,-2)
 */;
 public class _01AmazonInterview_21_04 {
	 public static void main(String[] args) {
		 int[] path={2,3,4,5,6,1,3,5,5};
		 int xCoOrd=0;
		 int yCoOrd=0;
		 findRectangle(xCoOrd,yCoOrd,path);

	 }

	 private static void findRectangle(int xCoOrd, int yCoOrd, int[] path) {
		 int direction=0;
		 //0 for left,1 for down,2 for right,3 for up 
		 for (int i = 0; i < path.length; i++) {
			 switch (direction) {
			 case 0:
				 xCoOrd-=path[i];
				 break;
			 case 1:
				 yCoOrd-=path[i];
				 break;
			 case 2:
				 xCoOrd+=path[i];
				 break;
			 case 3:
				 yCoOrd+=path[i];
				 break;
			 default:
				 break;
			 }
			 System.out.println(xCoOrd+" "+yCoOrd);
			 direction++;
			 direction%=4;

		 }

	 }


 }