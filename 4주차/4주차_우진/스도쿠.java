import java.util.*;

public class 스도쿠 {
    public static int[][] arr = new int[9][9];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                arr[i][j] = sc.nextInt();
        sudoku(0, 0);
    }

    public static void sudoku(int row, int col) {
        if (col == 9) {
            sudoku(row + 1, 0);
            return;
        }
        if (row == 9) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
            System.exit(0);
        }
        if (arr[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (possibility(row, col, i)) {
                    arr[row][col] = i;
                    sudoku(row, col + 1);
                }
            }
            arr[row][col] = 0;
            return;
        }
        sudoku(row, col + 1);
    }

    public static boolean possibility(int row, int col, int value) {
        for (int i = 0; i < 9; i++)
            if (arr[row][i] == value)
                return false;
        for (int i = 0; i < 9; i++)
            if (arr[i][col] == value)
                return false;
        for (int i = (row / 3) * 3; i < (row / 3) * 3 + 3; i++)
            for (int j = (col / 3) * 3; j < (col / 3) * 3 + 3; j++)
                if (arr[i][j] == value)
                    return false;
        return true;
    }
}