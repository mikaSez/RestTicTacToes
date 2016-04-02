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

    @Test
    public void boardCanBeWritten(){
        tested.playAt(2, 2);
        tested.playAt(1, 1);
        tested.playAt(3,3);

        boolean state5 = tested.getAt(4);
        boolean state1 = tested.getAt(0);
        boolean state9 = tested.getAt(8);
        Assert.assertTrue(state5);
        Assert.assertTrue(state1);
        Assert.assertTrue(state9);
    }

    @Test(expected = IllegalArgumentException.class)
    public void xShouldBeAtLeast1(){
       tested.playAt(0,1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void yShouldBeAtLeast1(){
        tested.playAt(1,0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void xShouldBeAtMost3(){
        tested.playAt(4, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void yShouldBeAtMost3(){
        tested.playAt(1,4);
    }


}