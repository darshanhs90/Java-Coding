package PracticeLeetCode;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class _004MedianOfTwoSortedArrays {

	/*	public static void main(String[] args) {
		System.out.println(findMedianSortedArrays(new int[]{1, 2},new int[]{3,4}));//2.5
		System.out.println(findMedianSortedArrays(new int[]{1, 3},new int[]{2}));//2.0
	}
	 */

	static class Node {
		int value;
		Node next;
		Node below;

		Node(int value) {
			this.value = value;
		}
	}

	static int maxHop=0;
	   static int searchNodes(Node root, int value) {
	    	if(root==null)
	    		return -1;
	    	maxHop=0;
	    	if(root.value==value)
	    		return 1;
	    	int retValue=dfs(root,value,root.value);
	    	return retValue==Integer.MAX_VALUE?maxHop:retValue;
	    }
		
		
		
		private static int dfs(Node root, int value,int prevValue) {
	    	if(root==null)
	    		return 1;
	    	else if(root.value==value)
	    		return 0;
	    	else if(root.value>value && value>prevValue)
	    		return 1;
	    	int nextVal=Integer.MAX_VALUE,belowVal= Integer.MAX_VALUE;
			if(root.next!=null){
				int val=dfs(root.next,value,root.value);
				nextVal=(val==Integer.MAX_VALUE)?Integer.MAX_VALUE:1+val;
			}
			if(root.below!=null){
				int val=dfs(root.below,value,root.value);
				belowVal=(val==Integer.MAX_VALUE)?Integer.MAX_VALUE:1+val;
			}
			if(nextVal!=Integer.MAX_VALUE)
			{
				System.out.println(nextVal);
				maxHop=Math.max(maxHop, nextVal);
			}
			if(belowVal!=Integer.MAX_VALUE)
			{
				System.out.println(belowVal);
				maxHop=Math.max(maxHop, belowVal);
			}
			return Math.min(nextVal, belowVal);
		}

/*	4
	8
	28 52
	25 81
	5 33 55 70 83
	55*/

	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(System.in);
		//final String fileName = System.getenv("OUTPUT_PATH");
		//BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
		int res;

		int _nodes_rows = 0;
		_nodes_rows = Integer.parseInt(in.nextLine().trim());

		Node root = new Node(0);
		Node lineHead = null;
		Node aboveNode = null;

		for(int _nodes_i=0; _nodes_i<_nodes_rows; _nodes_i++) {
			if (lineHead == null) {
				lineHead = root;
				aboveNode = null;
			} else {
				lineHead.below = new Node(lineHead.value);
				aboveNode = lineHead;
				lineHead = lineHead.below;
			}
			Node current = lineHead;

			String[] stringArray = in.nextLine().split(" ");
			int[] intArray = new int[stringArray.length];
			for (int i = 0; i < stringArray.length; i++) {
				String numberAsString = stringArray[i];
				intArray[i] = Integer.parseInt(numberAsString);
			}

			for (int nextInt : intArray) {
				while (aboveNode != null && aboveNode.next != null && nextInt > aboveNode.next.value) {
					aboveNode = aboveNode.next;
					current.next = new Node(aboveNode.value);
					current = current.next;
					aboveNode.below = current;
				}
				current.next = new Node(nextInt);
				current = current.next;
			}
			while (aboveNode != null && aboveNode.next != null) {
				aboveNode = aboveNode.next;
				current.next = new Node(aboveNode.value);
				current = current.next;
				aboveNode.below = current;
			}
		}


		int _value;
		_value = Integer.parseInt(in.nextLine().trim());

		res = searchNodes(root, _value);
		System.out.println(res);
		//bw.write(String.valueOf(res));
		//bw.newLine();

		//bw.close();
	}
	
	
}


