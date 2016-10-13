package PracticeLeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class _297SerializeDeserializeBinaryTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public String serialize(TreeNode root) {
		StringBuilder sb=new StringBuilder();
		if(root==null)
			return sb.toString();
		Queue<TreeNode> queue=new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty())
		{
			TreeNode tn=queue.poll();
			if(tn==null)
			{
				sb.append("#,");
			}
			else{
				sb.append(tn.val+",");
				queue.add(tn.left);
				queue.add(tn.right);
			}
		}
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}

	public TreeNode deserialize(String data) {
		if(data==null||data.length()==0)
			return null;
		String[] arr=data.split(",");
		if(arr[0].contentEquals("#"))
			return null;
		TreeNode root=new TreeNode(Integer.parseInt(arr[0]));
		Queue<TreeNode> queue=new LinkedList<>();
		queue.add(root);
		int index=1;
		while(!queue.isEmpty())
		{
			TreeNode tn=queue.poll();
			if(arr[index].contentEquals("#"))
			{
				tn.left=null;
			}
			else{
				tn.left=new TreeNode(Integer.parseInt(arr[index]));
				queue.add(tn.left);
			}
			index++;


			if(arr[index].contentEquals("#"))
			{
				tn.right=null;
			}
			else{
				tn.right=new TreeNode(Integer.parseInt(arr[index]));
				queue.add(tn.right);
			}
			index++;
		}
		return root;	
	}

	public static void main(String[] args) {
		TreeNode tn=new TreeNode(1);
		tn.left=new TreeNode(2);
		tn.right=new TreeNode(3);
		tn.left.left=new TreeNode(4);
		tn.right.right=new TreeNode(5);
		preOrder(tn);
		System.out.println();
		_297SerializeDeserializeBinaryTree s=new _297SerializeDeserializeBinaryTree();
		System.out.println(s.serialize(tn));
		tn=s.deserialize("1,2,3,4,#,#,5,#,#,#,#");
		preOrder(tn);
	}

	private static void preOrder(TreeNode tn) {
		if(tn!=null)
		{
			preOrder(tn.left);
			System.out.print(tn.val+"/");
			preOrder(tn.right);
		}

	}

}
