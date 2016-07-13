import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Assignment1
{
	/*
	 * Author :Haridarshan H.S.
	 * Method Name : breadthSearch
	 * Return parameter:boolean
	 * This method Returns true if there is a path from the source currsource
	 * to the target 'target' in the reverseMatrix which is an extension to 
	 * the residual graph. This method also fills parent[] to store the path
	 * taken to reach the target.
	 * The path is found by performing a breadth first search on the source currSource
	 */
	static int noOfVertices; 
	//A static variable to store the number of vertices of the graph
	public static boolean breadthSearch(int reverseMatrix[][], int currSource, int target, int parent[])
	{
		boolean visitedArray[] = new boolean[noOfVertices];
		Arrays.fill(visitedArray, false);
		//this visited array is used to keep track if the current node has been traversed or not
		//It is initialized to false for each bfs in order to find a new path for each search

		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(currSource);
		visitedArray[currSource] = true;
		parent[currSource]=-1;
		//set the currsource flag to be visited and its parent to be -1,since it is the source

		//while there are elements in the queue
		//dequeue the node one after the other and perform a bfs on the node until the queue is empty
		while (queue.size()!=0)
		{
			int u = queue.poll();
			for (int v=0; v<noOfVertices; v++)
			{
				if (visitedArray[v]==false && reverseMatrix[u][v] > 0)
				{
					queue.add(v);
					parent[v] = u;
					visitedArray[v] = true;
				}
			}
		}

		//if the bfs results in the target node being visited,return true
		if(visitedArray[target] == true)
			return true;
		else
			return false;
	}

	public static int performFordFulkersonAlgo(int inputMatrix[][], int currSource, int target)
	{

		int parentArray[] = new int[noOfVertices];
		int maxFlowValue = 0;
		int i, j;
		//initialise the reverse matrix or the residual matrix with the input graph matrix
		int reverseMatrix[][] = new int[noOfVertices][noOfVertices];
		for (i = 0; i < noOfVertices; i++){
			for (j = 0; j < noOfVertices; j++){
				reverseMatrix[i][j] = inputMatrix[i][j];
			}
		}
		int pathFlowValue = Integer.MAX_VALUE;
		//set the initial pathflow value to be infinity,or the max value in this case

		//execute the bfs approach till there exists a path from the current source to the target
		while (breadthSearch(reverseMatrix, currSource, target, parentArray)==true)
		{
			//reset the pathflow value to be infinity,or the max value in this case
			pathFlowValue = Integer.MAX_VALUE;
			/* Find the minimum residual capacity of the edges(reverse matrix values here) along the path
			taken by the breadth search method which in turn gives 
			the maximum flow through the path found.*/
			for (j=target; j!=currSource; j=parentArray[j])
			{
				i = parentArray[j];
				pathFlowValue = Math.min(pathFlowValue, reverseMatrix[i][j]);
			}
			/* update the  residual capacities(reverse matrix values here) of the edges and
			   reverse edges along the path */
			for (j=target; j != currSource; j=parentArray[j])
			{
				i = parentArray[j];
				reverseMatrix[i][j] -= pathFlowValue;
				reverseMatrix[j][i] += pathFlowValue;
			}
			maxFlowValue += pathFlowValue;
		}
		return maxFlowValue;
	}


	public static void main (String[] args) throws java.lang.Exception
	{

		int graph[][] =new int[][] { {0, 4, 7, 10, 0, 0},
			{0, 0, 0, 0, 2, 10},
			{0, 2, 0, 2, 10, 0},
			{0, 0, 0, 0, 2, 6},
			{0, 0, 0, 0, 0, 7},
			{0, 0, 0, 0, 0, 0}
		};
		Assignment1 a1 = new Assignment1();
		a1.noOfVertices=graph.length;
		System.out.println("Max flow output is : " +
				a1.performFordFulkersonAlgo(graph, 0, 5));

	}
}