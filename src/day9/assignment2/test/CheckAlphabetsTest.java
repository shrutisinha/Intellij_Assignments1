package day9.assignment2.test;

import day9.assignment2.solution.CheckAlphabets;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zemoso on 11/7/17.
 */
public class CheckAlphabetsTest {
    @Test
    public void checker() throws Exception {
        CheckAlphabets chk=new CheckAlphabets();

        String s="qWERtyudfagdhkvlmxnzbcDSCXVCBMVBLBPOIUYTQ14356wqetyuioplkjhgfdsazxcvbnm,,......;0987642!@#$%^&*";
        assertTrue(chk.checker(s));
        s= "";
        assertFalse(chk.checker(s));
    }

    @Test
    public void checker2() throws Exception {
    }

}