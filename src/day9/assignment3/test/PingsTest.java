package day9.assignment3.test;

import day9.assignment3.solution.Pings;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class PingsTest {
    private Pings p;
    @Before
    public void init(){
     p=new Pings();
    }
    @Test
    public void pingTest12(){
        assertFalse(p.ping("HULULULU",1));
    }
    @Test
    public void pingTest3(){
        assertTrue(p.ping("google.com",1));
    }
    @Test
    public void pingTest4(){
        assertTrue(p.ping("google.com",5));
    }
    @Test
    public void pingTest5(){
        assertFalse(p.ping("",1));
    }
    @Test
    public void pingTest6(){
        assertFalse(p.ping(null,1));
    }



}