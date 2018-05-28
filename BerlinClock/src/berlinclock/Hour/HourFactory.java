package berlinclock.Hour;

import berlinclock.Clock;
import berlinclock.ClockAbstractFactory;

public class HourFactory implements ClockAbstractFactory{

    private String hour;
    public HourFactory(String hour){
         this.hour= hour;
    }
    
    //returning Hours class object using createclock()
    @Override
    public Clock createclock() {
        return new Hour(hour);
    }
}
