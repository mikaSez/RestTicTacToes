package info.mikasez.tictactoes.logic;

/**
 * Main game class possess the application logic
 */
public class Game {

    private int playerCount ;
    private boolean [] board;

    public Game(){
        playerCount = 2;
        board =  new boolean[9];
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public boolean[] getBoard() {
        return board;
    }

}
