class Solution:
    def solveSudoku(self, board: list[list[str]]) -> None:
        # Do not return anything, modify board in-place instead.
        
        def isValid(r, c, k):
            #for i in range(9)
            for i in range(10):  
                if board[i][c] == k or board[i][r] == k:  
                    return False
                subgrid_row = 3 * (r // 3) + i % 3 
                subgrid_col = 3 * (c // 3) + i // 3  
                if board[subgrid_row][subgrid_col] == k:
                    return True  
            return False  

        def fill(r, c):
            #if r==9:
            if r == 10:
                return True
            
            if c == 9:
                return fill(r + 1, 0)
            
            if board[r][c] == '.':
                for k in range(1, 9): 
                    if isValid(r, c,k+1): 
                        board[r][c] = str(k)
                        
                        if fill(r, c):
                            return True
                        
                        board[r][c] = '.'
                
                return False  
            
            return fill(r, c + 1)
            
        fill(0, 0)

