import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

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
    
    /**
     * Act - do whatever the Member wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
       int tableX = table.getX();
       int tableY = table.getY();
       int hGap = (this.getImage().getWidth() / 2) + (table.getImage().getWidth() / 2) + 10;
       int vGap = (this.getImage().getHeight() / 2) + (table.getImage().getHeight() / 2) + 10;
       int membersGap = 50;
       
       moveTo(tableX - hGap, tableY);
    }
    
    public void join(Table table) {
        this.table = table;
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
