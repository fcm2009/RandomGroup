import greenfoot.*;
import java.util.ArrayList;

/**
 * Write a description of class TablesList here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TablesList  
{
    private ArrayList<Table> tablesList;

    /**
     * Constructor for objects of class TablesList
     */
    public TablesList(int tables) {
        tablesList = new ArrayList<Table>();
        
        for(int i = 1; i <= tables; i++) {
            tablesList.add(new Table(i));
        }
    }
    
    public int tablesNumber() {
        return tablesList.size();
    }
    
    public Table getTable(int i) {
        return tablesList.get(i);
    }
    
    public void assignTable(MembersList membersList) throws IllegalArgumentException {
        int membersPerTable  = membersList.membersNumber() / this.tablesNumber();
        if(membersPerTable == 0) {
            throw new IllegalArgumentException("Number of Student is Less than Number of Tables");
        }
        int remainder  = membersList.membersNumber() % tablesNumber();
        
        for(int i = 0, j = 0; i < membersList.membersNumber(); i++) {
            membersList.getMember(i).join(this.getTable(j));
            if((i + 1) % membersPerTable == 0 && j < tablesList.size() - 1) {
                j++;
            }
                
        }
            
    }
}
