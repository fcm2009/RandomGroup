import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.awt.Color;

/**
 * each table represents a group.
 * 
 * @auther Mohammed Alshehry
 * @version 1.0
 */
public class Table extends Actor
{
    private int number;
    private MembersList membersList;
    
    /**
     * Act - do whatever the Table wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Table(int number) {
        if(number < 0){
            throw new IllegalArgumentException();
        }
        this.number = number;
        GreenfootImage numberImage = new GreenfootImage("#" + number, 32, new Color(174, 167, 159), null);
        getImage().drawImage(numberImage, 35, 35);
    }
    
    public Table() {
        this(0);
    }
    
    public void act() 
    {
        // Add your action code here.
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
    
    public void setMembersList(MembersList membersList) {
        if(membersList == null) {
            throw new IllegalArgumentException();
        }
        this.membersList = membersList;
    }
    
    public void join(Member member) {
        membersList.addMember(member);
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
