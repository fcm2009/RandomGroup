/**
 * Write a description of class Seat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Seat  
{
    private int x;
    private int y;

    /**
     * Constructor for objects of class Seat
     */
    public Seat(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public void setY(int y) {
        this.y = y;
    }
}
