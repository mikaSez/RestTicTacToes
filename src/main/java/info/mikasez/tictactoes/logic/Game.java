package info.mikasez.tictactoes.logic;

import java.util.Arrays;

/**
 * Main tictactoes game class possess the application logic
 */
public class Game {

    private Boolean [] board;
    private Boolean playerOne;
    private boolean victory;
    private boolean gameEnded;

    public Game(){
        board =  new Boolean[9];
        playerOne = true;
        gameEnded = false;
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

        if(board[getAt(x, y)] != null){
            throw new IllegalArgumentException("This case has been already played");
        }

        System.out.printf("Player %d played at : [%d, %d]\n", getCurrentPlayer(), x, y);
        System.out.printf("Real board position : [%d]\n", getAt(x, y));

        board[getAt(x, y)] = playerOne;
        if(!gameEnded()){
            playerOne = !playerOne;
        }
    }

    /**
     * returns the corresponding board position
     * @throws IndexOutOfBoundsException : direct access to the board.
     * */
    private int getAt(int x, int y) {
        return (x-1)+((y-1) * 3);
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

    /**
     * Checks if game has actually ended <br>
     * Ending conditions : <br>
     *     <ul>
     *         <li> Board is full </li>
     *         <li> One player completed a row</li>
     *     </ul>
     *
     * */
    public boolean gameEnded() {
        if(gameEnded){
            return true;
        }
        if(checkRows()){
            victory = true;
            gameEnded = true;
        }
        else if(Arrays.stream(board).noneMatch(c->c==null)){
            return gameEnded = true;
        }
        return gameEnded;
    }

    private boolean checkRows() {
        for(int i = 1 ; i <= 3; i++){
            if(equalsAll(board[3 * (i - 1)], board[1+3*(i-1)], board[2+3*(i-1)])){
                System.out.printf("Player %d has completed the row number : %d\n", getCurrentPlayer(), i);
                return true;
            }
        }
        return false;
    }


    /**
     * Checks if all passed values corresponds to the current player
     * */
    private boolean equalsAll(Boolean... values){
        return Arrays.stream(values).allMatch(v->playerOne.equals(v));
    }

    /**
     * Returns true if the current player wins <br>
     * false on the draw
     * */
    public boolean getVictory() {
        return victory;
    }
}
