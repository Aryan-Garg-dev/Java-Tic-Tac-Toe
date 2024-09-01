package Multiplayer;

import java.util.Scanner;

/* dist
javac -d ../dist ./src/Multiplayer/*.java
cd ./dist
java Multiplayer.Main
*/


public class Main {
    public static void run(Game game){
        while (!game.isGameOver){
            Utility.clearConsole();
            game.display();
            if (game.player1.isOnMove) System.out.println(Color.Bold.BLUE+"Player 1"+Color.RESET);
            else System.out.println(Color.Bold.BLUE+"Player 2"+Color.RESET);
            System.out.println(Color.Regular.BLUE+"Enter yor move?"+Color.RESET);
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
            if (game.player1.isOnMove){
                win = game.checkWin(game.player1);
            } else {
                win = game.checkWin(game.player2);
            }
            if (win){
                game.isGameOver = true;
                if (game.player1.hasWon){
                    System.out.println("Player 1 has won!!!");
                } else {
                    System.out.println("Player 2 has won!!!");
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

        System.out.print("Player 1: choose your symbol ( 'X' / 'O' ):");
        Scanner sc = new Scanner(System.in);
        Utility.Symbol player1Symbol;
        Utility.Symbol player2Symbol;
        char ch = sc.nextLine().charAt(0);
        if (Utility.Symbol.CIRCLE.isEquals(Character.toUpperCase(ch))){
            player1Symbol = Utility.Symbol.CIRCLE;
            player2Symbol = Utility.Symbol.CROSS;
        } else {
            player1Symbol = Utility.Symbol.CROSS;
            player2Symbol = Utility.Symbol.CIRCLE;
        }
        Player player1 = new Player(player1Symbol, true);
        Player player2 = new Player(player2Symbol, false);
        Game game = new Game(player1, player2);

        boolean exitGame = false;

        while(!exitGame){
            run(game);
            if (game.isGameOver){
                System.out.print("Do you want to continue playing? ( Y / N ):");
                char response = sc.nextLine().charAt(0);
                if (Character.toUpperCase(response) != 'Y'){
                    exitGame = true;
                } else {
                    if (player1.hasWon) game = new Game(player1, player2);
                    else game = new Game(player2, player1);
                }
            }
        }
        // other details
        System.out.println();



    }
}
