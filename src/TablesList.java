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
        int hShift = 300;
        int vShift = 200;
        int tablesPerLine = 3;

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

    public void setTable(MembersList membersList) throws IllegalArgumentException {
        int membersPerTable  = membersList.membersNumber() / this.tablesNumber();
        int remainder  = membersList.membersNumber() % tablesNumber();

        int x =  this.getTable(0).getX();
        int y =  this.getTable(0).getY();
        double degree = 0;
        int membersGap = 150;
        for(int i = 0, j = 0; i < membersList.membersNumber(); i++) {
            Member tmp = membersList.getMember(i);
            x =  this.getTable(j).getX();
            y =  this.getTable(j).getY();
            double a;
            double b;
            x = Math.round(Math.round(a = x + membersGap * (Math.cos(degree))));
            y = Math.round(Math.round(b = y + membersGap * (Math.sin(degree))));
            tmp.join(this.getTable(j), new Seat(x, y));
            degree += 2 * Math.PI / membersPerTable;
            if((i + 1) % membersPerTable == 0 && (j + 1) < this.tablesNumber()) {
                j++;
                degree = 0; 
            }
        } 
    }
}
