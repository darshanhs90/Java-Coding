import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
 
public class ModifiedKruskalsAlgo
{
    //creates a edge class with source and destinations
    class GraphEdge implements Comparable<GraphEdge>
    {
        Node source, destination;
        int edgeWeight;
        public int compareTo(GraphEdge compareEdge)
        {
            return this.edgeWeight-compareEdge.edgeWeight;
        }
    };
    //creates a Node class with node value and node weight
    static class Node{
        int nodeValue;
        int nodeWeight=1;
        public Node(int value) {
            this.nodeValue=value;
        }
    };
    //creates a Cluster class with parent node value and rank of the cluster
    class Cluster
    {
        Node parent;
        int subsetRank;
    };
 
    int vertices,edges,clusterCapacity;   
    GraphEdge edgeArray[]; 
    HashMap<Integer,Integer> weightCount=new HashMap<>();
    HashMap<Integer,ArrayList<Integer>> elementList=new  HashMap<Integer,ArrayList<Integer>>();
    ModifiedKruskalsAlgo(int v, int e)
    {
        vertices = v;
        edges = e;
        edgeArray = new GraphEdge[edges];
        for (int i=0; i<e; ++i)
            edgeArray[i] = new GraphEdge();
    }
    //finds if the reference node is part of multiple clusters
    Node findNode(Cluster clusterArray[], Node referenceNode)
    {
        if (clusterArray[referenceNode.nodeValue].parent != referenceNode)
            clusterArray[referenceNode.nodeValue].parent = findNode(clusterArray, clusterArray[referenceNode.nodeValue].parent);
        return clusterArray[referenceNode.nodeValue].parent;
    }
    //performs the union between two nodes
    void performUnion(Cluster subsets[], Node source, Node destination)
    {
        Node sourceRoot = findNode(subsets, source);
        Node destinationRoot = findNode(subsets, destination);
        if (subsets[sourceRoot.nodeValue].subsetRank < subsets[destinationRoot.nodeValue].subsetRank)
            subsets[sourceRoot.nodeValue].parent = destinationRoot;
        else if (subsets[sourceRoot.nodeValue].subsetRank > subsets[destinationRoot.nodeValue].subsetRank)
            subsets[destinationRoot.nodeValue].parent = sourceRoot;
        else
        {
            subsets[destinationRoot.nodeValue].parent = sourceRoot;
            subsets[sourceRoot.nodeValue].subsetRank++;
        }
    }
 
    void KruskalMST()
    {
        GraphEdge result[] = new GraphEdge[vertices];  
        int e = 0;  
        int i = 0; 
        for (i=0; i<vertices; ++i)
            result[i] = new GraphEdge();
        //sort the array depending on the weights
        Arrays.sort(edgeArray);
        Cluster subsets[] = new Cluster[vertices];
        for(i=0; i<vertices; ++i)
            subsets[i]=new Cluster();
        //set the parent element for each of the subset elements
        for (int v = 0; v < vertices; ++v)
        {
            subsets[v].parent = new Node(v);
            subsets[v].subsetRank = 0;
            weightCount.put(v, 1);
        }
        i = 0;
        while (e < vertices - 1)
        {
            GraphEdge newEdge = new GraphEdge();
            if(i+1>=edgeArray.length)
                break;
            newEdge = edgeArray[i++];
            Node sourceRoot = findNode(subsets, newEdge.source);
            Node destinationRoot = findNode(subsets, newEdge.destination);
            int maxWeight=Math.max(weightCount.get(newEdge.source.nodeValue),weightCount.get(newEdge.destination.nodeValue));
            
            
            //CMST weight evaluation condition
            // maxWeight<clusterCapacity || newEdge.source.nodeValue==0
            //add the edge to the output if the max weight of the node is less
            //than the cluster capacity ,excluding the weight of the source node
            if (sourceRoot.nodeValue != destinationRoot.nodeValue && (maxWeight<clusterCapacity || newEdge.source.nodeValue==0))
            {
                int newWeight=maxWeight+1;
                int sourceVal=newEdge.source.nodeValue;
                int destVal=newEdge.destination.nodeValue;
                if(elementList.containsKey(sourceVal))
                {
                    ArrayList<Integer> aList=elementList.get(sourceVal);
                    aList.add(destVal);
                    elementList.put(sourceVal, aList);
                }
                else{
                    ArrayList<Integer> aList=new ArrayList<>();
                    aList.add(destVal);
                    elementList.put(sourceVal, aList);
                }
                ArrayList<Integer> aList=elementList.get(sourceVal);
                weightCount.put(sourceVal, newWeight);
                for (int j = 0; j < aList.size(); j++) {
                    weightCount.put(aList.get(j), newWeight);
                }
                result[e] = newEdge;
                e++;
                //perform the union of the subsets between the source and destination
                performUnion(subsets, sourceRoot, destinationRoot);
            }
        }
 
        System.out.println("Following are the edges in the constructed MST");
        int totalCost=0;
        for (i = 0; i < e; ++i){
            System.out.println("<---Source---> "+result[i].source.nodeValue+" <--destination--> "+result[i].destination.nodeValue+" <===Weight==> "+
                               result[i].edgeWeight);
            totalCost+=result[i].edgeWeight;
        }
        System.out.println("Total Cost Of MST is "+ totalCost);
        
    }
 
    public static void main (String[] args)
    {
        int V = 6; //number of vertices
        int E = 15; //number of edges  
        int[][] inputMatrix=new int[][]{{0,5,6,9,12,15},
                                        {0,0,4,3,8,10},
                                        {0,0,0,8,5,12},
                                        {0,0,0,0,6,6},
                                        {0,0,0,0,0,7},
                                        {0,0,0,0,0,0}};   
        //adjacency matrix
        ModifiedKruskalsAlgo graph = new ModifiedKruskalsAlgo(V, E);//call the constructor to the Graph
        Set<String> set=new HashSet<>();
        //create a set to avoid duplicates
        int count=0;
        for (int i = 0; i < inputMatrix.length; i++) {
            for (int j = 0; j < inputMatrix[0].length; j++) {
                if(inputMatrix[i][j]==0)
                    continue;
                String srcDest=i+"/"+j;
                String destSrc=j+"/"+i;
                if(!set.contains(srcDest) && !set.contains(destSrc))
                {
                    //create new edges between source and destination according to the adjacency matrix
                    //also allot the weights to those edges
                    graph.edgeArray[count].source=new Node(i);
                    graph.edgeArray[count].destination=new Node(j);
                    graph.edgeArray[count].edgeWeight=inputMatrix[i][j];
                    set.add(srcDest);
                    count++;
                }
            }
        } 
        //set W or cluster capacity to 3
        graph.clusterCapacity=3;
        //run the algorithm
        graph.KruskalMST();
    }
}