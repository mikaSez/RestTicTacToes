package info.mikasez.tictactoes.logic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class GameTest {
    private Game tested;

    @Before
    public void setUp() throws Exception {
        tested = new Game();
    }

    @Test
    public void has2Players(){
        Assert.assertEquals(2, tested.getPlayerCount());
    }

    @Test
    public  void hasABoard(){
        Assert.assertNotNull(tested.getBoard());
    }
    @Test
    public void boardIs33(){
        Assert.assertEquals(9, tested.getBoard().length);
    }
}