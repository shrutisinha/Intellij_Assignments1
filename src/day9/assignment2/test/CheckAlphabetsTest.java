package day9.assignment2.test;

import day9.assignment2.solution.CheckAlphabets;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zemoso on 11/7/17.
 */
public class CheckAlphabetsTest {
    private  CheckAlphabets chk;
    @Before
    public void init(){
        chk=new CheckAlphabets();
    }
    @Test
    public void checkerTest1() {
        String s="qWERtyudfagdhkvlmxnzbcDSCXVCBMVBLBPOIUYTQ14356wqetyuioplkjhgfdsazxcvbnm,,......;0987642!@#$%^&*";
        assertTrue(chk.checker(s));
    }
    @Test
    public void checkerTest2(){
        String s= "shfjfigk";
        assertFalse(chk.checker(s));
    }
    @Test
    public void checkerTest3(){
        String s= null;
        assertFalse(chk.checker(s));
    }


//    @Test
//    public void checker2(){
//        //CheckAlphabets chk=new CheckAlphabets();
//        String s= null;
//        assertFalse(chk.checker2(s));
//        s="qWERtyudfagdhkvlmxnzbcDSCXVCBMVBLBPOIUYTQ14356wqetyuioplkjhgfdsazxcvbnm,,......;0987642!@#$%^&*";
//        assertTrue(chk.checker2(s));
//        s= "shfjfigk";
//        assertFalse(chk.checker2(s));
//        s= "";
//        assertFalse(chk.checker2(s));
//    }

}