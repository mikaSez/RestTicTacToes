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
        Assert.assertNotNull(state5);
        Assert.assertNotNull(state1);
        Assert.assertNotNull(state9);



        Boolean null1 = tested.getAt(1);
        Boolean null2 = tested.getAt(2);
        Boolean null3 = tested.getAt(3);

        Boolean null5 = tested.getAt(5);
        Boolean null6 = tested.getAt(6);
        Boolean null7 = tested.getAt(7);
        Assert.assertNull(null1);
        Assert.assertNull(null2);
        Assert.assertNull(null3);
        Assert.assertNull(null5);
        Assert.assertNull(null6);
        Assert.assertNull(null7);
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

    @Test
    public void firstPlayerStarts(){
        int nb = tested.getCurrentPlayer();
        Assert.assertEquals(1, nb);
    }

    @Test
    public void afterPlayingPlayerAlternate(){
        tested.playAt(1,1);
        int nb = tested.getCurrentPlayer();

        Assert.assertEquals(2, nb);
    }


    @Test
    public void boardTracksPlayer(){
        tested.playAt(1,1);
        tested.playAt(2,1);
        tested.playAt(3,1);
        boolean one = tested.getAt(0);
        boolean two = tested.getAt(1);
        boolean oneBis = tested.getAt(2);

        Assert.assertTrue(one);
        Assert.assertFalse(two);
        Assert.assertTrue(oneBis);
    }

    @Test(expected = IllegalArgumentException.class)
    public void playerCannotPlayAtTheSamePlace(){
        tested.playAt(1,1);
        tested.playAt(1,1);
    }

}