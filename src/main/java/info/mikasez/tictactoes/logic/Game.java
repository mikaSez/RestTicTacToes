package info.mikasez.tictactoes.logic;

/**
 * Main game class possess the application logic
 */
public class Game {

    private Boolean [] board;
    private boolean playerOne;
    public Game(){
        board =  new Boolean[9];
        playerOne = true;
    }

    /**
     * Board has 3 states <br>
     *     Null : not played <br>
     *     True : Player one played here <br>
     *     False : Player two played here <br>
     * */
    public Boolean[] getBoard() {
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
        if(x >3 || y > 3) {
            throw new IllegalArgumentException("X and Y should be at most 3");
        }

        if(board[(x-1)+((y-1) * 3)] != null){
            throw new IllegalArgumentException("This case has been already played");
        }

        System.out.printf("Player %d played at : [%d, %d]\n", getCurrentPlayer(), x, y);
        System.out.printf("Real board position : [%d]\n", (x-1)+((y-1) * 3));

        board[(x-1)+((y-1) * 3)] = playerOne;
        playerOne = !playerOne;
    }

    /**
     * returns the corresponding board position
     * @throws IndexOutOfBoundsException : direct access to the board.
     * */
    public Boolean getAt(int i) {
        return board[i];
    }

    public int  getCurrentPlayer() {
        return playerOne ? 1 : 2;
    }
}
