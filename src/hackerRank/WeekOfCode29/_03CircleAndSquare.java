package hackerRank.WeekOfCode29;

import java.util.Arrays;
import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/contests/w29/challenges/a-circle-and-a-square
 */
public class _03CircleAndSquare {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int w = in.nextInt();//20
		int h = in.nextInt();//16
		int circleX = in.nextInt();
		int circleY = in.nextInt();
		int r = in.nextInt();
		int x1 = in.nextInt();
		int y1 = in.nextInt();
		int x3 = in.nextInt();
		int y3 = in.nextInt();
		// your code goes here
		char[][] canvas=new char[h][w];
		canvas=printCircle(canvas,circleY,circleX,r,w,h);
		canvas=printSquare(canvas,y1,x1,y3,x3,w,h);
		printCanvas(canvas);
	}

	private static char[][] printSquare(char[][] canvas, int x1, int y1, int x3, int y3,int w,int h) {
		Point p1=new Point(x1, y1);
		Point p3=new Point(x3, y3);
		Point pArr[]=findOtherSquarePoints(p1,p3);
		Point p2=pArr[0];
		Point p4=pArr[1];


		double leftMostPoint=Math.max(0,Math.min(p1.y, Math.min(p2.y, Math.min(p3.y, p4.y))));
		double rightMostPoint=Math.min(canvas.length-1,Math.max(p1.y, Math.max(p2.y, Math.max(p3.y, p4.y))));
		double topMostPoint=Math.max(0,Math.min(p1.x, Math.min(p2.x, Math.min(p3.x, p4.x))));
		double bottomMostPoint=Math.min(canvas[0].length-1,Math.max(p1.x, Math.max(p2.x, Math.max(p3.x, p4.x))));

		double squareEdge=findDistance(p1, p2);
		double squareArea=squareEdge*squareEdge;
		for (int i = 0; i < canvas.length; i++) {
			for (int j = 0; j < canvas[0].length; j++) {
				if(canvas[i][j]=='#')
					continue;
				if(validateSquarePoint(leftMostPoint,rightMostPoint,topMostPoint,bottomMostPoint,new Point(i,j),p1,p2,p3,p4,squareArea))
				{
					canvas[i][j]='#';
				}
				else{
					canvas[i][j]='.';
				}
			}
		}
		return canvas;
	}
	private static boolean validateSquarePoint(double leftMostPoint, double rightMostPoint, double topMostPoint,
			double bottomMostPoint,Point i, Point p1, Point p2, Point p3, Point p4, double squareArea) {
		/*		if((i.y>=leftMostPoint && i.y<=rightMostPoint && i.x>=topMostPoint && i.x<=bottomMostPoint))
		{*/
		/*System.out.println(i.x+"/"+i.y);*/
		double area1=calculateArea(i,p1,p2);
		double area2=calculateArea(i,p2,p3);
		double area3=calculateArea(i,p3,p4);
		double area4=calculateArea(i,p4,p1);
		area1=Double.isNaN(area1)?0:(float)area1;
		area2=Double.isNaN(area2)?0:(float)area2;
		area3=Double.isNaN(area3)?0:(float)area3;
		area4=Double.isNaN(area4)?0:(float)area4;
		/*System.out.println("--->"+(Double.isNaN(area2)));
			System.out.println(squareArea+"/"+area1+"/"+area2+"/"+area3+"/"+area4);
			System.out.println((float)area1+(float)area2+(float)area3+(float)area4);
			System.out.println(((float)Math.round(squareArea))==((float)area1+(float)area2+(float)area3+(float)area4));*/
		return ((float)Math.round(squareArea))==((float)area1+(float)area2+(float)area3+(float)area4);
		/*		}
		System.out.println(i.x+"/"+i.y);
		return false;*/
	}
	private static double calculateArea(Point i, Point p1, Point p2) {
		double a=findDistance(i, p1);
		double b=findDistance(p1, p2);
		double c=findDistance(p2, i);
		double s=(a+b+c)/2;
		double area=(s*(s-a)*(s-b)*(s-c));
		area=area==0?0:Math.sqrt(area);
		return area;
	}
	private static Point[] findOtherSquarePoints(Point p1, Point p3) {
		double xc=(p1.x+p3.x)/2;
		double xd=(p1.x-p3.x)/2;
		double yc=(p1.y+p3.y)/2;
		double yd=(p1.y-p3.y)/2;
		Point p2=new Point(xc-yd, yc+xd);
		Point p4=new Point(xc+yd, yc-xd);
		return new Point[]{p2,p4};
	}
	private static char[][] printCircle(char[][] canvas, int circleX, int circleY, int r, int w, int h) {
		int leftMostPoint=Math.max(0, circleY-r);
		int rightMostPoint=Math.min(canvas[0].length-1, circleY+r);
		int topMostPoint=Math.max(0, circleX-r);
		int bottomMostPoint=Math.min(canvas.length-1, circleX+r);
		for (int i = 0; i < canvas.length; i++) {
			for (int j = 0; j < canvas[0].length; j++) {
				if(validateCirclePoint(leftMostPoint,rightMostPoint,topMostPoint,bottomMostPoint,circleX,circleY,i,j,r))
				{
					canvas[i][j]='#';
				}
				else{
					canvas[i][j]='.';
				}
			}
		}
		return canvas;
	}
	private static boolean validateCirclePoint(int leftMostPoint, int rightMostPoint, int topMostPoint,
			int bottomMostPoint, int centreX, int centreY, int i, int j, int r) {
		if((findDistance(new Point(centreX, centreY), new Point(i, j)))<=r)
		{
			return true;
		}
		return false;
	}
	static class Point{
		double x,y;
		public Point(double x,double y) {
			this.x=x;
			this.y=y;
		}
		public String toString(){
			return (this.x+"/"+this.y);
		}
	}
	private static void printCanvas(char[][] canvas) {
		for (int i = 0; i < canvas.length; i++) {
			for (int j = 0; j < canvas[0].length; j++) {
				System.out.print(canvas[i][j]);
			}
			System.out.println();
		}
	}

	private static double findDistance(Point p1,Point p2)
	{
		return Math.sqrt(Math.pow(p1.x-p2.x, 2)+Math.pow(p1.y-p2.y, 2));
	}
}
