package berlinclock.Hour;

import berlinclock.Clock;

public class Hour extends Clock {

    private String hour;

    //Using values from enum Clock_Pattern
    private String pattern_first = Clock_Pattern.PATTERN_FIRST.toString();
    private String off_light = Clock_Pattern.OFF.toString();
    String off = new String(new char[4]).replace("\0", off_light);

    public Hour(String hour) {
        this.hour = hour;
    }

    //implementing Abstract method from Clock
    @Override
    public String getResult() {
        int h = Integer.parseInt(hour);

        //setting constrains
        if (h >= 0 && h < 24) {
            //combine 5 hour row and 1 hour row
            this.hour = getFirstrow(h) + "" + getSecondrow(h);
        } else {
            //handling IllegalArgumentException
            throw new IllegalArgumentException();
        }
        return this.hour;
    }

    public String getFirstrow(int hours) {

        StringBuilder first_row = new StringBuilder(off);
        //Checking for the number of hour which are multiple of 5
        for (int i = 0; i < (hours / 5); i++) {
            //replace off to Red for 5 hour
            first_row.replace(i, i + 1, pattern_first);
        }

        return first_row.toString();

    }

    public String getSecondrow(int hours) {

        StringBuilder second_row = new StringBuilder(off);
        //Checking for the number of hour which are modulo of 5
        for (int i = 0; i < (hours % 5); i++) {
            //replace off to Red for 1 hour
            second_row.replace(i, i + 1, pattern_first);
        }
        return second_row.toString();
    }

}
