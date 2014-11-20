import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.awt.Color;

/**
 * each table represents a group.
 * 
 * @auther Mohammed Alshehry
 * @version 1.0
 */
public class Table extends Movable
{
    private int number;
    private int seats;
    private boolean avalible;

    /**
     * Act - do whatever the Table wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Table(int number, boolean avalible) {
        if(number < 0){
            throw new IllegalArgumentException();
        }
        this.number = number;
        GreenfootImage numberImage = new GreenfootImage("#" + number, 32, new Color(174, 167, 159), null);
        getImage().drawImage(numberImage, 35, 35);
        this.avalible = avalible;
    }
    
    public Table(int number) {
        this(number, true);
    }

    public Table() {
        this(0, false);
    }
    
    public void setNumber(int number) {
        if(number < 0){
            throw new IllegalArgumentException();
        }
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }
    
    public void setAvalible(boolean avalible) {
        this.avalible = avalible;
    }

    public boolean isAvalible() {
        return this.avalible;
    }

    public void act() 
    {
        if(number == 1)
            moveTo(300, 200);
        else if(number == 2)
            moveTo(800, 200);
        else if(number == 3)
            moveTo(1300, 200);
        else if(number == 4)
            moveTo(300, 550);
        else if(number == 5)
            moveTo(800, 550);
        else if(number == 6)
            moveTo(1300, 550);
    }

    public int compareTo(Object obj) {
        if(obj != null) {
            if(obj instanceof Table) {
                Table table = (Table) obj;
                return this.number - (table.getNumber());
            }
            else
                throw new ClassCastException();
        }
        else
            throw new NullPointerException();
    }
}
