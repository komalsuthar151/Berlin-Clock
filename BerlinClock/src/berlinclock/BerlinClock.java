package berlinclock;

import berlinclock.Hour.HourFactory;
import berlinclock.Minute.MinuteFactory;
import berlinclock.Second.SecondFactory;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BerlinClock extends JFrame {

    //Design pattern- Abstract Factory Pattern
    public BerlinClock() {

    }

    public static void main(String[] args) {
        
        //input from user 
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter time:");
        String s = sc.next();
        //Berlin bp = new Berlin();
        //String s = bp.getTime();

        System.out.println(berlinClockDecode(s));
    }

    
    public static String berlinClockDecode(String s) {
        String output = null;

        //Catching the Exception using try catch
        try {
            String[] splitStr = s.split(":");

            if (splitStr.length != 3) {
                //handling ArrayIndexOutOfBoundsException
                throw new ArrayIndexOutOfBoundsException();
            }
            //abstract factory class will return sub class based on the input factory class 
            Clock ss = berlinclock.ClockFactory.getClock(new SecondFactory(splitStr[2]));
            Clock hh = berlinclock.ClockFactory.getClock(new HourFactory(splitStr[0]));
            Clock min = berlinclock.ClockFactory.getClock(new MinuteFactory(splitStr[1]));
            
            //combine output from all different abstract factories 
            output = ss.toString() + hh.toString() + min.toString();
        } catch (Exception e) {
            output = "time is not valid";
        }
        return output;
    }

}
