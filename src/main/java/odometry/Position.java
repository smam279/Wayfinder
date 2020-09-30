package odometry;

public class Position {
    double x, y, heading;
    boolean useHeading;
    double positionPrecision;
    double headingPrecision;

    public Position()
    {
        x = 0;
        y = 0;
        heading = 0;
        useHeading = false;
        positionPrecision = 0;
        headingPrecision = 0;
    }

    private double hypot(double a, double b)
    {
        return Math.sqrt((a*a) + (b*b));
    }

    public boolean comparePositions(Position other)
    {

        if (hypot(Math.abs(other.x - x), Math.abs(other.y - y)) 
            < other.positionPrecision + positionPrecision)
        {
            
            if (useHeading && other.useHeading)
            {
                return (Math.abs(heading - other.heading) < headingPrecision + other.headingPrecision);
            } else {
                return true;
            }
        }
        return false;
    }
}
