package berlinclock.Minute;

import berlinclock.Clock;
import berlinclock.ClockAbstractFactory;

public class MinuteFactory implements ClockAbstractFactory{

    String min;
    public MinuteFactory(String min){
    this.min=min;
    }
    
    //returning Minute class object using createclock()
    @Override
    public Clock createclock() {
        return new Minute(min);
    }
    
}
