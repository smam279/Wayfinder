package odometry;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class PositionTest 
{
    @Test
    public void testEqualPositionsIntersect() {
        Position a = new Position();
        a.x = 10;
        a.y = 15;

        Position b = new Position();
        b.x = 10;
        b.y = 15;

        assertTrue(a.intersects(b));
    }

    @Test
    public void testNearEqualPositionsIntersect() {
        Position a = new Position();
        a.x = 10;
        a.y = 15;
        a.positionPrecision = 0.5;

        Position b = new Position();
        b.x = 10.3;
        b.y = 15.1;

        assertTrue(a.intersects(b));
    }

    @Test
    public void testUnequalPositionsFailIntersect() {
        Position a = new Position();
        a.x = 10;
        a.y = 15;

        Position b = new Position();
        b.x = 10.3;
        b.y = 15.1;

        assertFalse(a.intersects(b));
    }
}
