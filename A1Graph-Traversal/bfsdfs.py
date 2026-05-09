from collections import deque


class GraphTraversal:

    def __init__(self, vertices):

        self.vertices = vertices
        self.adj_list = [[] for _ in range(vertices)]

    def add_edge(self, u, v):

        self.adj_list[u].append(v)
        self.adj_list[v].append(u)

    def dfs_recursive(self, node, visited):

        visited[node] = True
        print(node, end=" ")

        for neighbor in self.adj_list[node]:

            if not visited[neighbor]:
                self.dfs_recursive(neighbor, visited)

    def bfs_recursive(self, queue, visited):

        if not queue:
            return

        node = queue.popleft()

        print(node, end=" ")

        for neighbor in self.adj_list[node]:

            if not visited[neighbor]:

                visited[neighbor] = True
                queue.append(neighbor)

        self.bfs_recursive(queue, visited)


# Main Program
graph = GraphTraversal(6)

graph.add_edge(0, 1)
graph.add_edge(0, 2)
graph.add_edge(1, 3)
graph.add_edge(2, 4)
graph.add_edge(3, 5)

print("DFS Traversal:")

visited = [False] * 6

graph.dfs_recursive(0, visited)

print("\n\nBFS Traversal:")

visited = [False] * 6

queue = deque()

visited[0] = True

queue.append(0)

graph.bfs_recursive(queue, visited)