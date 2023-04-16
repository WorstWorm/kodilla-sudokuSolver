import com.sun.jdi.Value;

import java.util.ArrayList;

public class ValueChecker {

    SudokuBoard sudokuBoard;
    ArrayList<ArrayList<SudokuElement>> columns = new ArrayList<ArrayList<SudokuElement>>();
    ArrayList<ArrayList<SudokuElement>> rows = new ArrayList<ArrayList<SudokuElement>>();
    ArrayList<ArrayList<SudokuElement>> sectors = new ArrayList<ArrayList<SudokuElement>>();

    public ValueChecker(SudokuGame game) {
        this.sudokuBoard = game.getBoard();
        for(int i=0; i<9; i++) {
            this.columns.add(new ArrayList<SudokuElement>());
            this.rows.add(new ArrayList<SudokuElement>());
            this.sectors.add(new ArrayList<SudokuElement>());
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

    private void possibleValuesChecker() {
        for(ArrayList<SudokuElement> list :  columns) {
            for(SudokuElement elementChecked : list) {
                int tempValue = elementChecked.getValue();
                for(SudokuElement elementModified : list) {
                    elementModified.removePossibleValue(tempValue);
                }
            }
        }

        for(ArrayList<SudokuElement> list :  rows) {
            for(SudokuElement elementChecked : list) {
                int tempValue = elementChecked.getValue();
                for(SudokuElement elementModified : list) {
                    elementModified.removePossibleValue(tempValue);
                }
            }
        }

        for(ArrayList<SudokuElement> list :  sectors) {
            for(SudokuElement elementChecked : list) {
                int tempValue = elementChecked.getValue();
                for(SudokuElement elementModified : list) {
                    elementModified.removePossibleValue(tempValue);
                }
            }
        }
    }

    private void valueInsert() {
        for(ArrayList<SudokuElement> list :  columns) {
            for (SudokuElement elementChecked : list) {
                for(Integer i=0; i<9; i++) {
                    if(elementChecked.getPossibleValues().contains(i)) {
                        elementChecked.setValue(i);
                        possibleValuesChecker();
                        break;
                    }
                }
            }
        }

        for(ArrayList<SudokuElement> list :  rows) {
            for (SudokuElement elementChecked : list) {
                for(Integer i=0; i<9; i++) {
                    if(elementChecked.getPossibleValues().contains(i)) {
                        elementChecked.setValue(i);
                        possibleValuesChecker();
                        break;
                    }
                }
            }
        }

        for(ArrayList<SudokuElement> list :  sectors) {
            for (SudokuElement elementChecked : list) {
                for(Integer i=0; i<9; i++) {
                    if(elementChecked.getPossibleValues().contains(i)) {
                        elementChecked.setValue(i);
                        possibleValuesChecker();
                        break;
                    }
                }
            }
        }
    }

    public void valueCheck() {
        generateGroups();
        possibleValuesChecker();
        valueInsert();
        BoardGenerator.generateBoard(sudokuBoard);
    }
}
