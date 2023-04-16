import java.util.ArrayList;

public class BoardGenerator {
    public static void generateBoard(SudokuBoard board) {
        System.out.println("-------------------");
        for(SudokuRow row : board.getRowList()) {
            System.out.print("|");
            for (SudokuElement e : row.getElementList()) {
                if(e.getValue()==-1) {
                    System.out.print(" |");
                } else {
                    System.out.print(e.getValue() + "|");
                }
            }
            System.out.println();
        }
        System.out.println("-------------------");
    }
}
