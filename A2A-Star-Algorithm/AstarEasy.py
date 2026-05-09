import heapq


class Node:

    def __init__(self, state, g, h, parent):

        self.state = state
        self.g = g
        self.h = h
        self.parent = parent

    def f(self):
        return self.g + self.h

    def __lt__(self, other):
        return self.f() < other.f()


graph = {}
cost = {}


def add_edge(a, b, c):

    if a not in graph:
        graph[a] = []

    graph[a].append(b)

    cost[a + b] = c


def print_path(node):

    if node is None:
        return

    print_path(node.parent)

    print(node.state, end=" ")


def a_star(start, goal, h_val):

    print("Start Node:", start)
    print("Goal Node :", goal)
    print()

    open_list = []

    closed = set()

    heapq.heappush(open_list,
                   Node(start, 0, h_val[start], None))

    while open_list:

        cur = heapq.heappop(open_list)

        if cur.state == goal:

            print("Path Found:", end=" ")

            print_path(cur)

            print("\nTotal Cost:", cur.g)

            return

        closed.add(cur.state)

        for next_node in graph.get(cur.state, []):

            if next_node not in closed:

                g = cur.g + cost[cur.state + next_node]

                h = h_val[next_node]

                heapq.heappush(
                    open_list,
                    Node(next_node, g, h, cur)
                )

    print("No Path Found")


# Main Program

add_edge("A", "B", 1)
add_edge("A", "C", 2)
add_edge("B", "D", 3)
add_edge("C", "E", 5)
add_edge("D", "F", 2)
add_edge("F", "G", 1)
add_edge("E", "G", 3)

h = {
    "A": 6,
    "B": 5,
    "C": 4,
    "D": 3,
    "E": 3,
    "F": 1,
    "G": 0
}

a_star("A", "G", h)