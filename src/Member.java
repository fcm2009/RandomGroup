import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.util.List;

/**
 * each Member represents a person.
 * 
 * @author Mohammed Alshehry 
 * @version 1.0
 */
public class Member extends Movable implements Comparable
{
    private String name;
    private Table table;
    Seat seat;
    int degree;

    public Member(String name) {
        name.trim();
        if(name == null || name == "") {
            throw new IllegalArgumentException();
        }
        this.name = name;
        GreenfootImage nameImage = new GreenfootImage(name, 13, new Color(174, 167, 159), null);
        GreenfootImage memberImage = getImage();
        memberImage.drawImage(nameImage, (memberImage.getWidth() / 2) - (nameImage.getWidth() / 2), 78);
    }

    public Member() {
        this("a");
    }

    public void setName(String name) {
        name.trim();
        if(name == null || name == "") {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    
    public Seat getSeat() {
        return seat;
    }

    /**
     * Act - do whatever the Member wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        moveTo(seat.getX(), seat.getY());
        
        boolean xRounding = Math.abs(getX() - getSeat().getX()) <= 1;
        boolean yRounding = Math.abs(getY() - getSeat().getY()) <= 1;
        if(xRounding && yRounding) {
            turn(getRotation() - 90);    
            turnTowards(table.getX(), table.getY());
        }
    }

    public void join(Table table, Seat seat) {
        this.table = table;
        this.seat = seat;
    }

    public int compareTo(Object obj) {
        if(obj != null) {
            if(obj instanceof Member) {
                Member member = (Member) obj;
                return this.name.compareTo(member.getName());
            }
            else
                throw new ClassCastException();
        }
        else
            throw new NullPointerException();
    }
}
