import java.util.ArrayList;

public class SudokuRow extends Prototype<SudokuRow> {
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

    public SudokuRow deepCopy() throws CloneNotSupportedException {
        SudokuRow clonedRow = super.clone();
        clonedRow.elementList = new ArrayList<>();
        for(int i=1; i<10; i++) {
            clonedRow.elementList.add(new SudokuElement());
        }
        for(int i=0; i<this.elementList.size(); i++) {
            clonedRow.elementList.get(i).setValue(this.elementList.get(i).getValue());
        }
        return clonedRow;
    }
}
