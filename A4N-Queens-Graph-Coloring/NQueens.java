class NQueens 
{
    int N;
    int[] board;                 
    boolean[] cols;              
    boolean[] diag1;             
    boolean[] diag2;             

    NQueens(int n) 
    {
        N = n;
        board = new int[N];
        cols = new boolean[N];
        diag1 = new boolean[2 * N - 1];
        diag2 = new boolean[2 * N - 1];
    }

    void solve() 
    {
        if (!placeQueen(0)) 
        {
            System.out.println("No solution exists");
        }
    }

    boolean placeQueen(int row) 
    {

        if (row == N) 
        {
            printBoard();
            return true;
        }

        for (int col = 0; col < N; col++) 
        {

            if (cols[col] || diag1[row - col + N - 1] || diag2[row + col]) 
            {
                continue;
            }

            
            board[row] = col;
            cols[col] = true;
            diag1[row - col + N - 1] = true;
            diag2[row + col] = true;

      
            if (placeQueen(row + 1)) 
            {
                return true;
            }


            cols[col] = false;
            diag1[row - col + N - 1] = false;
            diag2[row + col] = false;
        }

        return false;
    }

    void printBoard() 
    {
        for (int i = 0; i < N; i++) 
        {
            for (int j = 0; j < N; j++) 
            {
                if (board[i] == j) System.out.print("Q ");
                else System.out.print(". ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) 
    {
        NQueens q = new NQueens(4);
        q.solve();
    }
}