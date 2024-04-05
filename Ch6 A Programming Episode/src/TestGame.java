import junit.framework.TestCase;
import org.junit.Test;

public class TestGame extends TestCase {
    private Game g ;
    public void setUp(){
        g=new Game();
    }

    @Test
    public void testOneThrow(){
        g.add(5);
        assertEquals(5 , g.score());
        assertEquals(1 , g.getCurrentFrame());
    }
    @Test
    public void testTwoThrowsNoMark(){
        g.add(5);
        g.add(4);
        assertEquals(9 , g.score());
        assertEquals(2 , g.getCurrentFrame());
    }
    @Test
    public void testFourThrowsNoMark(){
        g.add(5);
        g.add(4);
        g.add(7);
        g.add(2);
        assertEquals(18 , g.score());
        assertEquals(9 , g.scoreForFrame(1));
        assertEquals(18 , g.scoreForFrame(2));

        assertEquals(3 , g.getCurrentFrame());

    }
    @Test
    public void testSimpleSpare(){
        g.add(3);
        g.add(7);
        g.add(3);
        assertEquals(13 , g.scoreForFrame(1));
        assertEquals(2 , g.getCurrentFrame());
        assertEquals(2 , g.getCurrentFrame());
    }
    @Test
    public void testSimpleFrameAfterSpare(){
        g.add(3);
        g.add(7);
        g.add(3);
        g.add(2);
        assertEquals(13 , g.scoreForFrame(1));
        assertEquals(18 , g.scoreForFrame(2));
        assertEquals(18 , g.score());
        assertEquals(3 , g.getCurrentFrame());

    }
    @Test
    public void testSimpleStrike(){
        g.add(10);
        g.add(3);
        g.add(6);
        assertEquals(19 , g.scoreForFrame(1));
        assertEquals(28 , g.score());
        assertEquals(3 , g.getCurrentFrame());
    }

}
