package tictactoe;

import java.util.Scanner;

public class Main {
    public static char[][] grid = new char[3][3];
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = '_';
            }
        }
        printGrid();
        int turn = 1;
        char ch;
        do {
            ch = turn % 2 == 0 ? 'O' : 'X';
            addNewEntry(ch);
            printGrid();
            turn++;
        } while (!isWon('X') && !isWon('O') && turn <= 9);
        printResult();

    }//___End of Main method

    //___________________________________________________ Method isWon _______________________________________________//
    public static boolean isWon(char playerSymbol) {
        int total = playerSymbol == 'X' ? 264 : 237;

        for (int i = 0; i < 3; i++) {
            if (grid[i][0] + grid[i][1] + grid[i][2] == total || grid[0][i] + grid[1][i] + grid[2][i] == total) { //For horizontal and vertical check
                return true;
            }
        }
        if (grid[0][0] + grid[1][1] + grid[2][2] == total || grid[2][0] + grid[1][1] + grid[0][2] == total) { //For Diagonal check
            return true;
        }
        return false;
    }
    //****************************************************************************************************************//

    //_______________________________________________ Method SkippedCount ____________________________________________//
    public static int skippedCount() {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == '_') {
                    count++;
                }
            }
        }
        return count;
    }
    //****************************************************************************************************************//

    //_______________________________________________ Method printGrid _______________________________________________//
    public static void printGrid() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(grid[i][j] == '_' ? "  " : grid[i][j] + " ");
            }
            System.out.print("|\n");
        }
        System.out.println("---------");
    }
    //****************************************************************************************************************//

    //_______________________________________________ Method addNewEntry _____________________________________________//
    public static void addNewEntry(char ch) {
        boolean entered = false;
        do {
            System.out.print("Enter the coordinates: ");
            int rowNo = sc.nextInt();
            int columnNo = sc.nextInt();
            if (rowNo <= 3 && columnNo <= 3) {
                if (grid[rowNo - 1][columnNo - 1] == '_') {
                    grid[rowNo - 1][columnNo - 1] = ch;
                    entered = true;
                } else {
                    System.out.print("This cell is occupied! Choose another one!");
                }

            } else {
                System.out.print("Coordinates should be from 1 to 3!");
            }
        } while (!entered);

    }
    //****************************************************************************************************************//

    //_______________________________________________ Method printResult _____________________________________________//
    public static void printResult() {
//        if (isWon('X') && isWon('O') || (skippedCount() >= 3 && !isWon('X') && !isWon('O') && str.charAt(8) != '_')) {
//            System.out.println("Impossible");
//        } else
        if (isWon('X')) {
            System.out.println("X wins");
        } else if (isWon('O')) {
            System.out.println("O wins");
        } else {
            System.out.println("Draw");
        }
    }
    //****************************************************************************************************************//
}//___End of class
