public class FourInARow {
    private char board[][] = new char[6][7];
    private int lastInColumn[] = new int[7];// the first row in each column that's empty

    public int[] getLastInColumn()
    {
        return this.lastInColumn;
    }

    public char[][] getBoard()
    {
        return this.board;
    }
    public FourInARow() {
        for (int w = 0; w < 6; w += 1) {
            for (int h = 0; h < 7; h += 1) {
                this.board[w][h] = '.';
            }
        }
        for (int i = 0; i < 7; i++) {
            this.lastInColumn[i] = 5;// last row in each column
        }
    }

    public void PrintBoard() {
        for (int w = 0; w < 6; w += 1) {
            for (int h = 0; h < 7; h += 1) {
                System.out.print(this.board[w][h]);
            }
            System.out.println();
        }
        System.out.println();
    }
}


