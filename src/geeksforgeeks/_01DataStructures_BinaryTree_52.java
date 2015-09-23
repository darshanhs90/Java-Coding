package geeksforgeeks;

import geeksforgeeks._01DataStructures_BinaryTree_00.Node;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * http://www.geeksforgeeks.org/sum-numbers-formed-root-leaf-paths/
 * Sum of all the numbers that are formed from root to leaf paths
 */;
 public class _01DataStructures_BinaryTree_52 {
	 static int path[];
	 static ArrayList<int []> arrayList=new ArrayList<int []>();
	 public static void main(String[] args) {
		 _01DataStructures_BinaryTree_00 binaryTree1=new _01DataStructures_BinaryTree_00();
		 binaryTree1.insert(null,null,1);
		 binaryTree1.insert(1,"left",2);
		 binaryTree1.insert(1,"right",3);
		 binaryTree1.insert(2,"left",4);
		 binaryTree1.insert(2,"right",5);
		 binaryTree1.insert(3,"left",6);
		 binaryTree1.insert(3,"right",7);
		 binaryTree1.insert(6,"left",8);
		 binaryTree1.preOrder();
		 System.out.println(findLeafPaths(binaryTree1));
		 System.out.println(findLeafPathsRecursive(binaryTree1));

	 }

	 private static int findLeafPathsRecursive(
			 _01DataStructures_BinaryTree_00 binaryTree1) {
		 return findLeafPathsRecursive(binaryTree1.rootNode,0);

	 }

	 private static int findLeafPathsRecursive(Node node,int sum) {
		 if(node==null)
			 return 0;
		 sum=sum*10+node.data;
		 if(node.left==null && node.right==null)
			 return sum;
		 return findLeafPathsRecursive(node.left,sum)+findLeafPathsRecursive(node.right,sum);
	 }

	 private static int findLeafPaths(
			 _01DataStructures_BinaryTree_00 binaryTree1) {
		 path=new int[getHeight(binaryTree1.rootNode)];
		 findLeafPaths(binaryTree1.rootNode,path,0);
		 int sum=0;
		 for (int i = 0; i < arrayList.size(); i++) {
			 int []sumArray=arrayList.get(i);
			 String number="";
			 for (int j = 0;j<sumArray.length; j++) {
				 number+=sumArray[j];
			 }
			 sum+=Integer.parseInt(number);
		 }
		 return sum;
	 }

	 private static void findLeafPaths(Node node, int[] path2, int i) {
		 if(node==null)
			 return;
		 path[i]=node.data;
		 i++;
		 if(node.left==null && node.right==null)
		 {
			 arrayList.add(Arrays.copyOfRange(path,0,i));
		 }
		 else{
			 findLeafPaths(node.left,path2,i);
			 findLeafPaths(node.right,path2,i);	 
		 }
	 }

	 private static int getHeight(Node node) {
		 if(node!=null)
		 {
			 int leftHeight=getHeight(node.left);
			 int rightHeight=getHeight(node.right);
			 return 1+((leftHeight>rightHeight)?leftHeight:rightHeight);
		 }
		 return 0;
	 }

 }
