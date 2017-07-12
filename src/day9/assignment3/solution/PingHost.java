/**Write a java function that will ping any host ( given as input ) and computes the median of
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
 * Program to ping a given hostname given number of times and calculate median time taken in
 * the process.
 */
class Pings {
    private String cmd;
    private int ping_no;
//    Pings(String s, int times){
//        cmd="ping -c "+times+" "+s;
//        this.ping_no =times;
//    }
//    Pings(String s){
//        cmd="ping -c 20 "+s;
//        this.ping_no =20;
//    }
//    private Pings(){
//
//    }

    /**
     * Method that pings the given hostname. It executes the ping command from the terminal and
     * time is found by reading lines from terminal. It prints the median time.
     * @param ip Hostname
     * @param num Number of times to ping, useful in calculating median
     */
    public void ping(String ip,int num){
        ping_no=num;
        cmd= String.format("ping -c %d %s", num, ip);
        try{
//            InetAddress inet = InetAddress.getByName(ip);
//            boolean reachable = inet.isReachable(70000);
//            if(!reachable){
//                System.out.println("Host not reachable");
//                return;
//            }
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
                return;
            }
            exec.destroy();
            r.close();
            System.out.printf("Number of pings = %d%n", ping_no);
            System.out.printf("The median of time taken to ping is %sms%n", MedianTime(time));
        }catch(IOException | InterruptedException e){
            e.printStackTrace();
        }
    }

    /**
     * Calculates median of all data in the list
     * @param list list of data
     * @return median of list
     */
    private float MedianTime(List<Float> list){
        Collections.sort(list);
        int nums=list.size();
        if(nums%2==0){
            return (list.get(nums/2-1)+list.get(nums/2))/2;
        }
        return list.get(nums / 2);
    }

}

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
