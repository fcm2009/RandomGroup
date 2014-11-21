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
        
        String fileName = "/home/fcm2009/membersList";
        try {
            membersList = new MembersList(fileName);
        } catch(FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Internal Erorr, Try Again Later", "Erorr", JOptionPane.ERROR_MESSAGE);
        }
        

        int tablesNumber = 0;
        int tablesNumberLimit = (int) Math.ceil(membersList.membersNumber() / 8);
        int flag  = 0;
        while(flag == 0) {
            try {
                String tmp = (JOptionPane.showInputDialog(null, "Enter Number of Groups Pleaes (Must Not Exceed Six)"));
                if(tmp == null) {
                    flag = -1;
                    break;
                }
                else
                    tablesNumber = Integer.parseInt(tmp);
                if(tablesNumber < tablesNumberLimit)
                    JOptionPane.showMessageDialog(null, "Number Tables Is Not Enough for The Number of Members. Remove Some Memebrs or Increase Number of Tables", "Erorr", JOptionPane.ERROR_MESSAGE);
                else if(tablesNumber <= 6 && tablesNumber > 0)
                    flag = 1;
                else
                    throw new IllegalArgumentException();
            } catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Invalid Input, Try Again", "Erorr", JOptionPane.ERROR_MESSAGE);
            } catch(IllegalArgumentException e){
                JOptionPane.showMessageDialog(null, "Invalid Input, Try Again", "Erorr", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        if(flag == 1)
            prepare(tablesNumber);
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare(int tablesNumber) {
        membersList.shuffle();
        
        TablesList tablesList = new TablesList(tablesNumber);
        
        this.addMembers(membersList);
        this.addTables(tablesList);

        tablesList.setTable(membersList);
    }

    public void addTables(TablesList tablesList) {
        int hShift = 300;
        int vShift = 250;
        int tablesPerLine = 3;
        for(int i = 1; i <= tablesList.tablesNumber(); i++) {
            this.addObject(tablesList.getTable(i - 1), hShift, vShift);
            hShift += 500;
            if(i % tablesPerLine == 0) {
                hShift = 300;
                vShift += 400;
            }
        }
    }

    public void addMembers(MembersList membersList) {
        int hShift = 120;
        int vShift = 50;
        int memebrsPerLine = 10;
        int i = 0;
        for(; i < memebrsPerLine; i++) {
            this.addObject(membersList.getMember(i), hShift, vShift);
            hShift += 150;
        }
        
        hShift = 120;
        vShift = 840;
        for(; i < memebrsPerLine * 2; i++) {
            this.addObject(membersList.getMember(i), hShift, vShift);
            hShift += 150;
        }
        
        hShift = 120;
        vShift = 400;
        for(; i < memebrsPerLine * 3; i++) {
            this.addObject(membersList.getMember(i), hShift, vShift);
            hShift += 150;
        }
        
        hShift = 120;
        vShift = 510;
        for(; i < memebrsPerLine * 4 ; i++) {
            this.addObject(membersList.getMember(i), hShift, vShift);
            hShift += 150;
        }
        
        hShift = 120;
        vShift = 160;
        for(; i < memebrsPerLine * 4.8; i++) {
            this.addObject(membersList.getMember(i), hShift, vShift);
            hShift += 150;
        }
    }
}
