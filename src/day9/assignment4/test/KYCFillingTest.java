package day9.assignment4.test;

import day9.assignment4.solution.KYCFilling;
import org.junit.Test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import static org.junit.Assert.*;

/**
 * Testing class
 * Created by zemoso on 12/7/17.
 */
public class KYCFillingTest {
    private KYCFilling obj;
    private Date dt = new Date();
    private Date anniv=new Date();
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    @Test
    public void validSignupDate(){
        //the format is being checked in the main function so null cases wont occur
        obj = new KYCFilling("01-01-2001","01-03-2013");
        assertTrue(obj.validSignupDate());
        obj = new KYCFilling("01-01-2001","01-03-2013");
        assertTrue(obj.validSignupDate());
        obj = new KYCFilling("01-01-2001","12-03-1013");
        assertFalse(obj.validSignupDate());
        obj = new KYCFilling("04-13-2001","01-01-2002");
        assertFalse(obj.validSignupDate());
        obj = new KYCFilling("0-0-0","1-1-1");
        assertTrue(obj.validSignupDate());
        obj = new KYCFilling("1-1-2001","01-01-2001");
        assertTrue(obj.validSignupDate());
    }

    @Test
    public void anniversaryDate()throws ParseException{
        dt=sdf.parse("01-01-2013");
        obj = new KYCFilling("01-01-2001","01-03-2013");
        assertEquals(obj.AnniversaryDate(),dt);
        dt=sdf.parse("01-01-2014");
        obj = new KYCFilling("1-1-2014"," 31-1-2014");
        assertEquals(obj.AnniversaryDate(),dt);
        dt=sdf.parse("05-01-2018");
        obj = new KYCFilling("5-1-2012","5-1-2018");
        assertEquals(obj.AnniversaryDate(),dt);
        dt=sdf.parse("05-01-2018");
        obj = new KYCFilling("5-1-2012","5-0-2018");
        assertNotEquals(obj.AnniversaryDate(),dt);
        dt=sdf.parse("01-02-2017");
        obj = new KYCFilling("1-2-2012","1-1-2018");
        assertEquals(obj.AnniversaryDate(),dt);
    }

    @Test
    public void generateFormDateRange() throws Exception {
        //validation carried out so input dates are valid
        obj=new KYCFilling("1-1-2014","31-1-2014");
        assertEquals("01-01-2014 to 31-01-2014",obj.generateFormDateRange(obj.AnniversaryDate()));
        obj=new KYCFilling("5-1-2012","5-1-2018");
        assertEquals("06-12-2017 to 05-01-2018",obj.generateFormDateRange(obj.AnniversaryDate()));
        obj=new KYCFilling("05-10-1994","05-10-1994");
        assertEquals("05-10-1994 to 05-10-1994",obj.generateFormDateRange(obj.AnniversaryDate()));
        obj=new KYCFilling("05-10-1994","05-10-2001");
        assertEquals("05-09-2001 to 05-10-2001",obj.generateFormDateRange(obj.AnniversaryDate()));
    }
}
//1-1-2014 31-1-2014
//5-1-2012 5-1-2018
//05-10-1994 05-10-1994
//05-10-1994 05-10-2001