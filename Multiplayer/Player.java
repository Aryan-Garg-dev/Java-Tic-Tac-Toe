package Multiplayer;

import java.util.ArrayList;
import java.util.List;

public class Player {

    public Utility.Symbol type;
    public boolean isOnMove = false;
    public int score;
    public boolean hasWon;
    public List<Integer> moves;

    Player(Utility.Symbol type, boolean isOnMove){
        this.isOnMove = isOnMove;
        score = 0;
        hasWon = false;
        this.type = type;
        moves = new ArrayList<>();
    }

    public void resetMoves(){
        moves.clear();
        hasWon = false;
    }
}
