package day9.assignment4.solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class KYC {
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
        String[] dates=s.split(" ");
        KYCFilling form=new KYCFilling(dates[0],dates[1]);
        form.printFormDateRange();
    }
}
