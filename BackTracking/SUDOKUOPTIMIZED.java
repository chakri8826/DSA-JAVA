public class SUDOKUOPTIMIZED {
    public static boolean isSafe(char[][] board, int R, int C, char ch) {
        for (int i = 0; i < 9; i++) {
            // Check current row
            if (board[R][i] == ch) {
                return false;
            }
            // Check current column
            if (board[R][C] == ch) {
                return false;
            }
            if(board[3*(R/3)+i/3][3*(C/3)+i%3]==ch){
                return false;
            }
        }
        return true;
    }

    public static boolean solveSudoku(char[][] board) {
        for(int r=0;r<9;r++){
            for(int c=0;c<9;c++){
                if (board[r][c] == '.') {
                    for (char ch = '1'; ch <= '9'; ch++) {
                        if (isSafe(board, r, c, ch)) {
                            board[r][c] = ch; // Try placing number
                            if (solveSudoku(board)) { // Recur
                                return true; // If solved, return true
                            }
                            board[r][c] = '.'; // Backtrack if not solved
                        }
                    }
                    return false; // If no number can be placed, return false
                }  
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char board[][] = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        if (solveSudoku(board)) {
            // Print the solved Sudoku board
            for (int r = 0; r < 9; r++) {
                for (int c = 0; c < 9; c++) {
                    System.out.print(board[r][c] + " "); // Print each element in a row
                }
                System.out.println(); // New line after each row
            }
        } else {
            System.out.println("No solution exists.");
        }
    }
}
