import java.util.*;
public class NQueens {
    public boolean isSafe(int row,int col,char board[][],int n){
        int duprow=row;
        int dupcol=col;
        while(duprow>=0 && dupcol>=0){
            if(board[duprow][dupcol]=='Q') return false;
            duprow--;
            dupcol--;
        }

        int dupcol1 = col;
        while(dupcol1>=0){
            if(board[row][dupcol1]=='Q') return false;
            dupcol1--;
        }

        int duprow2=row;
        int dupcol2=col;
        while(duprow2<n && dupcol2>=0){
            if(board[duprow2][dupcol2]=='Q') return false;
            duprow2++;
            dupcol2--;
        }
        return true;
    }
    public List<String> construct(char board[][],int n){
        List<String> res= new ArrayList<>();
        for(int i=0;i<n;i++){
            String row = new String(board[i]);
            res.add(row);
        }
        return res;
    }
    public void solve(int col,char board[][],List<List<String>> ans,int n){
        if(col==n){
            ans.add(construct(board,n));
            return;
        }
        for(int row=0;row<n;row++){
            if(isSafe(row,col,board,n)){
                board[row][col]='Q';
                solve(col+1,board,ans,n);
                board[row][col]='.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char board[][] = new char[n][n];
        for(int r=0;r<n;r++){
            for(int c=0;c<n;c++){
                board[r][c]='.';
            }
        }
        solve(0,board,ans,n);
        return ans;
    }
    public static void main(String[] args) {
        int n=4;
        NQueens q = new NQueens();
        System.out.println(q.solveNQueens(n));
    }
}
