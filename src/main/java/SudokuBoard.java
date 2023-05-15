import java.util.ArrayList;

public class SudokuBoard extends Prototype<SudokuBoard> {
    private ArrayList<SudokuRow> rowList;

    public SudokuBoard() {
        rowList = new ArrayList<SudokuRow>();
        for(int i=1; i<10; i++) {
            rowList.add(new SudokuRow());
        }
    }

    public ArrayList<SudokuRow> getRowList() {
        return rowList;
    }

    public void putNewValue(FieldDTO fieldDTO) {
            rowList.get(fieldDTO.row() - 1).getElementList().get(fieldDTO.column() - 1).setValue(fieldDTO.value());
            BoardGenerator.generateBoard(this);
    }

    public SudokuBoard deepCopy() throws CloneNotSupportedException {
        SudokuBoard clonedBoard = super.clone();
        clonedBoard.rowList = new ArrayList<>();
        for(int i=0; i<this.rowList.size(); i++) {
            clonedBoard.rowList.add(i, this.rowList.get(i).deepCopy());
        }
        return clonedBoard;
    }

}
