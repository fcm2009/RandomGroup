import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/**
 * Parse a list of members from a text file and return them in an arraylist .
 * 
 * @author Mohammed Alshehry 
 * @version 1.0
 */
public class Parser  
{
    public static ArrayList<Member> parse(String fileName) throws FileNotFoundException {
            File listFile = new File(fileName);
            Scanner fileReader = new Scanner(listFile);
            ArrayList<Member> membersList = new ArrayList<Member>();
            while(fileReader.hasNextLine()) {
                membersList.add(new Member(fileReader.nextLine()));
            }            
            fileReader.close();
            return membersList;
    }
}
