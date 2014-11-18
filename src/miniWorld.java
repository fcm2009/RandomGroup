import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.io.FileNotFoundException;
/**
 * Write a description of class miniWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class miniWorld extends World
{
    MembersList membersList;
    JFileChooser filechooser;

    /**
     * Constructor for objects of class miniWorld.
     * 
     */
    public miniWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 768, 1);
        
        String fileName = "/home/fcm2009/membersList";
        try{
            membersList = new MembersList();
            membersList.setMembersList(Parser.parse(fileName));
        }
        catch(FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "File Is Not Found or You Do Not Have Enough Privileges", "Erorr", JOptionPane.ERROR_MESSAGE);
        }
        
        int membersNumber = membersList.membersNumber();
        int groupsNumber = 6;
        
    }
}
