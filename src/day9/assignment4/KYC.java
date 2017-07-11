package day9.assignment4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by zemoso on 11/7/17.
 */
class KYCFilling{

}
public class KYC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter signup date and current date in 'dd-mm-yyyy' format seperated by space");
        String[] s=br.readLine().split(" ");
        String[] signup_date=s[0].split("-");
        String[] current_date=s[1].split("-");


    }
}
