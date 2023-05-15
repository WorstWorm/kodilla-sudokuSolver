import java.util.Scanner;

public class ConsoleApplication {

    public static void main(String[] args) {
        boolean doYouWannaContinue = true;
        while(doYouWannaContinue) {
            System.out.println("loop");
            SudokuGame sudokuGame = new SudokuGame();
            BoardGenerator.generateBoard(sudokuGame.getBoard());
            PlayerInput.getValueFromPlayer(sudokuGame);
            ValueChecker valueChecker = new ValueChecker(sudokuGame);
            valueChecker.valueCheck();
            Scanner scanner = new Scanner(System.in);
            System.out.println("type Y if you want to continue with new board; \ntype anything else to close the application");
            String input = scanner.nextLine();
            if(!(input.equals("Y") || input.equals("y"))){
                doYouWannaContinue = false;
            }
        }
    }
}
