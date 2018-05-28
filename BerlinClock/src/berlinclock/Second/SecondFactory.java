package berlinclock.Second;

import berlinclock.Clock;
import berlinclock.ClockAbstractFactory;

public class SecondFactory implements ClockAbstractFactory {

    private String sec;
    
    //sec value from input
    public SecondFactory(String sec) {
        this.sec = sec;
    }

    //returning Second class object using createclock()
    @Override
    public Clock createclock() {
        return new Second(sec);
    }

}
