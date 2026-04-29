import java.util.*;

class AStarEasy 
{

    static class Node implements Comparable<Node> 
    {
        String state;
        int g, h;
        Node parent;

        Node(String s, int g, int h, Node p) 
        {
            state = s;
            this.g = g;
            this.h = h;
            parent = p;
        }

        int f() 
        {
            return g + h;
        }

        public int compareTo(Node n) 
        {
            return this.f() - n.f();
        }
    }

    static Map<String, List<String>> graph = new HashMap<>();
    static Map<String, Integer> cost = new HashMap<>();

    static void addEdge(String a, String b, int c) 
    {
        graph.putIfAbsent(a, new ArrayList<>());
        graph.get(a).add(b);
        cost.put(a + b, c);
    }

    static void aStar(String start, String goal,
                      Map<String, Integer> hVal) 
    {
        System.out.println("Start Node: " + start);
        System.out.println("Goal Node : " + goal);
        System.out.println();

        PriorityQueue<Node> open = new PriorityQueue<>();
        Set<String> closed = new HashSet<>();

        open.add(new Node(start, 0, hVal.get(start), null));

        while (!open.isEmpty()) 
        {

            Node cur = open.poll();

            if (cur.state.equals(goal)) 
            {
                System.out.print("Path Found: ");
                print(cur);
                System.out.println("\nTotal Cost: " + cur.g);
                return;
            }

            closed.add(cur.state);

            for (String next : graph.getOrDefault(cur.state, new ArrayList<>())) 
            {
                if (!closed.contains(next)) 
                {
                    int g = cur.g + cost.get(cur.state + next);
                    int h = hVal.get(next);
                    open.add(new Node(next, g, h, cur));
                }
            }
        }

        System.out.println("No Path Found");
    }

    static void print(Node n) 
    {
        if (n == null) return;
        print(n.parent);
        System.out.print(n.state + " ");
    }

    public static void main(String[] args) 
    {

        addEdge("A", "B", 1);
        addEdge("A", "C", 2);
        addEdge("B", "D", 3);
        addEdge("C", "E", 5);
        addEdge("D", "F", 2);
        addEdge("F", "G", 1);
        addEdge("E", "G", 3);

        Map<String, Integer> h = Map.of(
            "A", 6,
            "B", 5,
            "C", 4,
            "D", 3,
            "E", 3,
            "F", 1,
            "G", 0
        );

        aStar("A", "G", h);
    }
}

