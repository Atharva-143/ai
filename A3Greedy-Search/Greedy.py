import sys

def selection_sort(arr):
    n = len(arr)
    print("Selection Sort Steps:")
    for i in range(n):
        min_index = i
        for j in range(i + 1, n):
            if arr[j] < arr[min_index]:
                min_index = j
        
        arr[i], arr[min_index] = arr[min_index], arr[i]
        print(f"Pass {i+1}: {arr}")
    return arr

def prims_mst(graph, vertices):
    selected = [False] * vertices
    selected[0] = True
    total_cost = 0
    
    print("Edge \tWeight")
    for _ in range(vertices - 1):
        minimum = sys.maxsize
        x = 0
        y = 0
        
        for i in range(vertices):
            if selected[i]:
                for j in range(vertices):
                    if not selected[j] and graph[i][j]:
                        if minimum > graph[i][j]:
                            minimum = graph[i][j]
                            x = i
                            y = j
        
        print(f"{x} - {y}\t{graph[x][y]}")
        selected[y] = True
        total_cost += graph[x][y]
    
    print(f"Total MST Cost: {total_cost}")
    return total_cost

def main():
    while True:
        print("\n=== MENU DRIVEN PROGRAM ===")
        print("1. Selection Sort")
        print("2. Prim's MST Algorithm")
        print("3. Exit")
        
        choice = input("Enter your choice (1-3): ")
        
        if choice == '1':
            n = int(input("Enter number of elements: "))
            arr = []
            for i in range(n):
                arr.append(int(input(f"Enter element {i+1}: ")))
            
            print("Unsorted array:", arr)
            sorted_arr = selection_sort(arr.copy())
            print("Final Sorted array:", sorted_arr)
        
        elif choice == '2':
            vertices = int(input("Enter number of vertices: "))
            graph = []
            print("Enter adjacency matrix row by row (0 for no edge):")
            for i in range(vertices):
                row = list(map(int, input(f"Row {i}: ").split()))
                graph.append(row)
            
            print("Input Graph:")
            for row in graph:
                print(row)
            print()
            
            prims_mst(graph, vertices)
        
        elif choice == '3':
            print("Exiting...")
            break
        
        else:
            print("Invalid choice! Try again.")

if __name__ == "__main__":
    main()
