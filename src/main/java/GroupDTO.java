import java.util.ArrayList;

public record GroupDTO(ArrayList<ArrayList<SudokuElement>> columns,
                       ArrayList<ArrayList<SudokuElement>> rows,
                       ArrayList<ArrayList<SudokuElement>> sectors) {
}
