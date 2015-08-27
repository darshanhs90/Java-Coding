package ctci;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import ctci._10BinarySearchTree.Node;


/*Implementation of Breadth First Search*/
public class _12BFS{
	Node rootNode;
	private void bfs(Node node){
		Queue<Node> q=new Queue<_10BinarySearchTree.Node>() {
			int noOfElements=0;
			LinkedList<Node> l=new LinkedList<Node>();
			@Override
			public int size() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public boolean isEmpty() {
				return (noOfElements==0)?true:false;
			}

			@Override
			public boolean containsAll(Collection<?> c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean addAll(Collection<? extends Node> c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean removeAll(Collection<?> c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean retainAll(Collection<?> c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public void clear() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public boolean add(Node e) {
				l.add(e);
				noOfElements++;
				return true;
			}

			

			@Override
			public Node remove() {
				noOfElements--;
				return l.removeFirst();
			}

			@Override
			public boolean contains(Object o) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public Iterator<Node> iterator() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Object[] toArray() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public <T> T[] toArray(T[] a) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean remove(Object o) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean offer(Node e) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public Node poll() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Node element() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Node peek() {
				// TODO Auto-generated method stub
				return null;
			}

			
		};
		q.add(rootNode);
		Node n;
		while(!q.isEmpty()){
			n=q.remove();
			if(n!=null){
				System.out.println(n.data);
				if(n.left!=null)
					q.add(n.left);
				if(n.right!=null)
					q.add(n.right);
			}
		}
	}

}