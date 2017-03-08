import java.util.Scanner;

import static java.lang.System.exit;
import static java.lang.System.setOut;

/**
 * Created by Akshay Chandrashekhar Pandit on 3/8/2017.
 */
public class TicTacToe {
    private static Scanner scanner = new Scanner(System.in);
    private static int row,col;
    private static char[][] gameboard = new char[3][3];
    private static char turn = 'X';

    /*
    *   Main method
    */
    public static void main(String[] args) throws InterruptedException {
            gameBanner();
            try {
                initializeBoard();
            }catch (ArrayIndexOutOfBoundsException exception){
                System.out.println("Please choose between 1 to 3 only");
                initializeBoard();
            }
    }

    /*
    *   Game heading and other banner stuff for fun
    */
    private static void gameBanner() throws InterruptedException {
        System.out.println("===============================TIC-TAC-TOE==============================");
        System.out.println("Player X and Player O, Take your positions and brace yourselves!");
        System.out.println("It's time to decide who is X's and who is O's");
        Thread.sleep(4000);
        System.out.println("I hope the players have been decided and also their X's and O's...");
        Thread.sleep(1000);
        System.out.println("READY...");
        Thread.sleep(1000);
        System.out.println("SET...");
        Thread.sleep(1500);
        System.out.println("GOOOOOOOO...");
        Thread.sleep(1000);
        System.out.println("Player X's turn: ");
    }

    /*
    *   Game-board initialized
    */
    private static void initializeBoard(){
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                gameboard[i][j] = '*';
            }
        }
        //Print the initial game board and start playing
        printBoard();
        play();
    }

    /*
    *   Player advances in this block, alternate turns
    *   Player provides input in numbers for positioning
    */
    private static void play(){
        boolean playing = true;
        while (playing){
            System.out.println();
            row = scanner.nextInt() - 1;
            col = scanner.nextInt() - 1;

            //Check the occupied place and print particular message to correct the user
            if(gameboard[row][col] != '*'){
                System.out.println("The place is already occupied. Please choose the position wisely!");
                continue;
            }
            gameboard[row][col] = turn;

            if (gameOver(row,col)){
                playing = false;
                System.out.println("Game over! Player " + turn + " wins...");
                printBoard();
                exit(1);
            }

            printBoard();
            if (turn == 'X'){
                turn = 'O';
                System.out.println("Player " + turn + "'s turn: ");
            }else{
                turn = 'X';
                System.out.println("Player " + turn + "'s turn: ");
            }
        }
    }

    /*
    *   Print and record the steps on the board and display
    */
    private static void printBoard(){
        for (int i=0; i<3; i++){
            System.out.println();
            for (int j=0; j<3; j++){
                if (j == 0) {
                    System.out.print("|  ");
                }
                System.out.print(gameboard[i][j] + "  |  ");
            }
        }
    }

    /*
    *   Check the player advances for victory
    */
    private static boolean gameOver(int row_move, int col_move){
        //Check perpendicular victory
        if (gameboard[0][col_move] == gameboard[1][col_move] && gameboard[0][col_move] == gameboard[2][col_move]){
            return true;

        }else if (gameboard[row_move][0] == gameboard[row_move][1] && gameboard[row_move][0] == gameboard[row_move][2]){
            return true;

        //Check diagonal victory
        }else if (gameboard[0][0] == gameboard[1][1] && gameboard[0][0] == gameboard[2][2] && gameboard[1][1] != '*'){
            return true;

        }else if(gameboard[0][2] == gameboard[1][1] && gameboard[0][2] == gameboard[2][0] && gameboard[1][1] != '*'){
            return true;
        }

        return false;
    }
}
