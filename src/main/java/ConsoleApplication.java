import java.util.Scanner;

public class ConsoleApplication {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws CloneNotSupportedException {

        boolean doYouWannaContinue = true;

        while(doYouWannaContinue) {
            SudokuGame sudokuGame = new SudokuGame();

            BoardGenerator.generateBoard(sudokuGame.getBoard());

            PlayerInput.getValueFromPlayer(sudokuGame);

            SolvingAlgorithm.solve(sudokuGame);

            System.out.println("type Y if you want to continue with new board; " +
                    "\ntype anything else to close the application");
            String input = scanner.nextLine();
            if(!(input.equals("Y") || input.equals("y"))){
                doYouWannaContinue = false;
            }
        }
    }
}
