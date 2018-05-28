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

    //berlinClockEncode()will take time String as an input and it will return Encoded String pattern  
    public static String berlinClockEncode(String s) {
        String output = null;

        try {
            String[] splitStr = s.split(":");

            if (splitStr.length != 3) {
                //If splitStr.length is not equals to 3, throw below exception
                throw new ArrayIndexOutOfBoundsException();
            }
            //Executing getClock() from ClockFactory, which takes ClockAbstractFactory as an argument and returns Clock object
            Clock ss = berlinclock.ClockFactory.getClock(new SecondFactory(splitStr[2]));
            Clock hh = berlinclock.ClockFactory.getClock(new HourFactory(splitStr[0]));
            Clock min = berlinclock.ClockFactory.getClock(new MinuteFactory(splitStr[1]));
            
            //combine output from all different abstract factories 
            output = ss.toString() + hh.toString() + min.toString();
        } catch (Exception e) {
            
            //catching exception for ArrayIndexOutOfBounds and IllegalArgument and showing the below output
            output = "time is not valid";
        }
        return output;
    }

}
