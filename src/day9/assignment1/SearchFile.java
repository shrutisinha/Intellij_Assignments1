/**
 * Create an java program to search through the home directory and look for files that match
 * a regular expression. The program should be able to take inputs repeatedly and should print
 * out full absolute path of the matching files found.
 */
package day9.assignment1;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Finds complete path of file matching regex.
 */
class FindPath {

    private List<File> result=new ArrayList<>();

    /**
     * getter function to get the result that is list of all matching files
     * @return Returns list of all matching files.
     */
    public List<File> getResult(){
        return result;
    }
    /**
     *
     * Prints the complete path if file matching regex is found. It searches in all directories and
     * subdirectories recursively.
     * @param rgx The regular expression that has to be matched
     * @param directory The home directory where search is carried out
     */
    public void findFiles(String rgx, String directory) {
        File home = new File(directory);
        File[] fileslist = home.listFiles();
        if(fileslist.length!=0){
            for(File file : fileslist){
                if(file.isFile() ){
//                    Pattern p= Pattern.compile(rgx);
//                    Matcher m=p.matcher(file.getName());
//                    if(m.matches()) {
//                        result.add(file);
//                    }
                    if(file.getName().matches(rgx)){
                        result.add(file);
                    }
                    //System.out.println(file);
                }
                else if(file.isDirectory()){
                    System.out.println("Searching directory ... " + file.getAbsoluteFile());
                    findFiles(rgx, file.getAbsolutePath());
                }
            }
        }
    }
}
/**
 * Created by zemoso on 11/7/17.
 * Class containing main method.
 */

public class SearchFile {
    /**
     * Continuously asks user to enter a regex pattern and prints matching files in home directory
     * @param args not used
     * @throws IOException can throw this exception
     */
    public static void main(String args[])throws IOException {
        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);
        String s;
        while(true){
            FindPath path = new FindPath();
            System.out.println("Enter java regular expression to be matched with file name");
            System.out.println("Enter \"exit\" to exit");
            s = br.readLine();
            if (s.equals("exit"))break;
            path.findFiles(s, "/home");
            List<File> filesearches;
            filesearches=path.getResult();
            if(filesearches.size()==0){
                System.out.println("No result found!");
            }
            for(File file:filesearches){
                System.out.println("Found:  "+file);
            }
        }
    }
}
