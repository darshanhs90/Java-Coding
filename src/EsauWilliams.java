import java.util.HashSet;

public class EsauWilliams {

	static int noOfVertices;
	static int graphStatus[] = new int[25];
	static int tradeOffArray[] = new int[25];
	static int tradeOffEdge[] = new int[25];
	static int weightArray[] = new int[25];
	static int comparisonNum[] = new int[25];
	static int maxWeight;
	/*
	 * Author :Haridarshan H.S.
	 * Method Name : recursiveCompareNum
	 * Return parameter:N/A
	 * This method performs a recursive comparison of the adj matrix with the vertices number
	 */

	public static void recursiveCompareNum(int adjmat[][],int v,int n)
	{

		comparisonNum[v] = n;
		for(int i=0;i<noOfVertices;i++)
			if(comparisonNum[i]==0 && adjmat[v][i]>0)
				recursiveCompareNum(adjmat,i,n);

	}
	static HashSet<String> set=new HashSet<>();
	public static void runMST(int matrix[][])
	{	
		graphStatus = new int[noOfVertices*noOfVertices];//status of the graph/Node
		tradeOffArray = new int[noOfVertices*noOfVertices];//trade off array
		tradeOffEdge = new int[noOfVertices*noOfVertices];//trade off edge array
		weightArray = new int[noOfVertices*noOfVertices];//weight array
		comparisonNum = new int[noOfVertices*noOfVertices];//comparison number array
		int adjacencyMatrix[][] = new int[noOfVertices][noOfVertices];
		int i,j,k,minTradeOffValue,minIndex=0,minimumWeight,costCompare=0;
		performTradeOff(matrix);
		for(i=0;i<noOfVertices;i++){
			for(j=0;j<noOfVertices;j++)
				adjacencyMatrix[i][j]=0;
		}
		//modify adjacency matrix to value equal to 0
		for(i=0;i<noOfVertices;i++)
		{
			for(j=1,minTradeOffValue=Integer.MAX_VALUE,minIndex=0;j<noOfVertices;j++)
				if(minTradeOffValue>tradeOffArray[j])
				{
					minTradeOffValue = tradeOffArray[j];
					minIndex = j;
				}
			for(k=0;k<noOfVertices;k++) 
			{
				graphStatus[k]=0;
				weightArray[k]=0;
			}
            //CMST weight evaluation condition
            // (weight(adjacencyMatrix,tradeOffEdge[i])+1)<maxWeight && (DFS_Path(adjacencyMatrix,minIndex,tradeOffEdge[minIndex])==0)
            //add the edge to the output if the max weight of the node is less
            //than the cluster capacity ,excluding the weight of the source node
			if((weight(adjacencyMatrix,tradeOffEdge[i])+1)<maxWeight && (DFS_Path(adjacencyMatrix,minIndex,tradeOffEdge[minIndex])==0))
			{
				adjacencyMatrix[minIndex][tradeOffEdge[minIndex]]=matrix[minIndex][tradeOffEdge[minIndex]];
				adjacencyMatrix[tradeOffEdge[minIndex]][minIndex]=matrix[minIndex][tradeOffEdge[minIndex]];
				matrix[0][minIndex]=matrix[0][tradeOffEdge[minIndex]];
				matrix[minIndex][0]=matrix[0][tradeOffEdge[minIndex]];
			}
			else if((weight(adjacencyMatrix,tradeOffEdge[i])+1)>maxWeight)//check for the maxWeight of cluster condition
			{
				matrix[minIndex][tradeOffEdge[minIndex]]=Integer.MAX_VALUE;
				matrix[tradeOffEdge[minIndex]][minIndex]=Integer.MAX_VALUE;
			}
			performTradeOff(matrix);//perform trade off computation
		}
		//set the mintrade off values for each of the edges


		//compare the costvalue recursively
		for(i=0;i<noOfVertices;i++)
			if(comparisonNum[i]==0) 
				recursiveCompareNum(adjacencyMatrix,i,costCompare++);

		//update the weight values
		for(i=1;i<costCompare;i++)
		{   for(j=1,minimumWeight=Integer.MAX_VALUE;j<noOfVertices;j++){
			if(comparisonNum[j]==i && minimumWeight>matrix[0][j])
			{ 
				minimumWeight=matrix[0][j];
				minIndex=j;
			}
		}
		adjacencyMatrix[0][minIndex]=minimumWeight;
		adjacencyMatrix[minIndex][0]=minimumWeight;

		}



		//print out the output

		System.out.println("Output Matrix is");
		for(i=0;i<noOfVertices;i++){
			for(j=0;j<noOfVertices;j++)
				System.out.print("  "+adjacencyMatrix[i][j]);
			System.out.println();
		}
		int totalCost=0;
		System.out.println("Edges are");
		for(i=0;i<noOfVertices;i++){
			for(j=0;j<noOfVertices;j++)
			{
				String srcDest=i+"-"+j;
				String destSrc=j+"-"+i;
				if(!set.contains(srcDest) && !set.contains(destSrc) && adjacencyMatrix[i][j]!=0)
				{
					System.out.println("<---Source---> "+i+" <--destination--> "+j+" <===Weight==> "+adjacencyMatrix[i][j]);
					totalCost+=adjacencyMatrix[i][j];
					set.add(srcDest);
					set.add(destSrc);
				}
			}
		}
		System.out.println("Total Cost Of MST is "+ totalCost);

	}

	public static void performTradeOff(int adjmat[][])
	{
		int i,j,minTradeOffValue,minNodeValue=0;
		for(i=1;i<noOfVertices;i++)
		{   
			for(j=1,minTradeOffValue=Integer.MAX_VALUE;j<noOfVertices;j++)
				if(minTradeOffValue>(adjmat[i][j]-adjmat[i][0]) && adjmat[i][j]!=0)
				{
					minTradeOffValue = adjmat[i][j]-adjmat[0][i];
					minNodeValue = j;
				}
			tradeOffArray[i] = minTradeOffValue;
			tradeOffEdge[i] = minNodeValue;
		}
	}

	public static int DFS_Path(int adjmat[][],int v1,int v2)
	{
		int result=0;
		graphStatus[v1]=1;
		for(int i=0;i<noOfVertices;i++)
			if(graphStatus[i]==0 & adjmat[v1][i]>0 & i==v2)
				return 1;
			else if (graphStatus[i]==0 & adjmat[v1][i]>0)
				result=result+DFS_Path(adjmat,i,v2);

		return result;
	}

	public static int weight(int adj_matrix[][], int v)
	{
		int i,sum=0;
		weightArray[v]=1;
		for(i=0;i<noOfVertices;i++)
		{
			if(adj_matrix[v][i]>0 && weightArray[i]==0)
				sum = sum+1+weight(adj_matrix,i);
		}
		return sum;
	}



	public static void main(String arg[]){
		noOfVertices=6;
		int[][] matrix=new int[][]{ {0, 5, 6, 9,12, 15},
			{5, 0, 4, 3, 8, 10},
			{6, 4, 0, 8, 5, 12},
			{9, 3, 8, 0, 6, 6},
			{12,8, 5, 6, 0, 7},
			{15,10,12,6, 7, 0}};   

			for(int i=0;i<noOfVertices;i++)
			{
				tradeOffEdge[i]=0;//initialise the tradeoff edge value to be 0
				comparisonNum[i]=0;//initialise the comparison edge value to be 0
				if(i==0)
					tradeOffArray[i]=Integer.MAX_VALUE;
				else
					tradeOffArray[i]=0;
			}
			maxWeight=3;
			runMST(matrix);
	}
}