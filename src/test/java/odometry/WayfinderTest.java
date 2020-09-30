package odometry;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class WayfinderTest 
{
    @Test
    public void testDistancePerCount() {
        Wayfinder wf = new Wayfinder();

        wf.setRobotCharacteristics(14*2.54, 14*2.54, 3.5, 360);
        
        assertTrue(wf.robot_distancePerCount - 0.061 < 0.001); //test that this calculation is correct within reasonable error
    }
}
