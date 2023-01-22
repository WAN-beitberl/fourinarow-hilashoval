import java.util.*;

public class Main {
    public static void main(String[] args) {
        FourInARow board = new FourInARow();
        GameRules gameRules = new GameRules();
        Scanner input = new Scanner(System.in);
        int column;

        int turn = 0;
        boolean playing = true;
        while (playing) {
            board.PrintBoard();
            System.out.print("Enter column: ");
            column = input.nextInt();
            int i = gameRules.addCoin(column, turn, board.getBoard(), board.getLastInColumn());
            if (i == 1) {
                playing = false;
                System.out.println("\ngame over");
            }
            if(i==3)
            {
                playing = false;
                System.out.println("\nboard is full, game over");
            }
            if(i == 0)
                turn--;
            turn++;
        }
    }
}