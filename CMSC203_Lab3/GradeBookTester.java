
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class GradeBookTester {

    private GradeBook g1;
    private GradeBook g2;

    @Before
    public void setUp() {
        g1 = new GradeBook(5);
        g1.addScore(50);
        g1.addScore(75);
        g1.addScore(90);

        g2 = new GradeBook(5);
        g2.addScore(60);
        g2.addScore(80);
    }

    @After
    public void tearDown() {
        g1 = null;
        g2 = null;
    }

    @Test
    public void testAddScore() {
        assertTrue(g1.addScore(85));

        assertTrue(g1.toString().equals(
            "50.0 75.0 90.0 85.0 "));

        assertEquals(4, g1.getScoreSize());
    }

    @Test
    public void testGetScoreSize() {
        assertEquals(3, g1.getScoreSize());
        assertEquals(2, g2.getScoreSize());
    }

    @Test
    public void testToString() {
        assertEquals("50.0 75.0 90.0 ", g1.toString());
        assertEquals("60.0 80.0 ", g2.toString());
    }

    @Test
    public void testSum() {
        assertEquals(215.0, g1.sum(), 0.0001);
        assertEquals(140.0, g2.sum(), 0.0001);
    }

    @Test
    public void testMinimum() {
        assertEquals(50.0, g1.minimum(), 0.001);
        assertEquals(60.0, g2.minimum(), 0.001);
    }

    @Test
    public void testFinalScore() {
        assertEquals(165.0, g1.finalScore(), 0.0001);
        assertEquals(80.0, g2.finalScore(), 0.0001);
    }
}
