package day9.assignment2.solution;

/**
 * Write a java function that checks if the input string contains all the letters of the
 * alphabet a-z (case-insensitive).
 * Created by zemoso on 10/7/17.
 */
public class CheckAlphabets{
    /**
     * Checks whether input string contains all letters of ana alphabet using <b>regex</b>.
     * @param s The input string
     * @return true if contains all letters of alphabet, otherwise false
     */
    public boolean checker(String s){
        if(s==null)return  false;
        //Only keep albhabets in the string
        s=s.replaceAll("[^A-Za-z]","");
        s=s.toLowerCase();
        //Remove duplicate characters
        s=s.replaceAll("(.)(?=.*\\1)", "");
        if (s.length()==26) {
            return true;
        }
        System.out.println("Contains only "+s.length()+" alphabets.");
        return false;
    }

/*
/**
* Checks whether input string contains all letters of ana alphabet.
* @param str The input string
* @return true if contains all letters of alphabet, otherwise false
* /
//    public boolean checker2(String str){
if(str==null)return  false;
boolean alphabets[]=new boolean[26];
int count=0;
str=str.toLowerCase();
for(int i=0;i<str.length();i++){
char x= str.charAt(i);
if (x>='a' && x<='z' && !alphabets[x-'a']){
count++;
alphabets[x-'a']=true;
}
if (count==26){
return true;
}
}
System.out.println("Contains only "+count+" alphabets.");
return false;

}
*/

}
