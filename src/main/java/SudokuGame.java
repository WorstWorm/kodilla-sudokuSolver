public class SudokuGame {

    SudokuBoard board;

    public SudokuGame() {
        this.board = new SudokuBoard();
        //MOCK DATA
        this.getBoard().putNewValue(new FieldDTO(1,1,5));
        this.getBoard().putNewValue(new FieldDTO(2,1,3));
        this.getBoard().putNewValue(new FieldDTO(5,1,7));

        this.getBoard().putNewValue(new FieldDTO(1,2,6));
        this.getBoard().putNewValue(new FieldDTO(4,2,1));
        this.getBoard().putNewValue(new FieldDTO(5,2,9));
        this.getBoard().putNewValue(new FieldDTO(6,2,5));

        this.getBoard().putNewValue(new FieldDTO(2,3,9));
        this.getBoard().putNewValue(new FieldDTO(3,3,8));
        this.getBoard().putNewValue(new FieldDTO(8,3,6));

        this.getBoard().putNewValue(new FieldDTO(1,4,8));
        this.getBoard().putNewValue(new FieldDTO(5,4,6));
        this.getBoard().putNewValue(new FieldDTO(9,4,3));

        this.getBoard().putNewValue(new FieldDTO(1,5,4));
        this.getBoard().putNewValue(new FieldDTO(4,5,8));
        this.getBoard().putNewValue(new FieldDTO(6,5,3));
        this.getBoard().putNewValue(new FieldDTO(9,5,1));

        this.getBoard().putNewValue(new FieldDTO(1,6,7));
        this.getBoard().putNewValue(new FieldDTO(5,6,2));
        this.getBoard().putNewValue(new FieldDTO(9,6,6));

        this.getBoard().putNewValue(new FieldDTO(2,7,6));
        this.getBoard().putNewValue(new FieldDTO(7,7,2));
        this.getBoard().putNewValue(new FieldDTO(8,7,8));

        this.getBoard().putNewValue(new FieldDTO(4,8,4));
        this.getBoard().putNewValue(new FieldDTO(5,8,1));
        this.getBoard().putNewValue(new FieldDTO(6,8,9));
        this.getBoard().putNewValue(new FieldDTO(9,8,5));

        this.getBoard().putNewValue(new FieldDTO(5,9,8));
        this.getBoard().putNewValue(new FieldDTO(8,9,7));
        this.getBoard().putNewValue(new FieldDTO(9,9,9));
        //=============================================================
    }

    boolean resolveSudoku() {
        return false;
    }

    public SudokuBoard getBoard() {
        return board;
    }
}
