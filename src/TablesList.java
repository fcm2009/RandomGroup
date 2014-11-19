import java.util.ArrayList;
import java.util.Collections;

/**
 * Write a description of class TablesList here.
 * 
 * @author Mohammed Alshehry
 * @version 1.0
 */
public class TablesList  
{
    private ArrayList<Table> tablesList;
    
    public TablesList(int tablesNumber) {
        tablesList = new ArrayList<Table>();
        for(int i = 1; i <= tablesNumber; i++) {
            tablesList.add(new Table(i));
        }
    }
    
    public void setMembersList(ArrayList<Table> tablesList) {
        this.tablesList = tablesList;
    }
   
    public ArrayList<Table> getTablesList() {
        return tablesList;
    }
    
    public void addMember(Table table) {
        tablesList.add(table);
    }
    
    public void removeMember(Table table) {
        tablesList.remove(table);
    }
    
    public void removeMember(int i) {
        tablesList.remove(i);
    }
    
    public Table getTable(int i) {
        return tablesList.get(i);
    }
    
    public void shuffle() {
        Collections.shuffle(tablesList);
    }
    
    public int tablesNumber() {
        return tablesList.size();
    }
}
