import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.io.FileNotFoundException;

/**
 * Write a description of class MemmbersList here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MemmbersList
{
    private ArrayList<Member> membersList;
    
    private MemmbersList(String fileName) throws FileNotFoundException {
        membersList = Parser.parse(fileName);
    }
    
    public void setMembersList(ArrayList<Member> membersList) {
        this.membersList = membersList;
    }
   
    public ArrayList<Member> getMembersList() {
        return membersList;
    }
}
