import java.util.Scanner;
public class GameLogic {
    boolean gameOver;
    Scanner scan = new Scanner(System.in);

    public void run(){
        gameOver = false;
        Board board = new Board(10, 12);
        String choice = "";

        System.out.println("Hello!");

        while (!gameOver && !choice.equalsIgnoreCase("x")){
            board.printBoard();
            System.out.println();
            System.out.println("Please input a square to click (normal x,y coordinates, separate with ,) or X to quit");

            choice = scan.nextLine();
            String[] temp = choice.split(",");
            int col = Integer.parseInt(temp[0]);
            int row = Integer.parseInt(temp[1]);

            while (row > board.getLength() || col > board.getLength2()){
                System.out.println("Input a valid coordinate! ");
                choice = scan.nextLine();
                temp = choice.split(",");
                col = Integer.parseInt(temp[0]);
                row = Integer.parseInt(temp[1]);
            }

            String str = board.click(row - 1,col - 1);
            if (str.equals("mine")){
                System.out.println("Oh you clicked a mine! :(");
                gameOver = true;
            }
        }
    }
}