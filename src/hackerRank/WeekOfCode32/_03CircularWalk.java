package hackerRank.WeekOfCode32;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class _03CircularWalk {
	static HashMap<Integer,Integer> map=new HashMap<>();
	static int circularWalk(int n, int s, int t, int r_0, int g, int seed, int p){
		// Complete this function
		//calculate r[1] through r[n]
		Point[] points=new Point[n];
		for (int i = 0; i < points.length; i++) {
			Point point=new Point(r_0, false, false);
			if(i!=0)
			{
				point.rValue=((long)(points[i-1].rValue*g+seed))%p;
			}
			if(i==s){
				point.isSource=true;
			}
			if(i==t)
				point.isTarget=true;
			points[i]=point;
		}
		if(s==t)
			return 0;
		//maintain visited and calculate if we can reach t from s,if we can't reach from a certain point,return Max
		//find the min of all the dfs possibilities
		HashSet<Integer> set=new HashSet<>();
		return dfs(points,s,t,0,set);
	}
	private static int dfs(Point[] points, int s, int t,int count,HashSet<Integer> set) {
		if(s==t)
			return count;
		if(points[s].rValue==0||set.contains(s)){
			map.put(s, Integer.MAX_VALUE);
			return Integer.MAX_VALUE;
		}
		if(map.containsKey(s)){
			if(map.get(s)!=Integer.MAX_VALUE){
				return count+map.get(s);
			}
			else
				return map.get(s);
		}
		int clockWiseValue=Integer.MAX_VALUE,anticlockValue=Integer.MAX_VALUE,output=Integer.MAX_VALUE;
		for (int i = 1; i <=points[s].rValue; i++) {
			int nextPos;
			for (int j = 0; j < 2; j++) {//for clockwise and anti-clockwise
				if(j==0)
				{
					//clockwise
					nextPos=(s+i)%(points.length);
					set.add(s);
					clockWiseValue=Math.min(output, dfs(points,nextPos,t,count+1,set));
					set.remove(s);
				}
				else{
					//anti-clockwise
					nextPos=(s-i);
					if(nextPos<0)
						nextPos=points.length+nextPos;
					set.add(s);
					anticlockValue=Math.min(output,dfs(points,nextPos,t,count+1,set));
					set.remove(s);
				}
				output=Math.min(clockWiseValue, anticlockValue);
			}
		}
		if(!map.containsKey(s) || map.get(s)>output)
			map.put(s, output);
		return output;
	}
	static class Point{
		long rValue;
		boolean visited,isSource,isTarget;
		public Point(int rValue,boolean isSource,boolean isTarget) {
			this.rValue=rValue;
			this.isSource=isSource;
			this.isTarget=isTarget;
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int s = in.nextInt();
		int t = in.nextInt();
		int r_0 = in.nextInt();
		int g = in.nextInt();
		int seed = in.nextInt();
		int p = in.nextInt();
		int result = circularWalk(n, s, t, r_0, g, seed, p);
		if(s==t){
			System.out.println(0);
			System.exit(0);
		}
		if(result==Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(result);
	}
}
