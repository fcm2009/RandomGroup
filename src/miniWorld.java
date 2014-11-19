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
    private MembersList membersList;
    private int gap = 10;
    private int groupW = Table.width + Member.width + 2 * gap;
    private int groupH = Table.height + Member.height + 2 * gap;
    private int groupWCenter = Table.getWCenter() + Member.getWCenter();
    private int groupHCenter = Table.getHCenter() + Member.getHCenter();
    private int tablesPerLine = (int) Math.floor(this.getWidth() / groupW);
    
    /**
     * Constructor for objects of class miniWorld.
     * 
     */
    public miniWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1);
        
        String fileName = "/home/fcm2009/membersList";
        try{
            membersList = new MembersList();
            membersList.setMembersList(Parser.parse(fileName));
        }
        catch(FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "File Is Not Found or You Do Not Have Enough Privileges", "Erorr", JOptionPane.ERROR_MESSAGE);
        }
        
        membersList.shuffle();
        int groupsNumber = 10;
        TablesList tablesList = new TablesList(groupsNumber);
        for(int i = 0; i < tablesList.tablesNumber(); i++) {
            for(int j = 0; j < Math.floor(this.getWidth() / groupW); j++) {
                this.addObject(tablesList.getTable(i), (j * groupW) + groupWCenter, (i * groupH) + groupHCenter);
            }
        }
        
    }
}
