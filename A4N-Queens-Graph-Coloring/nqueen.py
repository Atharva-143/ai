class NQueens:

    def __init__(self, n):
        self.N = n
        self.board = [0] * n
        self.cols = [False] * n
        self.diag1 = [False] * (2 * n - 1)
        self.diag2 = [False] * (2 * n - 1)

    def solve(self):
        if not self.place_queen(0):
            print("No solution exists")

    def place_queen(self, row):

        if row == self.N:
            self.print_board()
            return True

        for col in range(self.N):

            if (self.cols[col] or
                self.diag1[row - col + self.N - 1] or
                self.diag2[row + col]):
                continue

            # Place queen
            self.board[row] = col
            self.cols[col] = True
            self.diag1[row - col + self.N - 1] = True
            self.diag2[row + col] = True

            if self.place_queen(row + 1):
                return True

            self.cols[col] = False
            self.diag1[row - col + self.N - 1] = False
            self.diag2[row + col] = False

        return False

    def print_board(self):

        for i in range(self.N):
            for j in range(self.N):

                if self.board[i] == j:
                    print("Q", end=" ")
                else:
                    print(".", end=" ")

            print()


# Main Program
q = NQueens(4)
q.solve()