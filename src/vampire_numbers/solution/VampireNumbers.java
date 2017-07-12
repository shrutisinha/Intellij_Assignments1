package vampire_numbers.solution;


/*A vampire number v is a number with an even number of digits n,
 * that can be factored into two numbers x and y each with n/2 digits
 * and not both with trailing zeroes, where v contains precisely all the
 * digits from x and from y, in any order. Write a java program to print
 * first 100 vampire numbers.
 */
import java.lang.Integer;
import java.lang.String;
import java.lang.System;
import java.util.ArrayList;


public class VampireNumbers{
    public static void main(String[] args) {
        ArrayList<Integer> vamp= new ArrayList<>();
        int n=2;
        FindVampireNumbers obj=new FindVampireNumbers();
        while (obj.getCount()<100){
            obj.generate(vamp,n);
            n+=2;
        }
        while(vamp.size()>100)
            vamp.remove(100);
        System.out.println("The list of first "+vamp.size()+" vampire numbers are:");
        System.out.println(vamp);
        //System.out.println(vamp.size());
    }
}
