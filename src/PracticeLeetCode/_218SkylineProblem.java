package PracticeLeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class _218SkylineProblem {
	//http://www.programcreek.com/2014/06/leetcode-the-skyline-problem-java/
	public static void main(String[] args) {

	}a
	class Edge {
		int x;
		int height;
		boolean isStart;
	 
		public Edge(int x, int height, boolean isStart) {
			this.x = x;
			this.height = height;
			this.isStart = isStart;
		}
	}
	public List<int[]> getSkyline(int[][] buildings) {
		List<int[]> result = new ArrayList<int[]>();
	 
		if (buildings == null || buildings.length == 0
				|| buildings[0].length == 0) {
			return result;
		}
	 
		List<Edge> edges = new ArrayList<Edge>();
	 
		// add all left/right edges
		for (int[] building : buildings) {
			Edge startEdge = new Edge(building[0], building[2], true);
			edges.add(startEdge);
			Edge endEdge = new Edge(building[1], building[2], false);
			edges.add(endEdge);
		}
	 
		// sort edges 
		Collections.sort(edges, new Comparator<Edge>() {
			public int compare(Edge a, Edge b) {
				if (a.x != b.x)
					return Integer.compare(a.x, b.x);
	 
				if (a.isStart && b.isStart) {
					return Integer.compare(b.height, a.height);
				}
	 
				if (!a.isStart && !b.isStart) {
					return Integer.compare(a.height, b.height);
				}
	 
				return a.isStart ? -1 : 1;
			}
		});
	 
		// process edges
		PriorityQueue<Integer> heightHeap = new PriorityQueue<Integer>(10, Collections.reverseOrder());
	 
		for (Edge edge : edges) {
			if (edge.isStart) {
				if (heightHeap.isEmpty() || edge.height > heightHeap.peek()) {
					result.add(new int[] { edge.x, edge.height });
				}
				heightHeap.add(edge.height);
			} else {
				heightHeap.remove(edge.height);
	 
				if(heightHeap.isEmpty()){
					result.add(new int[] {edge.x, 0});
				}else if(edge.height > heightHeap.peek()){
					result.add(new int[]{edge.x, heightHeap.peek()});
				}
			}
		}
	 
		return result;
	}
}