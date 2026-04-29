import java.util.*;

public class GraphTraversal 
{

    private int vertices; 
    private ArrayList<ArrayList<Integer>> adjList; 

    
    public GraphTraversal(int vertices) 
    {
        this.vertices = vertices;
        adjList = new ArrayList<>();

        for (int i = 0; i < vertices; i++) 
        {
            adjList.add(new ArrayList<>());
        }
    }

    
    public void addEdge(int u, int v) 
    {
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    
    public void dfsRecursive(int node, boolean[] visited) 
    {
        visited[node] = true;
        System.out.print(node + " ");

        
        for (int neighbor : adjList.get(node)) 
        {
            if (!visited[neighbor]) 
            {
                dfsRecursive(neighbor, visited);
            }
        }
    }

    
    public void bfsRecursive(Queue<Integer> queue, boolean[] visited) 
    {
        if (queue.isEmpty()) 
        {
            return;
        }

        int node = queue.poll();
        System.out.print(node + " ");

        for (int neighbor : adjList.get(node)) 
        {
            if (!visited[neighbor]) 
            {
                visited[neighbor] = true;
                queue.add(neighbor);
            }
        }

      
        bfsRecursive(queue, visited);
    }

 
    public static void main(String[] args) 
    {

       
        GraphTraversal graph = new GraphTraversal(6);

       
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);

        
        System.out.println("DFS Traversal:");
        boolean[] visited = new boolean[6];
        graph.dfsRecursive(0, visited);

        
        System.out.println("\n\nBFS Traversal:");
        visited = new boolean[6];
        Queue<Integer> queue = new LinkedList<>();
        visited[0] = true;
        queue.add(0);
        graph.bfsRecursive(queue, visited);
    }
}

