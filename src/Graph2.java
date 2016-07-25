// Java program for Kruskal's algorithm to find Minimum Spanning Tree
// of a given connected, undirected and weighted graph
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
 
public class Graph2
{
    class Edge implements Comparable<Edge>
    {
        int src, dest, weight;
        public int compareTo(Edge compareEdge)
        {
            return this.weight-compareEdge.weight;
        }
    };

    class subset
    {
        int parent, rank;
    };
 
    int V, E,W;   
    Edge edge[]; 
    Graph2(int v, int e)
    {
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i=0; i<e; ++i)
            edge[i] = new Edge();
    }
    int find(subset subsets[], int i)
    {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);
        return subsets[i].parent;
    }
    void Union(subset subsets[], int x, int y)
    {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);
        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;
        else
        {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }
 
    void KruskalMST()
    {
        Edge result[] = new Edge[V];  
        int e = 0;  
        int i = 0; 
        for (i=0; i<V; ++i)
            result[i] = new Edge();
        Arrays.sort(edge);
        subset subsets[] = new subset[V];
        for(i=0; i<V; ++i)
            subsets[i]=new subset();
        for (int v = 0; v < V; ++v)
        {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }
        i = 0;
        while (e < V - 1)
        {
            Edge next_edge = new Edge();
            next_edge = edge[i++];

            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);
            if (x != y)
            {
                result[e++] = next_edge;
                Union(subsets, x, y);
            }
        }
 
        System.out.println("Following are the edges in the constructed MST");
        for (i = 0; i < e; ++i)
            System.out.println(result[i].src+" -- "+result[i].dest+" == "+
                               result[i].weight);
    }
 
    public static void main (String[] args)
    {
		int V = 6; 
		int E = 15;  
        
        
        
        
        int[][] inputMatrix=new int[][]{{0,5,6,9,12,5},
        								{0,0,4,3,8,10},
        								{0,0,0,8,5,12},
        								{0,0,0,0,6,6},
        								{0,0,0,0,0,7},
        								{0,0,0,0,0,0}};   
        Graph2 graph = new Graph2(V, E);
        Set<String> set=new HashSet<>();
        int count=0;
        for (int i = 0; i < inputMatrix.length; i++) {
			for (int j = 0; j < inputMatrix[0].length; j++) {
				if(inputMatrix[i][j]==0)
					continue;
				String srcDest=i+"/"+j;
				String destSrc=j+"/"+i;
				if(!set.contains(srcDest) && !set.contains(destSrc))
				{
					graph.edge[count].src=i;
					graph.edge[count].dest=j;
					graph.edge[count].weight=inputMatrix[i][j];
					set.add(srcDest);
					count++;
				}
			}
		} 
        graph.W=3;
        graph.KruskalMST();
    }
}