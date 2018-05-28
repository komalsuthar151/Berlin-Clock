package berlinclock;

//Abstract factory interface will be implemented by sub-class factory methods
public interface ClockAbstractFactory {
    
    //createclock() is returning an instance of super class Clock. 
    //factory classes like SecondFactory, MinuteFactory, HourFactory 
    //will implement ClockAbstractFactory interface and return instances of their respective sub-class.
    public Clock createclock();

}
