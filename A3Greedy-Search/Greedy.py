import sys

def selection_sort(arr):
    n = len(arr)

    print("\nSelection Sort Steps:")

    for i in range(n):
        min_index = i

        for j in range(i + 1, n):
            if arr[j] < arr[min_index]:
                min_index = j

        arr[i], arr[min_index] = arr[min_index], arr[i]

        print(f"Pass {i + 1}: ", end="")

        for num in arr:
            print(num, end=" ")

        print()

    return arr


def prims_mst(graph, vertices):

    selected = [False] * vertices

    selected[0] = True

    total_cost = 0

    print("\nEdges in MST:")
    print("Edge \tWeight")

    for _ in range(vertices - 1):

        minimum = sys.maxsize
        x = 0
        y = 0

        for i in range(vertices):

            if selected[i]:

                for j in range(vertices):

                    if not selected[j] and graph[i][j] != 0:

                        if graph[i][j] < minimum:

                            minimum = graph[i][j]
                            x = i
                            y = j

        print(f"{x} - {y}\t{graph[x][y]}")

        selected[y] = True

        total_cost += graph[x][y]

    print("Total MST Cost:", total_cost)


while True:

    print("\n========== MENU ==========")
    print("1. Selection Sort")
    print("2. Prim's MST")
    print("3. Exit")

    choice = int(input("Enter your choice: "))

    if choice == 1:

        n = int(input("Enter number of elements: "))

        arr = []

        for i in range(n):
            value = int(input(f"Enter element {i + 1}: "))
            arr.append(value)

        print("Unsorted array:", arr)

        sorted_arr = selection_sort(arr)

        print("Final Sorted Array:", sorted_arr)

    elif choice == 2:

        vertices = 4

        graph = [
            [0, 2, 5, 6],
            [2, 0, 3, 0],
            [5, 3, 0, 1],
            [6, 0, 1, 0]
        ]

        print("\nGraph Adjacency Matrix:")

        for row in graph:
            print(row)

        prims_mst(graph, vertices)

    elif choice == 3:

        print("Exiting...")
        break

    else:

        print("Invalid choice!")
