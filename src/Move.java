package src;

/**
 * Move interface
 * 
 * This interface should only deal in encoder counts; no metric units here.
 * As a result, it only deals in integers.
 */
public interface Move 
{
    public int getForward();

    public int getTurn();

    public int getStrafe();
}
