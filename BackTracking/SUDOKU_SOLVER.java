// public class SUDOKU_SOLVER {
//     public static boolean isSafe(char[][] board, int R, int C, int i) {
//         // Check current row
//         for (int c = 0; c < 9; c++) {
//             if (board[R][c] == (char) (i + '0')) {
//                 return false;
//             }
//         }
//         // Check current column
//         for (int r = 0; r < 9; r++) {
//             if (board[r][C] == (char) (i + '0')) {
//                 return false;
//             }
//         }
//         // Check 3x3 subgrid
//         int sr = (R / 3) * 3;
//         int sc = (C / 3) * 3;
//         for (int r = sr; r < sr + 3; r++) {
//             for (int c = sc; c < sc + 3; c++) {
//                 if (board[r][c] == (char) (i + '0')) {
//                     return false;
//                 }
//             }
//         }
//         return true;
//     }


//     public static boolean solveSudoku(char[][] board, int r, int c) {
//         // Base case: if we reached the end of the board
//         if (r == 9) return true;
//         // Move to the next row if we reached the end of the current row
//         if (c == 9) {
//             return solveSudoku(board, r + 1, 0);
//         }
//         // If the cell is empty, try to fill it
//         if (board[r][c] == '.') {
//             for (int i = 1; i <= 9; i++) {
//                 if (isSafe(board, r, c, i)) {
//                     board[r][c] = (char) (i + '0'); // Try placing number
//                     if (solveSudoku(board, r, c + 1)) { // Recur
//                         return true; // If solved, return true
//                     }
//                     board[r][c] = '.'; // Backtrack if not solved
//                 }
//             }
//             return false; // If no number can be placed, return false
//         } else {
//             return solveSudoku(board, r, c + 1); // Move to next cell
//         }
//     }

//     public static void main(String[] args) {
//         char board[][] = {
//             {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
//             {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
//             {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
//             {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
//             {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
//             {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
//             {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
//             {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
//             {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
//         };

//         if (solveSudoku(board, 0, 0)) {
//             // Print the solved Sudoku board
//             for (int r = 0; r < 9; r++) {
//                 for (int c = 0; c < 9; c++) {
//                     System.out.print(board[r][c] + " "); // Print each element in a row
//                 }
//                 System.out.println(); // New line after each row
//             }
//         } else {
//             System.out.println("No solution exists.");
//         }
//     }
// }



//ITERATING THROUGH FOR LOOP
public class SUDOKU_SOLVER {
    public static boolean isSafe(char[][] board, int R, int C, int i) {
        // Check current row
        for (int c = 0; c < 9; c++) {
            if (board[R][c] == (char) (i + '0')) {
                return false;
            }
        }
        // Check current column
        for (int r = 0; r < 9; r++) {
            if (board[r][C] == (char) (i + '0')) {
                return false;
            }
        }
        // Check 3x3 subgrid
        int sr = (R / 3) * 3;
        int sc = (C / 3) * 3;
        for (int r = sr; r < sr + 3; r++) {
            for (int c = sc; c < sc + 3; c++) {
                if (board[r][c] == (char) (i + '0')) {
                    return false;
                }
            }
        }
        return true;
    }


    public static boolean solveSudoku(char[][] board) {
        for(int r=0;r<9;r++){
            for(int c=0;c<9;c++){
                if (board[r][c] == '.') {
                    for (int i = 1; i <= 9; i++) {
                        if (isSafe(board, r, c, i)) {
                            board[r][c] = (char) (i + '0'); // Try placing number
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



