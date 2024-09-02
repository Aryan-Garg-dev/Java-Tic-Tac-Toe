package Multiplayer;

import java.util.Scanner;

/* dist
javac -d ./dist ./src/Multiplayer/*.java
cd ./dist
java Multiplayer.Main
*/


public class Main {
    public static void run(Game game){
        while (!game.isGameOver){
            if (game.cross.isOnMove) System.out.println(Color.Bold.BLUE+"Player X"+Color.RESET);
            else System.out.println(Color.Bold.BLUE+"Player O"+Color.RESET);
            System.out.println(Color.Regular.BLUE+"Enter your move?"+Color.RESET);
            Scanner sc = new Scanner(System.in);
            int move = sc.nextInt();
            while (!game.isValidMove(move)){
                System.out.println("Invalid Move!!! Try again");
                move = sc.nextInt();

            }
            game.updateBoard(move);
            Utility.clearConsole();
            game.display();
            boolean win;
            if (game.cross.isOnMove){
                win = game.checkWin(game.cross);
            } else {
                win = game.checkWin(game.circle);
            }
            if (win){
                game.isGameOver = true;
                if (game.cross.hasWon){
                    System.out.println("Player X has won!!!");
                } else {
                    System.out.println("Player O has won!!!");
                }
                break;
            } else {
                if (!game.isMovesLeft()){
                    System.out.println("There's a draw!");
                    game.isGameOver = true;
                    break;
                } else game.switchMoves();
            }
        }

    }
    public static void main(String[] args) {
        Utility.clearConsole();
        System.out.println(Color.Underline.BLUE+"Welcome To The Tic Tac Toe World"+Color.RESET);

        Player circle = new Player(Utility.Symbol.CIRCLE, false);
        Player cross = new Player(Utility.Symbol.CROSS, true);
        Game game = new Game(cross, circle);

        Scanner sc = new Scanner(System.in);
        boolean exitGame = false;

        while(!exitGame){
            game.display();
            run(game);
            if (game.isGameOver){
                System.out.print("Do you want to continue playing? ( Y / N ):");
                char response = sc.nextLine().charAt(0);
                if (Character.toUpperCase(response) != 'Y'){
                    exitGame = true;
                } else {
                    cross.resetMoves();
                    circle.resetMoves();
                    if (cross.hasWon) game = new Game(cross, circle);
                    else game = new Game(circle, cross);
                    Utility.clearConsole();
                }
            }
        }
        // other details
        System.out.println();



    }
}
