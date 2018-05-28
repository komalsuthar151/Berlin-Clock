package berlinclock;

//this class will be entry point for the Clock class to create sub classes
public class ClockFactory {

    //getClock() is accepting ClockAbstractFactory argument and returning Clock object
    public static Clock getClock(ClockAbstractFactory factory) {
        return factory.createclock();
    }
    
}
