import java.util.ArrayList;

public class ValueChecker {

    SudokuBoard sudokuBoard;
    ArrayList<ArrayList<SudokuElement>> columns = new ArrayList<>();
    ArrayList<ArrayList<SudokuElement>> rows = new ArrayList<>();
    ArrayList<ArrayList<SudokuElement>> sectors = new ArrayList<>();
    boolean changesFlag = true;
    boolean error = false;

    public ValueChecker(SudokuGame game) {
        this.sudokuBoard = game.getBoard();
        for(int i=0; i<9; i++) {
            this.columns.add(new ArrayList<>());
            this.rows.add(new ArrayList<>());
            this.sectors.add(new ArrayList<>());
        }
    }

    private void generateGroups() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                columns.get(i).add(sudokuBoard.getRowList().get(j).getElementList().get(i));
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                rows.get(i).add(sudokuBoard.getRowList().get(i).getElementList().get(j));
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sectors.get(0).add(sudokuBoard.getRowList().get(i).getElementList().get(j));
            }
        }

        for (int i = 3; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                sectors.get(1).add(sudokuBoard.getRowList().get(i).getElementList().get(j));
            }
        }

        for (int i = 6; i < 8; i++) {
            for (int j = 0; j < 3; j++) {
                sectors.get(2).add(sudokuBoard.getRowList().get(i).getElementList().get(j));
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 3; j < 6; j++) {
                sectors.get(3).add(sudokuBoard.getRowList().get(i).getElementList().get(j));
            }
        }

        for (int i = 3; i < 6; i++) {
            for (int j = 3; j < 6; j++) {
                sectors.get(4).add(sudokuBoard.getRowList().get(i).getElementList().get(j));
            }
        }

        for (int i = 6; i < 8; i++) {
            for (int j = 3; j < 6; j++) {
                sectors.get(5).add(sudokuBoard.getRowList().get(i).getElementList().get(j));
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 6; j < 9; j++) {
                sectors.get(6).add(sudokuBoard.getRowList().get(i).getElementList().get(j));
            }
        }

        for (int i = 3; i < 6; i++) {
            for (int j = 6; j < 9; j++) {
                sectors.get(7).add(sudokuBoard.getRowList().get(i).getElementList().get(j));
            }
        }

        for (int i = 6; i < 8; i++) {
            for (int j = 6; j < 9; j++) {
                sectors.get(8).add(sudokuBoard.getRowList().get(i).getElementList().get(j));
            }
        }
    }

    private boolean possibleValuesChecker() {
        for(ArrayList<SudokuElement> list :  columns) {
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

        for(ArrayList<SudokuElement> list :  rows) {
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

        for(ArrayList<SudokuElement> list :  sectors) {
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

    private void valueInsert() {
        outer: for(ArrayList<SudokuElement> list :  columns) {
            for (SudokuElement elementChecked : list) {
                if(elementChecked.getPossibleValues().size()==1 && elementChecked.getValue()==-1) {
                    for(int i = 1; i<10; i++){
                        if(elementChecked.getPossibleValues().contains(i)){
                            elementChecked.setValue(i);
                            changesFlag = true;
                        }
                    }
                } else if (elementChecked.getPossibleValues().size()<1 && elementChecked.getValue()==-1) {
                    System.out.println("This sudoku has no solution4.");
                    error = true;
                    break outer;
                }
            }
        }
    }

    public void valueCheck() {
        generateGroups();
        while(changesFlag) {
            changesFlag = false;
            possibleValuesChecker();
            valueInsert();
            if(error) {
                break;
            }
            if(!changesFlag){
                ValueGuesser.guess();
            }
        }
        BoardGenerator.generateBoard(sudokuBoard);
    }
}
