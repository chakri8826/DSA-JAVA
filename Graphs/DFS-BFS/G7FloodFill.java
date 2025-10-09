import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int first,second;
    public Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}

public class G7FloodFill {
    int dx[] = {-1,0,1,0};
    int dy[] = {0,1,0,-1};

    public void DFS(int[][] image, int sr, int sc,int start, int color,int[][] result){
        result[sr][sc]=color;
        int n = result.length;
        int m = result[0].length;
        for(int i=0;i<4;i++){
            int iind = sr + dx[i];
            int jind = sc + dy[i];
            if(iind>=0 && jind>=0 && iind<n && jind<m && image[iind][jind]==start && result[iind][jind]!=color){
                DFS(image,iind,jind,start,color,result);
            }
        }
    }

        public void BFS(int[][] image, int sr, int sc,int start, int color,int[][] result){
            int n = result.length;
            int m = result[0].length;
            Queue<Pair> q = new LinkedList<>();
            q.offer(new Pair(sr,sc));
            while(!q.isEmpty()){
                int f = q.peek().first;
                int s = q.peek().second;
                q.poll();
                result[f][s]=color;
                for(int i=0;i<4;i++){
                    int iind = f + dx[i];
                    int jind = s + dy[i];
                    if(iind>=0 && jind>=0 && iind<n && jind<m && image[iind][jind]==start && result[iind][jind]!=color){
                        q.offer(new Pair(iind,jind));
                    }
                }
            }
        } 

        public int[][] floodFill(int[][] image, int sr, int sc, int color) {
            int[][] result = image;
            int n = result.length;
            int m = result[0].length;
            int start = image[sr][sc];
            // DFS(image,sr,sc,start,color,result);
            BFS(image,sr,sc,start,color,result);
            return result;
        } 
}