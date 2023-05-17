import java.util.ArrayList;

public class GroupGenerator {

    SudokuBoard sudokuBoard;
    GroupDTO groupDTO = new GroupDTO(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

    public GroupGenerator(SudokuBoard sudokuBoard, GroupDTO groupDTO) {
        this.sudokuBoard = sudokuBoard;
        this.groupDTO = groupDTO;
    }

    private void generateGroups() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                groupDTO.columns().get(i).add(sudokuBoard.getRowList().get(j).getElementList().get(i));
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                groupDTO.rows().get(i).add(sudokuBoard.getRowList().get(i).getElementList().get(j));
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                groupDTO.sectors().get(0).add(sudokuBoard.getRowList().get(i).getElementList().get(j));
            }
        }

        for (int i = 3; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                groupDTO.sectors().get(1).add(sudokuBoard.getRowList().get(i).getElementList().get(j));
            }
        }

        for (int i = 6; i < 8; i++) {
            for (int j = 0; j < 3; j++) {
                groupDTO.sectors().get(2).add(sudokuBoard.getRowList().get(i).getElementList().get(j));
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 3; j < 6; j++) {
                groupDTO.sectors().get(3).add(sudokuBoard.getRowList().get(i).getElementList().get(j));
            }
        }

        for (int i = 3; i < 6; i++) {
            for (int j = 3; j < 6; j++) {
                groupDTO.sectors().get(4).add(sudokuBoard.getRowList().get(i).getElementList().get(j));
            }
        }

        for (int i = 6; i < 8; i++) {
            for (int j = 3; j < 6; j++) {
                groupDTO.sectors().get(5).add(sudokuBoard.getRowList().get(i).getElementList().get(j));
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 6; j < 9; j++) {
                groupDTO.sectors().get(6).add(sudokuBoard.getRowList().get(i).getElementList().get(j));
            }
        }

        for (int i = 3; i < 6; i++) {
            for (int j = 6; j < 9; j++) {
                groupDTO.sectors().get(7).add(sudokuBoard.getRowList().get(i).getElementList().get(j));
            }
        }

        for (int i = 6; i < 8; i++) {
            for (int j = 6; j < 9; j++) {
                groupDTO.sectors().get(8).add(sudokuBoard.getRowList().get(i).getElementList().get(j));
            }
        }
    }

}
