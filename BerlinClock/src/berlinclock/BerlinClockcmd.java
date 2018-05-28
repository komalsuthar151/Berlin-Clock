package berlinclock;

import static berlinclock.BerlinClock.berlinClockEncode;
import java.util.Scanner;

public class BerlinClockcmd {
    
        public static void main(String[] args) {
        //input from user 
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter time:");
        String s = sc.next();
        //print the berlin clock encoded pattern
        System.out.println(berlinClockEncode(s));
    }

    
}
