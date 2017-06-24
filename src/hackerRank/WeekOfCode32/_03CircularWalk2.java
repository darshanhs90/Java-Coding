package hackerRank.WeekOfCode32;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class _03CircularWalk2 {
	static HashMap<Integer,Integer> map=new HashMap<>();
	static int circularWalk(int n, int s, int t, int r_0, int g, int seed, int p){
		// Complete this function
		//calculate r[1] through r[n]
		int[] points=new int[n];
		points[0]=r_0;
		for (int i = 1; i < points.length; i++) {
			points[i]=(int) (((long)(points[i-1]*g+seed))%p);
		}

		//maintain visited and calculate if we can reach t from s,if we can't reach from a certain point,return Max
		//find the min of all the dfs possibilities
		LinkedList<Integer> set=new LinkedList<>();
		return dfs(points,s,s,t,0,set);
	}
	private static int dfs(int[] points, int prev,int currentSource, int target,int count,LinkedList<Integer> set) {
		if(currentSource==target){
			if(map.containsKey(prev) && map.get(prev)>(count-1))
			{
				map.put(prev, count-1);
			}
			else if(!map.containsKey(prev))
			{
				map.put(prev, count-1);
			}
			return count;
		}
		if(points[currentSource]==0||set.contains(currentSource)){
			if(points[currentSource]==0)
				map.put(currentSource, Integer.MAX_VALUE);
			return Integer.MAX_VALUE;
		}
		if(map.containsKey(currentSource))
		{
			return count+map.get(currentSource);
		}

		int clockWiseValue=Integer.MAX_VALUE,anticlockValue=Integer.MAX_VALUE,output=Integer.MAX_VALUE;
		for (int i = 1; i <=points[currentSource]; i++) {
			int clockPos=(currentSource+i)%(points.length);
			int anticlockPos=(currentSource-i);
			if(anticlockPos<0)
				anticlockPos=points.length+anticlockPos;
			set.add(currentSource);
			clockWiseValue=Math.min(clockWiseValue, dfs(points,currentSource,clockPos,target,count+1,set));
			//anti-clockwise
			anticlockValue=Math.min(anticlockValue,dfs(points,currentSource,anticlockPos,target,count+1,set));
			set.remove(set.size()-1);
		}
		output=Math.min(clockWiseValue, anticlockValue);
		return output;
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
		if(s==t){
			System.out.println(0);
			System.exit(0);
		}
		int result = circularWalk(n, s, t, r_0, g, seed, p);
		if(result==Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(result);
	}
}
