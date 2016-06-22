package Warmup;

import java.util.ArrayList;
import java.util.List;

import ctci._02linkedList.Node;

public class _74ebayInterview {
	//Given a sorted array, create a balanced binary search tree 

	static class TreeNode{
		int data;
		TreeNode left,right;
		public TreeNode(int value){
			data=value;
		}
	}

	static class BinarySearchTree{
		TreeNode rootNode;

		static TreeNode convertToBST(int inputArray[],int left,int right){
			if(left>right)
				return null;

			int mid=(left+right)/2;

			TreeNode node=new TreeNode(inputArray[mid]);

			node.left=convertToBST(inputArray,left,mid-1);
			node.right=convertToBST(inputArray,mid+1,right);
			return node;
		}
		public static void main(String args[]){
			BinarySearchTree bst=new BinarySearchTree();
			int inputArray[]=new int[]{1,2,3,4,5,6,7};
			TreeNode tn=convertToBST(inputArray,0,inputArray.length-1);
		}

	}
	static class lister{
		public static void main(String[] args) {
			List list = new ArrayList<>();

			for (int i = 0; i < list.size(); i++)
				System.out.println(list.get(i));
		}
	}


	//Given a string S, find the longest palindromic substring.

	//S="abaabcbabaa"->returns abcba

	//left=0,right=0

	/*	callutil(s,0,0)
	callutl(s,0,1)

	callutil(s,1,1)
	callutl(s,1,2)*/

	static class palindrome{
		public static String longestPalindrome(String s){
			int left=0,right=0;
			for(int i=0;i<s.length();i++){
				int length1=callPalindromeUtil(s,i,i);
				int length2=callPalindromeUtil(s,i,i+1);
				int length=Math.max(length1,length2);
				//length=

				if(length>right-left)
				{    
					//new left and new right values
					left=i-(length-1)/2;
					right=i+length/2;
				}

			}
			return s.substring(left,right+1);
		}



		public static int callPalindromeUtil(String s,int left,int right){
			int l=left,r=right;

			while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r))
			{
				l--;
				r++;
			}
			return r-l-1;
		}
	}
	//abaabcbabaa

	//left=0,right=0
	//i=0
	/*l=0,r=0->l=-1,r=1->returns 1
	l=0,r=1->returns 0
	left=0
	right=0

	//i=1
	l=1,r=1->l=0,r=2->l=-1,r=3->returns 3/aba
	l=1,r=2->returns 0

	length=3
	left=1-(1)=0
	right=1+1=2

	aba
	 */

	//Given iterator, implement peek() function
	static class iterator{
		static Node nextItem;
		public static boolean hasNext(){
			if(nextItem!=null)
				return true;

			if(iterator.hasNext())
				nextItem=iterator.next();

			return nextItem!=null;
		}



		public static Node next(){
			if(hasNext()){
				Node t=nextItem;
				nextItem=null;
				return t;
			}
			return nextItem;
		}

		public static Node peek(){
			if(hasNext())    
				return nextItem;
			return null;
		}
	}
}

