package berlinclock.Second;

import berlinclock.Clock;

public class Second extends Clock {
    //Value from Enum Clock_Pattern
    private String pattern_second = Clock_Pattern.PATTERN_SECOND.toString();
    private String OFF = Clock_Pattern.OFF.toString();

    private String sec;

    public Second(String sec) {
        this.sec = sec;
    }

    //Overriding method from Clock
    @Override
    public String getResult() {
        //parsing String to integer
        int s = Integer.parseInt(sec);
        
        if (s >= 0 && s < 60) {
            //check for every 2 seconds 
            if (s % 2 != 0) {
                this.sec = OFF;
            } else {
                this.sec= pattern_second;
            }
        } else {
            throw new IllegalArgumentException();
        }
        return this.sec;
    }
}
