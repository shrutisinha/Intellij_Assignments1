package day9.assignment1.test;

import day9.assignment1.solution.FindPath;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zemoso on 12/7/17.
 */
public class FindPathTest {
    private  FindPath p;
    @Before
    public void init(){
        p = new FindPath();
    }
    @After
    public void print(){
        System.out.println(p.getResult());
    }
    @Test
    public void findFilesTest1() throws Exception {
        assertTrue(p.findFiles(".*\\.java","/home"));
        //print();
    }
    @Test
    public void findFilesTest2() throws Exception {
        assertFalse(p.findFiles("\\.\\*.java","/home"));

    }
    @Test
    public void findFilesTest3() throws Exception {
        assertFalse(p.findFiles("*.java","/home"));
    }
    @Test
    public void findFilesTest4() throws Exception {
        assertFalse(p.findFiles(null,null));
    }
    @Test
    public void findFilesTest5() throws Exception {
        assertFalse(p.findFiles("","/home/zemoso"));
    }
    @Test
    public void findFilesTest6() throws Exception {
        assertFalse(p.findFiles("","/notexist"));
    }
    @Test
    public void findFilesTest7() throws Exception {
        assertTrue(p.findFiles("FindPath.java","/home"));
    }
//    @Test
//    public void findFilesTest() throws Exception {
//    }
//    @Test
//    public void findFilesTest() throws Exception {
//    }
//    @Test
//    public void findFilesTest() throws Exception {
//    }

}