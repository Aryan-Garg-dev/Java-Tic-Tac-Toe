package Multiplayer;

import java.util.Scanner;

public class Game {
    private char[][] board;
    private static final int[][] WinningCombinations = {
        {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, //Row
        {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, //Column
        {0, 4, 8}, {2, 4, 6}
    };

    public Player cross;
    public Player circle;

    public static int gamesPlayed = 0;
    public boolean isGameOver;

    Game(Player player1, Player player2){
        this.cross = player1;
        this.circle = player2;
        board = new char[3][3];
        isGameOver = false;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                board[i][j] = String.valueOf(i*3+j).charAt(0);
            }
        }
    }

    private void putPieces(int r, int c){
        if (Character.isDigit(board[r][c])){
            System.out.printf("%s%c%s", Color.Regular.WHITE, board[r][c], Color.RESET);
        } else if (Utility.Symbol.CROSS.isEquals(board[r][c])){
            System.out.printf("%s%c%s", Color.Regular.RED, board[r][c], Color.RESET);
        } else {
            System.out.printf("%s%c%s", Color.Regular.GREEN, board[r][c], Color.RESET);
        }
    }

    public void display(){
        System.out.println(Color.Bold.WHITE+"#-----------#"+Color.RESET);
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                System.out.print(Color.Bold.WHITE+"| "+Color.RESET);
                putPieces(i, j);
                System.out.print(" ");
            }
            System.out.print(Color.Bold.WHITE+"|\n"+Color.RESET);
            if (i!=2){
                System.out.println(Color.Regular.WHITE+"|---+---+---|"+Color.RESET);
            }
        }
        System.out.println(Color.Bold.WHITE+"#-----------#"+Color.RESET);
    }

    public boolean isMovesLeft(){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (Character.isDigit(board[i][j])){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkWin(Player player){
        boolean hasWon = false;
        for (int[] combination: WinningCombinations){
            for (int position: combination){
                if (Utility.contains(player.moves.toArray(), position)){
                    hasWon = true;
                } else {
                    hasWon = false;
                    break;
                }
            }
            if (hasWon) break;
        }
        player.hasWon = hasWon;
        return hasWon;
    }

    public boolean isValidMove(int move){
        if (move < 0 || move > 8) return false;
        return Character.isDigit(board[move/3][move%3]);
    }

    public void switchMoves(){
        if (cross.isOnMove){
            circle.isOnMove = true;
            cross.isOnMove = false;
        } else {
            cross.isOnMove = true;
            circle.isOnMove = false;
        }
    }

    public void updateBoard(int move){
        Utility.Symbol moveSymbol = cross.isOnMove ? cross.type : circle.type;
        int r = move / 3;
        int c = move % 3;
        if (isValidMove(move)){
            board[r][c] = moveSymbol.symbol();
            if (cross.isOnMove) cross.moves.add(r*3+c);
            else circle.moves.add(r*3+c);
        }
    }
}
