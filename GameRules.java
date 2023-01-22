public class GameRules {

    public boolean checkWinner(char player, char[][] board) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] == player && board[i][j + 1] == player && board[i][j + 2] == player && board[i][j + 3] == player) {
                    return true;
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                if (board[i][j] == player && board[i + 1][j] == player && board[i + 2][j] == player && board[i + 3][j] == player) {
                    return true;
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] == player && board[i + 1][j + 1] == player && board[i + 2][j + 2] == player && board[i + 3][j + 3] == player)
                    return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 3; j < 7; j++) {
                if (board[i][j] == player && board[i + 1][j - 1] == player && board[i + 2][j - 2] == player && board[i + 3][j - 3] == player)
                    return true;
            }
        }
        return false;
    }

    public boolean isFull(int[] lastInColumn) {
        for (int i = 0; i < 7; i++) {
            if (lastInColumn[i] >= 0)
                return false;
        }
        return true;
    }

    public boolean isLegal(int column, int rows, int columns, int[] lastInColumn)
    {
        if (column < 0 || column > 6) {
            System.out.println("you can't choose this column, try again");
            return false;
        }
        if (lastInColumn[column] == -1) {
            if (isFull(lastInColumn) == true)
                return false;
            System.out.println("this column is full, try again");
            return false; //take another turn
        }
        return true;
    }

    public int addCoin(int numOfColumn, int turn, char[][] board, int[] lastInColumn) {
        char player;
        if (turn % 2 == 0)
            player = 'B';
        else
            player = 'R';
        board[lastInColumn[numOfColumn]][numOfColumn] = player;
        lastInColumn[numOfColumn]--;
        if (checkWinner(player, board) == true) {
            System.out.println("player " + player + " wins!");
            return 1; //game ends
        }
        return 2; //game continues, no one won yet
    }
}
