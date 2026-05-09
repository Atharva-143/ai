import java.util.Scanner;

public class Main 
{

    
    static int[] selectionSort(int[] arr) 
    {
        int n = arr.length;

        System.out.println("Selection Sort Steps:");

        for (int i = 0; i < n; i++) 
        {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) 
            {
                if (arr[j] < arr[minIndex]) 
                {
                    minIndex = j;
                }
            }

            
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;

            System.out.print("Pass " + (i + 1) + ": ");

            for (int num : arr) 
            {
                System.out.print(num + " ");
            }

            System.out.println();
        }

        return arr;
    }

    
    static int primsMST(int[][] graph, int vertices) 
    {
        boolean[] selected = new boolean[vertices];

        selected[0] = true;

        int totalCost = 0;

        System.out.println("Edge \tWeight");

        for (int count = 0; count < vertices - 1; count++) 
        {
            int minimum = 999;
            int x = 0;
            int y = 0;

            for (int i = 0; i < vertices; i++) 
            {
                if (selected[i]) 
                {
                    for (int j = 0; j < vertices; j++) 
                    {
                        if (!selected[j] && graph[i][j] != 0) 
                        {
                            if (minimum > graph[i][j]) 
                            {
                                minimum = graph[i][j];
                                x = i;
                                y = j;
                            }
                        }
                    }
                }
            }

            System.out.println(x + " - " + y + "\t" + graph[x][y]);

            selected[y] = true;

            totalCost += graph[x][y];
        }

        System.out.println("Total MST Cost: " + totalCost);

        return totalCost;
    }

    // Main Function
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        while (true) 
        {
            System.out.println("\n=== MENU DRIVEN PROGRAM ===");
            System.out.println("1. Selection Sort");
            System.out.println("2. Prim's MST Algorithm");
            System.out.println("3. Exit");

            System.out.print("Enter your choice (1-3): ");

            int choice = sc.nextInt();

            if (choice == 1) 
            {
                System.out.print("Enter number of elements: ");

                int n = sc.nextInt();

                int[] arr = new int[n];

                for (int i = 0; i < n; i++) 
                {
                    System.out.print("Enter element " + (i + 1) + ": ");

                    arr[i] = sc.nextInt();
                }

                System.out.print("Unsorted array: ");

                for (int num : arr) 
                {
                    System.out.print(num + " ");
                }

                System.out.println();

                int[] sortedArr = selectionSort(arr);

                System.out.print("Final Sorted array: ");

                for (int num : sortedArr) 
                {
                    System.out.print(num + " ");
                }

                System.out.println();
            }

            else if (choice == 2) 
            {
                System.out.print("Enter number of vertices: ");

                int vertices = sc.nextInt();

                int[][] graph = new int[vertices][vertices];

                System.out.println("Enter adjacency matrix row by row (0 for no edge):");

                for (int i = 0; i < vertices; i++) 
                {
                    System.out.println("Row " + i + ":");

                    for (int j = 0; j < vertices; j++) 
                    {
                        graph[i][j] = sc.nextInt();
                    }
                }

                System.out.println("Input Graph:");

                for (int i = 0; i < vertices; i++) 
                {
                    for (int j = 0; j < vertices; j++) 
                    {
                        System.out.print(graph[i][j] + " ");
                    }

                    System.out.println();
                }

                System.out.println();

                primsMST(graph, vertices);
            }

            else if (choice == 3) 
            {
                System.out.println("Exiting...");
                break;
            }

            else 
            {
                System.out.println("Invalid choice! Try again.");
            }
        }

        sc.close();
    }
}