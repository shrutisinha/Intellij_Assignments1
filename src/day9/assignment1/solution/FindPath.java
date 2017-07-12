package day9.assignment1.solution;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Finds complete path of file matching regex.
 */
public class FindPath {

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
    public boolean findFiles(String rgx, String directory){
        try{
            Pattern.compile(rgx);
        }catch (PatternSyntaxException e){
            System.out.println("Enter valid Regex");
           return false;
        }
        File home = new File(directory);
        File[] fileslist = home.listFiles();
        try {
            if (fileslist.length != 0) {
                for (File file : fileslist) {
                    if (file.isFile()) {
                        //                    Pattern p= Pattern.compile(rgx);
                        //                    Matcher m=p.matcher(file.getName());
                        //                    if(m.matches()) {
                        //                        result.add(file);
                        //                    }
                        if (file.getName().matches(rgx)) {
                            result.add(file);

                        }
                        //System.out.println(file);
                    } else if (file.isDirectory()) {
                        System.out.println("Searching directory ... " + file.getAbsoluteFile());
                        findFiles(rgx, file.getAbsolutePath());
                    }
                }
            }
        }catch(NullPointerException e){
            System.out.println("Invalid Directory Name");
        }
        return (result.size()>0);
    }
}
