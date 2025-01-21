package Recursion_backtracking;

public class N_Queens_Problem {

    public static void main(String[] args) {
        int n = 4;
        char[][] arr = new char[n][n];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = '.';
            }
        }
        nQueens(arr, 0);
    }

    public static void print(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-----------");
    }

    public static boolean isSafe(char[][] arr, int row, int col) {
        // Checking column
        for (int i = 0; i < row; i++) {
            if (arr[i][col] == 'Q') {
                return false;
            }
        }
        // Checking diagonal 1
        for (int i = row - 1, j = col + 1; i >= 0 && j < arr[0].length; i--, j++) {
            if (arr[i][j] == 'Q') {
                return false;
            }
        }
        // Checking diagonal 2
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (arr[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void nQueens(char[][] arr, int row) {
        if (row == arr.length) {
            // Decided for every row;
            print(arr);
            return;
        }

        for (int col = 0; col < arr[0].length; col++) {
            if (isSafe(arr, row, col)) {
                arr[row][col] = 'Q';
                nQueens(arr, row + 1);
                arr[row][col] = '.';
            }
        }
    }
}

