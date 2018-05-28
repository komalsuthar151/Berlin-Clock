package berlinclock;

import java.awt.Color;
import static java.awt.Color.yellow;

public abstract class Clock {

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

    //Method to get result from all subclasses
    public abstract String getResult();

    @Override
    public String toString() {
        return this.getResult();
    }
}
