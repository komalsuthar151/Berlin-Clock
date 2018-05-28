package berlinclock;

import java.awt.Color;


//Clock is an abstract class that defines the getResult() for all sub classes to be implement
//contains enum classes for pattern and color
public abstract class Clock {

    //Enum class for Color 
    public enum Clock_Color {

        YELLOW(Color.yellow),
        RED(Color.RED),
        GRAY(Color.gray);

        private Color value;

        private Clock_Color(Color value) {
            this.value = value;
        }

        public Color getValue() {
            return value;
        }

        public void setValue(Color value) {
            this.value = value;
        }

    }

    //Enum class for String pattern  
    public enum Clock_Pattern {
        OFF("O"),
        PATTERN_FIRST("R"),
        PATTERN_SECOND("Y");

        private String value;

        private Clock_Pattern(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public abstract String getResult();

    @Override
    public String toString() {
        return this.getResult();
    }
}
