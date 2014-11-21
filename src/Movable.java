import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * better version of Actor.
 * 
 * @author Mohammeed Alshehry 
 * @version 1.0
 */
public class Movable extends Actor
{
    
    public void move(int distance) {
        super.move(distance);
        setRotation(-90);
    }
    
    public void moveTo(int x, int y) {
        double distance = Math.round(Math.sqrt(Math.pow(x - getX(), 2) + Math.pow(y - getY(), 2)));
        if(distance <= 1 && distance >= -1) {
            setRotation(0);
            return;
        }
        turnTowards(x, y);
        super.move(1);
    }
    
    public void moveTo(int x, int y, int shift) {
        int distance = Math.round(Math.round(Math.round(Math.sqrt(Math.pow(x - getX(), 2) + Math.pow(y - getY(), 2))))) + shift;
        if(distance - shift <= 1 && distance - shift >= -1) {
            setRotation(0);
            return;
        }
        turnTowards(x, y);
        super.move(1);
    }
    
    public void move(int distance, int digree) {
        setRotation(getRotation() - digree);
        super.move(distance);
    }
        
    
    public boolean isOccupied(int x, int y) {
        int cX = getX();
        int cY = getY();
        x = x - cX;
        y = y - cY;
        return getOneObjectAtOffset(x, y, Movable.class) != null;
    }
}
