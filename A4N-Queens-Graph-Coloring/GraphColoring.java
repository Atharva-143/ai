class GraphColoring 
{
    int V;
    int[][] graph;
    int[] color;

    GraphColoring(int[][] g) 
    {
        graph = g;
        V = g.length;
        color = new int[V];
    }

    boolean isSafe(int node, int c) 
    {
        for (int i = 0; i < V; i++) 
        {
            if (graph[node][i] == 1 && color[i] == c) 
            {
                return false;
            }
        }
        return true;
    }

    boolean solve(int node, int m) 
    {
        if (node == V) 
        {
            printSolution();
            return true;
        }

        for (int c = 1; c <= m; c++) 
        {

            if (!isSafe(node, c)) 
            {
                continue;
            }

            color[node] = c;

            if (solve(node + 1, m)) 
            {
                return true;
            }

            color[node] = 0;
        }

        return false;
    }

    void printSolution() 
    {
        System.out.println("Vertex Colors:");
        for (int i = 0; i < V; i++) 
        {
            System.out.println("Vertex " + i + " -> Color " + color[i]);
        }
    }

    public static void main(String[] args) 
    {
        int[][] g = 
        {
            {0,1,1,1},
            {1,0,1,0},
            {1,1,0,1},
            {1,0,1,0}
        };

        int m = 3;

        GraphColoring obj = new GraphColoring(g);

        if (!obj.solve(0, m)) 
        {
            System.out.println("No solution exists");
        }
    }
}