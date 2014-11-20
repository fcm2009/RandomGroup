import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * better version of Actor.
 * 
 * @author Mohammeed Alshehry 
 * @version 1.0
 */
public class Movable extends Actor
{

    public void moveTo(int x, int y) {
        double distance = Math.round(Math.sqrt(Math.pow(x - getX(), 2) + Math.pow(y - getY(), 2)));
        if(distance <= 1 && distance >= -1) {
            setRotation(0);
            return;
        }
        turnTowards(x, y);
        super.move(1);
    }
}
