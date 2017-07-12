package day9.assignment3.solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Program to ping a given hostname given number of times and calculate median time taken in
 * the process.
 */
public class Pings {
    private String cmd;
    private int ping_no;
    /**
     * Method that pings the given hostname. It executes the ping command from the terminal and
     * time is found by reading lines from terminal. It prints the median time.
     * @param ip Hostname
     * @param num Number of times to ping, useful in calculating median
     */
    public boolean ping(String ip, int num){
        ping_no=num;
        cmd= String.format("ping -c %d %s", num, ip);
        try{
            Process exec = Runtime.getRuntime().exec(cmd);
            System.out.printf("Command: %s%n", cmd);

            exec.waitFor();
            BufferedReader r = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            List<Float> time = new ArrayList<>();
            int c = 0;
            String line;
            try{
                while((line=r.readLine()) != null) {

                    String[] tokens = line.split(" ");

                    if ((c > 0) && (c <= ping_no)) {
                        time.add(Float.valueOf(tokens[7].substring(5)));
                    }

                    c++;
                }
            }catch(ArrayIndexOutOfBoundsException | NumberFormatException e){
                System.out.println("Host not responding to ping");
                return false;
            }
            exec.destroy();
            r.close();
            System.out.printf("Number of pings = %d%n", ping_no);
            if(time.size()==0)
                return false;
            System.out.printf("The median of time taken to ping is %sms%n", MedianTime(time));

        }catch(IOException | InterruptedException  e){
            e.printStackTrace();
        }
        return true;
    }

    /**
     * Calculates median of all data in the list
     * @param list list of data
     * @return median of list
     */
    private float MedianTime(List<Float> list){
        if(list.size()==0)return 0;
        Collections.sort(list);
        int nums=list.size();
        if(nums%2==0){
            return (list.get(nums/2-1)+list.get(nums/2))/2;
        }
        return list.get(nums / 2);
    }

}
