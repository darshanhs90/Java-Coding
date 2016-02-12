package hackerRank.DataStructures.Trees;

import java.util.Map;
import java.util.TreeMap;

/*
 * Link:https://www.hackerrank.com/challenges/tree-top-view
 */

public class _05TreeTopView {
	class Node {
		int data;
		Node left;
		Node right;
	}
	static TreeMap<Integer,Integer> elementMap=new TreeMap<Integer,Integer>();
	void top_view(Node root)
	{
		printTopView(root,0);
		for(Map.Entry<Integer,Integer> entry : elementMap.entrySet()) {
			Integer value = entry.getValue();
			System.out.print(value+" ");
		}
	}
	void printTopView(Node node,int level){
		if(node!=null){
			if(!elementMap.containsKey(level))   
			{
				elementMap.put(level,node.data);
				printTopView(node.left,level-1);
				printTopView(node.right,level+1); 
			}
		}
	}
}
