/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import berlinclock.BerlinClock;
import berlinclock.Hour.HourFactory;
import berlinclock.Minute.MinuteFactory;
import berlinclock.Second.SecondFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BerlinTest {

    public BerlinTest() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    //Second should set to "O" every two seconds
    @Test
    public void testforTwoSeconds() {
        Assert.assertEquals("Y", berlinclock.ClockFactory.getClock(new SecondFactory("0")).getResult());
        Assert.assertEquals("O", berlinclock.ClockFactory.getClock(new SecondFactory("1")).getResult());
        Assert.assertEquals("O", berlinclock.ClockFactory.getClock(new SecondFactory("59")).getResult());
    }
    
    //for every value multiple of 5 it shoud set to "R" remaining "O" //first row
    //for every value modulo of 5 it shouls set to "R" remaining "O" //second row
    @Test
    public void testforHourFirstandSecondrow() {
        Assert.assertEquals("OOOOOOOO", berlinclock.ClockFactory.getClock(new HourFactory("0")).getResult());
        Assert.assertEquals("RROORRRO", berlinclock.ClockFactory.getClock(new HourFactory("13")).getResult());
        Assert.assertEquals("RRRRRRRO", berlinclock.ClockFactory.getClock(new HourFactory("23")).getResult());
    }

    //for every value multiple of 5 Pattern should be "YYRYYR" instead "OOOOOO" //third row
    //for every value modulo of 5 it shouls set to "Y" remaining "O" //forth row
    @Test
    public void testforMinuteThirdandForthrow() {
        Assert.assertEquals("OOOOOOOOOOOOOOO", berlinclock.ClockFactory.getClock(new MinuteFactory("0")).getResult());
        Assert.assertEquals("YYOOOOOOOOOYYYO", berlinclock.ClockFactory.getClock(new MinuteFactory("13")).getResult());
        Assert.assertEquals("YYRYYOOOOOOOOOO", berlinclock.ClockFactory.getClock(new MinuteFactory("25")).getResult());
        Assert.assertEquals("YYRYYRYYRYYYOOO", berlinclock.ClockFactory.getClock(new MinuteFactory("56")).getResult());
       
    }

    //Testing for input String
    @Test
    public void testForMainInput() {
        berlinclock.BerlinClock b = new BerlinClock();
        Assert.assertEquals("YRROOOOOOYYRYYROOOOOYOOO", b.berlinClockEncode("10:31:40"));
        Assert.assertEquals("ORRRRRROOYYRYYRYYRYYYYYY", b.berlinClockEncode("22:59:41"));
        Assert.assertEquals("time is not valid", b.berlinClockEncode("22:59:61")); 
        Assert.assertEquals("time is not valid", b.berlinClockEncode("bogus"));
    }
    
    //testing for unexpected values
    @Test(expected = IllegalArgumentException.class)
    public void SecondshouldThrow() {
       berlinclock.ClockFactory.getClock(new SecondFactory("61")).getResult();
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void MinuteshouldThrow() {
       berlinclock.ClockFactory.getClock(new MinuteFactory("61")).getResult();
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void HourshouldThrow() {
       berlinclock.ClockFactory.getClock(new HourFactory("24")).getResult();
    }
}
