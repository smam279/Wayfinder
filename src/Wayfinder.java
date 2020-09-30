/**
 * Wayfinder class
 * by: Sam Rooney
 * 
 */
package src;

public class Wayfinder 
{

    Position currentPosition;
    double robot_wheel_base, robot_wheel_track;
    double robot_wheel_radius, robot_encoder_cpr;
    double robot_distancePerCount;
    double robot_rotationPerCount;
    double robot_strafeMultiplier; //calculated outside of this code from the drivetrain,
                                   // e.g. from mecanum wheel caster angle

    public Wayfinder() 
    {
        currentPosition = new Position();
        currentPosition.useHeading = true;
        //because currentPosition is the authority on where the robot is,
        // its precision remains at 0; it's as exact as it gets.

        robot_wheel_base = 0;
        robot_wheel_track = 0;
        robot_wheel_radius = 0;
        robot_encoder_cpr = 0;
    }

    public void setPose(double x, double y, double heading) 
    {
        currentPosition.x = x;
        currentPosition.y = y;
        currentPosition.heading = heading;
    }

    public void setRobotCharacteristics(double wheelbase, double wheeltrack, double wheelradius, double encoder_cpr) 
    {
        robot_wheel_base = wheelbase; //distance between front wheels and back wheels
        robot_wheel_track = wheeltrack; //distance between left wheels and right wheels
        robot_wheel_radius = wheelradius;
        robot_encoder_cpr = encoder_cpr;

        robot_distancePerCount = (2 * Math.PI * robot_wheel_radius) / robot_encoder_cpr;

        //TODO: check this calculation for errors
        robot_rotationPerCount = ((Math.PI * robot_wheel_track) / robot_distancePerCount) / 2;
    }

    private void update_TranslateForward(double forwardCounts)
    {
        double forwardDistance = forwardCounts * robot_distancePerCount;

        double x_Distance = forwardDistance * Math.sin(currentPosition.heading);
        double y_Distance = forwardDistance * Math.cos(currentPosition.heading);

        currentPosition.x += x_Distance;
        currentPosition.y += y_Distance;
    }

    private void update_Rotate(double rotationCounts)
    {
        //rotationCounts should be the total distance between the "left" encoder 
        // counts and the "right" encoder counts, meaning it's equivalent to two
        // motors each traveling half that distance along the rotation circle

        double rotation = rotationCounts * robot_rotationPerCount;
        
        currentPosition.heading += rotation;

    }

    private void update_TranslateStrafe(double strafeCounts)
    {
        double strafeDistance = strafeCounts * robot_distancePerCount * robot_strafeMultiplier;

        double x_Distance = strafeDistance * Math.sin(currentPosition.heading + (Math.PI / 2));
        double y_Distance = strafeDistance * Math.cos(currentPosition.heading + (Math.PI / 2));

        currentPosition.x += x_Distance;
        currentPosition.y += y_Distance;
    }

    public void update(Move movement) 
    {
        double totalTurn = movement.getTurn();

        update_Rotate(totalTurn / 2); //half rotation, because on average you will
        update_TranslateForward(movement.getForward()); //travel forward and
        update_TranslateStrafe(movement.getStrafe()); //strafe at 50% of the turn angle
        update_Rotate(totalTurn / 2); //finish the turn
        
        //this should be more than accurate enough if the movements are being calculated every
        // fraction of a second; if not, its easy enough to change
    }
}