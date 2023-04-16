import java.util.Scanner;

public class PlayerInput {
    public static void getValueFromPlayer(SudokuGame game) {
        System.out.println("enter the data in the format x,y,z where x is the column number, y is the row number and z is the value");
        boolean finished = false;
        while(!finished) {
            System.out.print("Your input: ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (input.matches("^[1-9]{1},{1}[1-9]{1},{1}[1-9]{1}")) {
                System.out.println(input.charAt(0) + "," + input.charAt(2) + "," + input.charAt(4) + " - correct input");
                game.getBoard().putNewValue(new FieldDTO(
                    Character.getNumericValue(input.charAt(0)),
                    Character.getNumericValue(input.charAt(2)),
                    Character.getNumericValue(input.charAt(4))
                ));
            } else if (input.equals("SUDOKU")) {
                finished = true;
                System.out.println("SOLVING SUDOKU NOW");
                game.resolveSudoku();
            } else {
                System.out.println(input + " - wrong format - enter the data again");
            }
        }
    }
}
