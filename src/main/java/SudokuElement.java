import java.util.ArrayList;
import java.util.HashSet;

public class SudokuElement {
    private int value;
    private HashSet<Integer> possibleValues;

    public static int EMPTY = -1;

    public SudokuElement() {
        this.value = EMPTY;
        this.possibleValues = new HashSet<>();
        for(int i=1; i<10; i++) {
            possibleValues.add(i);
        }
    }

    public SudokuElement(int value) {
        this.value = value;
        this.possibleValues = new HashSet<>();
        for(int i=1; i<10; i++) {
            possibleValues.add(i);
        }
    }

    public int getValue() {
        return value;
    }

    public HashSet<Integer> getPossibleValues() {
        return possibleValues;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void removePossibleValue(int value) {
        possibleValues.remove(value);
    }

}
