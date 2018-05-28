package berlinclock;

public class ClockFactory {

    //getClock() is accepting ClockAbstractFactory argument and returning Clock object
    public static Clock getClock(ClockAbstractFactory factory) {
        return factory.createclock();
    }
    
}
