import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * each Member represents a person.
 * 
 * @author Mohammed Alshehry 
 * @version 1.0
 */
public class Member extends Actor implements Comparable
{
    String name;
    
    public Member(String name) {
        name.trim();
        if(name == null || name == "") {
            throw new IllegalArgumentException();
        }
        this.name = name;
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
    
    public void joinTable(Table table) {
        
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