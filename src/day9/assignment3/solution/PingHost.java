/*Write a java function that will ping any host ( given as input ) and computes the median of
 * the time taken to ping. Use the system ping utility, do not use any deprecated methods.
 * Created by zemoso on 11/7/17.
 */
package day9.assignment3.solution;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Main class
 */
public class  PingHost{
    /**
     * Main function that takes hostname and number of pings from user and print the median time.
     * @param args not used
     * @throws IOException ince it takes input from user so IOException can be thrown
     */
    public static void main(String[] args)throws IOException {
        InputStreamReader isr= new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        System.out.println("Enter Host address");
        String ip=br.readLine();
        System.out.println("Enter number of times to ping");
        int num;
        num = Integer.parseInt(br.readLine());
        System.out.printf("Pinging %s%n", ip);
        Pings p=new Pings();
        p.ping(ip,num);
    }
}
