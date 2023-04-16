import java.util.ArrayList;

public class SudokuRow {
    private ArrayList<SudokuElement> elementList;

    public SudokuRow() {
        elementList = new ArrayList<SudokuElement>();
        for(int i=1; i<10; i++) {
            elementList.add(new SudokuElement());
        }
    }

    public SudokuRow(ArrayList<SudokuElement> elementList) {
        this.elementList = elementList;
    }

    public ArrayList<SudokuElement> getElementList() {
        return elementList;
    }
}
