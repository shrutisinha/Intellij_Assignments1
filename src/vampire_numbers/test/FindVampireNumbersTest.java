package vampire_numbers.test;

import org.junit.Test;
import vampire_numbers.solution.FindVampireNumbers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FindVampireNumbersTest {
    private FindVampireNumbers n=new FindVampireNumbers();
    private ArrayList<Integer> arr=new ArrayList<>();
    @Test
    public void sameCharsTest1(){
        assertTrue(n.sameChars("abc","abc"));
    }
    @Test
    public void sameCharsTest2(){
        assertFalse(n.sameChars(null,null));
    }
    @Test
    public void sameCharsTest3(){
        assertTrue(n.sameChars("",""));
    }
    @Test
    public void sameCharsTest4(){
        assertTrue(n.sameChars("aabdc","cabad"));
    }
    @Test
    public void sameCharsTest5(){
        assertFalse(n.sameChars("abc","bcd"));
    }


    @Test
    public void generateTest1(){
        n.generate(arr,1);
        assertEquals(n.getCount(),0);
    }
    @Test
    public void generateTest2(){
        n.generate(arr,2);
        assertEquals(n.getCount(),0);
    }
    @Test
    public void generateTest3(){
        n.generate(arr,0);
        assertEquals(n.getCount(),0);
    }
    @Test
    public void generateTest4(){
        n.generate(arr,4);
        assertEquals(n.getCount(),7);
    }
    @Test
    public void generateTest5(){
        n.generate(arr,5);
        assertEquals(n.getCount(),7);
    }
}