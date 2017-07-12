package day9.assignment4.solution;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Shruti on 11/7/17.
 */
public class KYCFilling{
    private final SimpleDateFormat dateform =new SimpleDateFormat("dd-MM-yyyy");
    private Date signup;
    private Date current;
    KYCFilling(String signupdate,String formdate)  {
        try {
            signup= dateform.parse(signupdate);
            current = dateform.parse(formdate);
            System.out.println("Signup date: "+signup+"\nCurrent date: "+ current);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private boolean validSignupDate() {
        return signup.compareTo(current) <= 0;
    }

    /**
     * Calculates the relevent anniversary date for finding the form date range.
     * @return Date of closest anniversary
     */
    private Date AnniversaryDate() {

        Calendar ani = Calendar.getInstance();
        ani.setTime(signup);
        Calendar cur = Calendar.getInstance();
        cur.setTime(current);

        ani.set(Calendar.YEAR,cur.get(Calendar.YEAR));
        if(ani.after(cur)){
            ani.add(Calendar.YEAR,-1);
        }
        Date anni=ani.getTime();
        return anni;
    }

    private void generateFormDateRange(Date anniv) {

            Calendar cal = Calendar.getInstance();
            cal.setTime(anniv);
            cal.add(Calendar.DATE, -30);
            Date startani = cal.getTime();
            cal.add(Calendar.DATE, 60);
            Date endani = cal.getTime();
            if(endani.after(current)) {
                endani=current;
            }
        System.out.println("You call file your KYC for dates: "+dateform.format(startani)+" to "+dateform.format(endani));
    }
    public void printFormDateRange(){
        if(validSignupDate()){
            Date anniv=AnniversaryDate();
            generateFormDateRange(anniv);
        }
        else {
            System.out.println("You cannot file the KYC form before signing up to Grover Healthcare.");
        }
    }
}
