import junit.framework.TestCase;
import org.junit.Test;

public class TestFrame extends TestCase {
    @Test
    public void testScoreNoThrow(){
        Frame f = new Frame();
        assertEquals(0 , f.score());
    }
    @Test
    public void testAddOneThrow(){
        Frame f = new Frame();
        f.add(5);
        assertEquals(5 , f.score());
    }

}
