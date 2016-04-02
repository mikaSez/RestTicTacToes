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


    /**
     * This method write in the board at the given position assuming it's a standard tictactoes board
     * Count begins from 1
     * Starts in the upper-left corner
     * @throws IllegalArgumentException : if x or y are not between 1-3 inclusive
     * */
    public void playAt(int x, int y) {
        if(x < 1 || y < 1){
            throw new IllegalArgumentException("X and Y should be at least 1");
        }
        if(x >3 || y > 3){
            throw new IllegalArgumentException("X and Y should be at most 3");
        }
        System.out.printf("Played at : [%d, %d]\n", x, y);
        System.out.printf("Real board position : [%d]\n", (x-1)+((y-1) * 3));
        board[(x-1)+((y-1) * 3)] = true;
    }

    /**
     * returns the corresponding board position
     * @throws IndexOutOfBoundsException : direct access to the board.
     * */
    public boolean getAt(int i) {
        return board[i];
    }
}
