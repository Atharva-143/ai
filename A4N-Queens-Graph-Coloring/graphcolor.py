class GraphColoring:

    def __init__(self, g):
        self.graph = g
        self.V = len(g)
        self.color = [0] * self.V

    def is_safe(self, node, c):

        for i in range(self.V):

            if self.graph[node][i] == 1 and self.color[i] == c:
                return False

        return True

    def solve(self, node, m):

        if node == self.V:
            self.print_solution()
            return True

        for c in range(1, m + 1):

            if not self.is_safe(node, c):
                continue

            self.color[node] = c

            if self.solve(node + 1, m):
                return True

            self.color[node] = 0

        return False

    def print_solution(self):

        print("Vertex Colors:")

        for i in range(self.V):
            print("Vertex", i, "-> Color", self.color[i])


# Main Program
g = [
    [0, 1, 1, 1],
    [1, 0, 1, 0],
    [1, 1, 0, 1],
    [1, 0, 1, 0]
]

m = 3

obj = GraphColoring(g)

if not obj.solve(0, m):
    print("No solution exists")