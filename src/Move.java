package src;

/**
 * Move interface
 * 
 * This interface should only deal in encoder counts; no metric units here.
 * As a result, it only deals in integers.
 */
public interface Move 
{
    int getForward();

    int getTurn();

    int getStrafe();
}
