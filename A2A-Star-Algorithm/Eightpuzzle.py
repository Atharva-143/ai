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


def heuristic(state, goal):

    count = 0

    for i in range(3):

        for j in range(3):

            if state[i][j] != 0 and state[i][j] != goal[i][j]:

                count += 1

    return count


def copy_state(state):

    return [row[:] for row in state]


def next_states(state):

    states = []

    x = 0
    y = 0

    for i in range(3):

        for j in range(3):

            if state[i][j] == 0:

                x = i
                y = j

    moves = [
        [1, 0],
        [-1, 0],
        [0, 1],
        [0, -1]
    ]

    for move in moves:

        nx = x + move[0]
        ny = y + move[1]

        if 0 <= nx < 3 and 0 <= ny < 3:

            temp = copy_state(state)

            temp[x][y] = temp[nx][ny]

            temp[nx][ny] = 0

            states.append(temp)

    return states


def print_state(state):

    for row in state:

        for value in row:

            print(value, end=" ")

        print()

    print("-----")


def print_solution(node):

    if node is None:

        return

    print_solution(node.parent)

    print_state(node.state)


def solve(start, goal):

    pq = []

    visited = set()

    heapq.heappush(
        pq,
        Node(start, 0, heuristic(start, goal), None)
    )

    while pq:

        curr = heapq.heappop(pq)

        if curr.state == goal:

            print_solution(curr)

            print("Steps:", curr.g)

            return

        visited.add(str(curr.state))

        for next_state in next_states(curr.state):

            if str(next_state) not in visited:

                heapq.heappush(
                    pq,
                    Node(
                        next_state,
                        curr.g + 1,
                        heuristic(next_state, goal),
                        curr
                    )
                )

    print("No Solution")


# Main Program

start = [
    [2, 8, 3],
    [1, 6, 4],
    [7, 0, 5]
]

goal = [
    [1, 2, 3],
    [8, 0, 4],
    [7, 6, 5]
]

solve(start, goal)