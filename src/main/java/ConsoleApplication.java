public class ConsoleApplication {

    public static void main(String[] args) {
        SudokuGame sudokuGame = new SudokuGame();
        BoardGenerator.generateBoard(sudokuGame.getBoard());
        PlayerInput.getValueFromPlayer(sudokuGame);
        ValueChecker valueChecker = new ValueChecker(sudokuGame);
        valueChecker.valueCheck();

//        boolean gameFinished = false;
//
//        while(!gameFinished){
//            SudokuGame theGame = new SudokuGame();
//            gameFinished = theGame.resolveSudoku();
//        }
    }
}
