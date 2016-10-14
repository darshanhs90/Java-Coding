package PracticeLeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class _218SkylineProblem {
	//http://www.programcreek.com/2014/06/leetcode-the-skyline-problem-java/
	public static void main(String[] args) {

	}
	class Edge{
		int start,height;
		boolean isStart;
		public Edge(int start,int height,boolean isStart) {
			this.start=start;
			this.height=height;
			this.isStart=isStart;
		}
	}
	public List<int[]> getSkyline(int[][] buildings) {
		List<int[]> outputList=new ArrayList<int[]>();
		if(buildings==null||buildings.length==0)
			return outputList;
		List<Edge> edgeList=new ArrayList<>();
		for (int i = 0; i < buildings.length; i++) {
			Edge edge=new Edge(buildings[i][0], buildings[i][2], true);
			edgeList.add(edge);
			edge=new Edge(buildings[i][1], buildings[i][2], false);
			edgeList.add(edge);
		}


		Collections.sort(edgeList,new Comparator<Edge>() {

			public int compare(Edge a,Edge b)
			{
				if(a.start!=b.start)
					return Integer.compare(a.start, b.start);
				if(a.isStart && b.isStart)
					return Integer.compare(b.height,a.height);
				if(!a.isStart && !b.isStart)
					return Integer.compare(a.height, b.height);
				return a.isStart?-1:1;
			}
		});

		PriorityQueue<Integer> heightHeap=new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < edgeList.size(); i++) {
			Edge edge=edgeList.get(i);
			if(edge.isStart)
			{
				if(heightHeap.isEmpty())
				{
					outputList.add(new int[]{edge.start,edge.height});
				}
				else if(edge.height>heightHeap.peek())
				{
					outputList.add(new int[]{edge.start,edge.height});
				}
				heightHeap.add(edge.height);
			}
			else{
				heightHeap.remove(edge.height);
				if(heightHeap.isEmpty())
				{
					outputList.add(new int[]{edge.start,0});
				}
				else if(edge.height>heightHeap.peek())
				{
					outputList.add(new int[]{edge.start,heightHeap.peek()});
				}
			}
		}
		return outputList;
	}
}