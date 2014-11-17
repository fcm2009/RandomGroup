import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.io.FileNotFoundException;

/**
 * Write a description of class MemmbersList here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MembersList
{
    private ArrayList<Member> membersList;
    
    public MembersList(String fileName) throws FileNotFoundException {
        membersList = Parser.parse(fileName);
    }
    
    public void setMembersList(ArrayList<Member> membersList) {
        this.membersList = membersList;
    }
   
    public ArrayList<Member> getMembersList() {
        return membersList;
    }
}
