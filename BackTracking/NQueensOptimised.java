import java.util.*;
public class NQueensOptimised {
    public List<String> construct(char board[][],int n){
        List<String> res= new ArrayList<>();
        for(int i=0;i<n;i++){
            String row = new String(board[i]);
            res.add(row);
        }
        return res;
    }
    public void solve(int col,char board[][],List<List<String>> ans,int n,int lr[],int ud[],int ld[]){
        if(col==n){
            ans.add(construct(board,n));
            return;
        }
        for(int row=0;row<n;row++){
            if(lr[row]==0 && ud[(n-1)+(col-row)]==0 && ld[row+col]==0){
                board[row][col]='Q';
                lr[row]=1;
                ud[(n-1)+(col-row)]=1;
                ld[row+col]=1;
                solve(col+1,board,ans,n,lr,ud,ld);
                board[row][col]='.';
                lr[row]=0;
                ud[(n-1)+(col-row)]=0;
                ld[row+col]=0;
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
        int leftRow[] = new int[n];
        int upperDiagonal[] = new int[2*n-1];
        int lowerDiagonal[] = new int[2*n-1];

        solve(0,board,ans,n,leftRow,upperDiagonal,lowerDiagonal);
        return ans;
    }
    public static void main(String[] args) {
        int n=4;
        NQueensOptimised q = new NQueensOptimised();
        System.out.println(q.solveNQueens(n));
    }
}
