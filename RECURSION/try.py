class Solution:
    def solveSudoku(self, board: List[List[str]]) -> None:
        def isValid(r, c, k):
            for i in range(9):  
                if board[r][i] == k or board[i][c] == k:  
                    return False
                subgrid_row = 3 * (r // 3) + i // 3 
                subgrid_col = 3 * (c // 3) + i % 3  
                if board[subgrid_row][subgrid_col] == k:
                    return False  
            return True  

        def fill(r, c):
            if r == 9:  # Base case: all rows filled
                return True

            if c == 9:  # Move to the next row
                return fill(r + 1, 0)
            
            if board[r][c] == '.':
                for k in range(1, 10): 
                    if isValid(r, c, str(k)): 
                        board[r][c] = str(k)
                        
                        if fill(r, c + 1):  # Move to the next column
                            return True
                        
                        board[r][c] = '.'  # Backtrack
                
                return False  
            
            return fill(r, c + 1)  # Continue to the next column
            
        fill(0, 0)
