package Multiplayer;

public class Color {
    public static final String RESET = "\033[0m";
    public enum Regular {
        BLACK("\033[0;30m"),
        RED("\033[0;31m"),
        GREEN("\033[0;32m"),
        YELLOW("\033[0;33m"),
        BLUE("\033[0;34m"),
        PURPLE("\033[0;35m"),
        CYAN("\033[0;36m"),
        WHITE("\033[0;37m");

        final String value;
        Regular(String value){
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }

    }

    public enum Underline{
        BLACK("\033[4;30m"),
        RED("\033[4;31m"),
        GREEN("\033[4;32m"),
        YELLOW("\033[4;33m"),
        BLUE("\033[4;34m"),
        PURPLE("\033[4;35m"),
        CYAN("\033[4;36m"),
        WHITE("\033[4;37m");

        final String value;
        Underline(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public enum Bold {
        BLACK("\033[1;30m"),
        RED("\033[1;31m"),
        GREEN("\033[1;32m"),
        YELLOW("\033[1;33m"),
        BLUE("\033[1;34m"),
        PURPLE("\033[1;35m"),
        CYAN("\033[1;36m"),
        WHITE("\033[1;37m");

        final String value;
        Bold(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

}
