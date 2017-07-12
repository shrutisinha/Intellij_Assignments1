/*Java Assignment 2
 */
package day9.assignment2.solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Main class.
 * Program to calculate whether the input by the user contains all letters from a-z
 */
public class Alphabets {

    /**
     * Main function that takes input
     * @param args not used
     * @throws IOException as using input stream for taking input from user
     */
    public static void main(String args[]) throws IOException{
        InputStreamReader isr= new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        System.out.println("Enter a string");
        String s = br.readLine();
        boolean res=new CheckAlphabets().checker(s);
        if(res)
            System.out.println("The string contains all letters from a-z case insensitive");
        else
            System.out.println("The string does not contain all letters from a-z");
    }
}
