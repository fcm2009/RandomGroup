import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
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

    /**
     * Constructor for objects of class miniWorld.
     * 
     */
    public miniWorld() {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1600, 900, 1);
        prepare();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare() {
        String fileName = "/home/fcm2009/membersList";
        try {
            membersList = new MembersList(fileName);
        } catch(FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "File Is Not Found or You Do Not Have Enough Privileges", "Erorr", JOptionPane.ERROR_MESSAGE);
        }
        membersList.shuffle();
        
        int tables = 6;
        TablesList tablesList = new TablesList(tables);
        
        this.addMembers(membersList);
        this.addTables(tablesList);
        
        tablesList.assignTable(membersList);
        
    }
    
    public void addTables(TablesList tablesList) {
        int hShift = 300;
        int vShift = 65;
        int tablesPerLine = 3;
        for(int i = 1; i <= tablesList.tablesNumber(); i++) {
            this.addObject(tablesList.getTable(i - 1), hShift, vShift);
            hShift += 500;
            if(i % tablesPerLine == 0) {
               hShift = 300;
               vShift = 200;
            }
        }
    }
    
    public void addMembers(MembersList membersList) {
        int hShift = 130;
        int vShift = 370;
        int memebrsPerLine = 10;
        for(int i = 1; i <= membersList.membersNumber(); i++) {
            this.addObject(membersList.getMember(i - 1), hShift, vShift);
            hShift += 150;
            if(i % memebrsPerLine == 0) {
                hShift = 130;
                vShift += 110;
            }
        }

    }
}
