import java.util.ArrayList;

public class SudokuBoard {
    private ArrayList<SudokuRow> rowList;

    public SudokuBoard() {
        rowList = new ArrayList<SudokuRow>();
        for(int i=1; i<10; i++) {
            rowList.add(new SudokuRow());
        }
    }

    //do usunięcia ==================================================
    public SudokuBoard(boolean mock) {
        rowList = new ArrayList<>();

        for(int i=0; i<9; i++) {
            ArrayList<SudokuElement> elementList = new ArrayList<>();
            for(int j=0; j<9; j++) {
                elementList.add(new SudokuElement(j));
            }
            SudokuRow row = new SudokuRow(elementList);
            rowList.add(row);
        }
    }
    //===============================================================

    public ArrayList<SudokuRow> getRowList() {
        return rowList;
    }

    public void putNewValue(FieldDTO fieldDTO) {
            rowList.get(fieldDTO.row() - 1).getElementList().get(fieldDTO.column() - 1).setValue(fieldDTO.value());
            BoardGenerator.generateBoard(this);
    }

}
