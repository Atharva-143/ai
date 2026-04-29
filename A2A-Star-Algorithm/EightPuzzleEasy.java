import java.util.*;

public class EightPuzzleEasy 
{

   
    static class Node 
    {
        int[][] state;
        int g;         
        int h;          
        Node parent;

        Node(int[][] s, int g, int h, Node p) 
        {
            this.state = s;
            this.g = g;
            this.h = h;
            this.parent = p;
        }

        int f() 
        {
            return g + h;
        }
    }


    static int heuristic(int[][] s, int[][] goal) 
    {
        int count = 0;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (s[i][j] != 0 && s[i][j] != goal[i][j])
                    count++;
        return count;
    }

    static void solve(int[][] start, int[][] goal) 
    {

        PriorityQueue<Node> pq = new PriorityQueue<>(
                (a, b) -> a.f() - b.f());

        Set<String> visited = new HashSet<>();

        pq.add(new Node(start, 0, heuristic(start, goal), null));

        while (!pq.isEmpty()) 
        {

            Node curr = pq.poll();

            if (Arrays.deepEquals(curr.state, goal)) 
            {
                printSolution(curr);
                System.out.println("Steps: " + curr.g);
                return;
            }

            visited.add(Arrays.deepToString(curr.state));

            for (int[][] next : nextStates(curr.state)) 
            {

                if (!visited.contains(Arrays.deepToString(next))) 
                {
                    pq.add(new Node(
                            next,
                            curr.g + 1,
                            heuristic(next, goal),
                            curr));
                }
            }
        }

        System.out.println("No Solution");
    }


    static List<int[][]> nextStates(int[][] s) 
    {
        List<int[][]> list = new ArrayList<>();

        int x = 0, y = 0;


        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (s[i][j] == 0) 
                {
                    x = i;
                    y = j;
                }

        int[][] moves = {{1,0},{-1,0},{0,1},{0,-1}};

        for (int[] m : moves) 
        {
            int nx = x + m[0];
            int ny = y + m[1];

            if (nx >= 0 && ny >= 0 && nx < 3 && ny < 3) 
            {
                int[][] copy = copy(s);
                copy[x][y] = copy[nx][ny];
                copy[nx][ny] = 0;
                list.add(copy);
            }
        }
        return list;
    }

    static int[][] copy(int[][] s) 
    {
        int[][] c = new int[3][3];
        for (int i = 0; i < 3; i++)
            c[i] = s[i].clone();
        return c;
    }

    static void printSolution(Node n) 
    {
        if (n == null) return;
        printSolution(n.parent);
        print(n.state);
        System.out.println();
    }

    static void print(int[][] s) 
    {
        for (int[] r : s) 
        {
            for (int v : r)
                System.out.print(v + " ");
            System.out.println();
        }
        System.out.println("-----");
    }

    public static void main(String[] args) 
    {

        int[][] start = 
        {
                {2, 8, 3},
                {1, 6, 4},
                {7, 0, 5}
        };

        int[][] goal = 
        {
                {1, 2, 3},
                {8, 0, 4},
                {7, 6, 5}
        };

        solve(start, goal);
    }
}

