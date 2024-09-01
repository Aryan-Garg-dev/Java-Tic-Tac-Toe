package Multiplayer;


import java.io.IOException;

public class Utility {
    public enum Symbol {
        CROSS('X'), CIRCLE('O');
        final char character;
        Symbol(char character){
            this.character = character;
        }
        public char symbol(){
            return character;
        }
        public Boolean isEquals(char ch){
            return this.character == ch;
        }
    }

    public static <T> boolean contains(T[] array, T element){
        for (T arrayElement: array){
            if (element.equals(arrayElement)) return true;
        }
        return false;
    }

    public static void clearConsole(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
