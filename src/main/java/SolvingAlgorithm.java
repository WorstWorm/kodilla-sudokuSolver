public class SolvingAlgorithm {
    public static void solve(SudokuGame sudokuGame) throws CloneNotSupportedException {
        SudokuBoard sudokuBoard = sudokuGame.getBoard();
        ValueChecker valueChecker = new ValueChecker(sudokuGame.getBoard());

        boolean finished = false;
        boolean changesHaveBeenMade = false;

        while(!finished) {
            valueChecker.valueCheck();

            finished = true;

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (sudokuBoard.getRowList().get(i).getElementList().get(j).getValue() == -1) {
                        finished = false;
                    }
                }
            }
        }
    }
}
