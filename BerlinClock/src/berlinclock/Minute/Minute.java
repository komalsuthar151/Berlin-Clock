package berlinclock.Minute;

import berlinclock.Clock;

public class Minute extends Clock {

    private String min;

    //Using values from enum Clock_Pattern
    private String pattern_first = Clock_Pattern.PATTERN_FIRST.toString();
    private String pattern_second = Clock_Pattern.PATTERN_SECOND.toString();
    private String z_off = Clock_Pattern.OFF.toString();
    String third = new String(new char[11]).replace("\0", z_off);
    String forth = new String(new char[4]).replace("\0", z_off);

    public Minute(String min) {
        this.min = min;
    }

    //implementing Abstract method from Clock
    @Override
    public String getResult() {
        
        int minute = Integer.parseInt(min);
        
        //setting constrains
        if (minute >= 0 && minute < 60) {
            
            //combine 5 min row and 1 min row
            this.min = getThirdrow(minute) + "" + getForthrow(minute);
        } else {
            //handling IllegalArgumentException
            throw new IllegalArgumentException();
        }
        return this.min;
    }

    public String getThirdrow(int min) {
        StringBuilder third_row = new StringBuilder(third);
        //Checking for the number of min which are multiple of 5
        for (int i = 0; i < min/5; i++) {
            //set every third light as pattern_first from off
            if ((i + 1) % 3 == 0) {
                third_row.replace(i, i + 1, pattern_first);
            } else {
                //set off to pattern_second
                third_row.replace(i, i + 1, pattern_second);
            }
        }
        return third_row.toString();

    }

    private String getForthrow(int min) {

        StringBuilder forth_row = new StringBuilder(forth);
        //Checking for the number of min which are modulo of 5
        for (int i = 0; i < min%5; i++) {
            //set off to pattern_second
            forth_row.replace(i, i + 1, pattern_second);
        }
        return forth_row.toString();
    }

}
