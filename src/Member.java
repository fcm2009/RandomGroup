import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * each Member represents a person.
 * 
 * @author Mohammed Alshehry 
 * @version 1.0
 */
public class Member extends Actor implements Comparable
{
    private String name;
    private Table table;
    final static int width = 102;
    final static int height = 140;
    
    public Member(String name) {
        name.trim();
        if(name == null || name == "") {
            throw new IllegalArgumentException();
        }
        this.name = name;
        
        GreenfootImage nameImage = new GreenfootImage(name, 12, new Color(174, 167, 159), null);
        getImage().drawImage(nameImage, 2, 78);
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
    
    public static int getWCenter() {
        return width / 2;
    }
    
    public static int getHCenter() {
        return height / 2;
    }
    
    /**
     * Act - do whatever the Member wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
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
