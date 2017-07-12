package day9.assignment4.solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

/**
 * Main Class
 * Prints the allowable form date to fill the KYC form
 */
public class KYC {
    /**
     * Main Method that takes input from user which is the signup date and the current date in a particular format.
     * It prints the range of form date for filling the KYC form
     * @param args no use
     * @throws IOException As input comes from the stream
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        int i=0;
        while(i++<10){
            System.out.println("Enter signup date and current date in \'dd-mm-yyyy\' dateform seperated by space");
            s=br.readLine();
            if(s.matches("^\\d+\\-\\d+\\-\\d+[ ]+\\d+\\-\\d+\\-\\d+$"))
                break;
            if(i<10)
                System.out.println("Wrong dateform. Please try again. Frormat: \'dd-MM-yyyy dd-MM-yyyy\'");
            else {
                System.out.println("Sorry. Time out.");
                System.exit(0);
            }
        }
        String[] dates=s.split(" ");//might throw exception but its handles
        KYCFilling form=new KYCFilling(dates[0],dates[1]);
        if(form.validSignupDate()){
            Date anniv=form.AnniversaryDate();
            System.out.println("You can file your KYC for dates: "+form.generateFormDateRange(anniv));
        }
        else {
            System.out.println("You cannot file the KYC form before signing up to Grover Healthcare.");
        }
    }
}
