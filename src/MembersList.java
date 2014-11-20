import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Collections;
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
        membersList = new ArrayList<Member>();
        this.setMembersList(Parser.parse(fileName));
    }
    
    public void setMembersList(ArrayList<Member> membersList) {
        this.membersList = membersList;
    }
   
    public ArrayList<Member> getMembersList() {
        return membersList;
    }
    
    public void addMember(Member member) {
        membersList.add(member);
    }
    
    public void removeMember(Member member) {
        membersList.remove(member);
    }
    
    public void removeMember(int i) {
        membersList.remove(i);
    }
    
    public Member getMember(int i) {
        return membersList.get(i);
    }
    
    public void shuffle() {
        Collections.shuffle(membersList);
    }
    
    public int membersNumber() {
        return membersList.size();
    }
}
