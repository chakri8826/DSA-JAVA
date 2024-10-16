public class WORDSEARCH {
    public boolean DFS(char[][] board,int r,int c,String word,int si){
        if(si==word.length()) return true;
        int rows=board.length;
        int cols=board[0].length;
        if(r<0 || r>=rows || c<0 ||c>=cols){
            return false;
        }
        if(board[r][c]==' ' || board[r][c]!=word.charAt(si)) return false;
        char t = board[r][c];
        board[r][c]=' ';
        //DFS CALLS
        if( DFS(board,r-1,c,word,si+1)|| DFS(board,r,c+1,word,si+1) || DFS(board,r+1,c,word,si+1) || DFS(board,r,c-1,word,si+1)){
            return true;
        }
        board[r][c]=t;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        for(int r=0;r<board.length;r++){
            for(int c=0;c<board[0].length;c++){
                if(word.charAt(0)==board[r][c]){
                    boolean found = DFS(board,r,c,word,0);
                    if(found) return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        WORDSEARCH w = new WORDSEARCH();
        System.out.println(w.exist(board, word));
    }
}

