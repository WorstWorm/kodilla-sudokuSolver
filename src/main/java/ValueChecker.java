import java.util.ArrayList;

public class ValueChecker {

    SudokuBoard sudokuBoard;

    GroupDTO groupDTO = new GroupDTO(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
    boolean error = false;

    public ValueChecker(SudokuBoard sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
        for(int i=0; i<9; i++) {
            this.groupDTO.columns().add(new ArrayList<>());
            this.groupDTO.rows().add(new ArrayList<>());
            this.groupDTO.sectors().add(new ArrayList<>());
        }
    }

    private boolean possibleValuesChecker() {
        for(ArrayList<SudokuElement> list :  groupDTO.columns()) {
            for(SudokuElement elementChecked : list) {
                int tempValue = elementChecked.getValue();
                for(SudokuElement elementWithValue : list)  {
                    if(!elementChecked.equals(elementWithValue) && elementChecked.getValue() == elementWithValue.getValue() && elementChecked.getValue()!=-1) {
                        System.out.println("This sudoku has no solution.");
                        return false;
                    }
                }
                for(SudokuElement elementModified : list) {
                    elementModified.removePossibleValue(tempValue);
                }
            }
        }

        for(ArrayList<SudokuElement> list :  groupDTO.rows()) {
            for(SudokuElement elementChecked : list) {
                int tempValue = elementChecked.getValue();
                for(SudokuElement elementWithValue : list)  {
                    if(!elementChecked.equals(elementWithValue) && elementChecked.getValue() == elementWithValue.getValue() && elementChecked.getValue()!=-1) {
                        System.out.println("This sudoku has no solution.");
                        return false;
                    }
                }
                for(SudokuElement elementModified : list) {
                    elementModified.removePossibleValue(tempValue);
                }
            }
        }

        for(ArrayList<SudokuElement> list :  groupDTO.sectors()) {
            for(SudokuElement elementChecked : list) {
                int tempValue = elementChecked.getValue();
                for(SudokuElement elementWithValue : list)  {
                    if(!elementChecked.equals(elementWithValue) && elementChecked.getValue() == elementWithValue.getValue() && elementChecked.getValue()!=-1) {
                        System.out.println("This sudoku has no solution3.");
                        return false;
                    }
                }
                for(SudokuElement elementModified : list) {
                    elementModified.removePossibleValue(tempValue);
                }
            }
        }
        return true;
    }

    private boolean valueInsert() {
        boolean changesHaveBeenMade = false;
        outer: for(ArrayList<SudokuElement> list :  groupDTO.columns()) {
            for (SudokuElement elementChecked : list) {
                if(elementChecked.getPossibleValues().size()==1 && elementChecked.getValue()==-1) {
                    for(int i = 1; i<10; i++){
                        if(elementChecked.getPossibleValues().contains(i)){
                            elementChecked.setValue(i);
                            changesHaveBeenMade = true;
                        }
                    }
                } else if (elementChecked.getPossibleValues().size()<1 && elementChecked.getValue()==-1) {
                    System.out.println("This sudoku has no solution4.");
                    error = true;
                    break outer;
                }
                return changesHaveBeenMade;
            }
        }
    }

    public void valueCheck() throws CloneNotSupportedException {
        generateGroups();
        while(changesFlag) {
            changesFlag = false;
            possibleValuesChecker();
            valueInsert();
            if(error) {
                break;
            }
            if(!changesFlag){
                System.out.println("guess");
                }
            }
        BoardGenerator.generateBoard(sudokuBoard);
    }
}
