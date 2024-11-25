import java.util.*;
public class S2MaxRectangle {
        public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int ls[] = new int[n];
        Stack<Integer> s = new Stack<>();
        ls[0]=0;
        s.push(0);
        for(int i=1;i<n;i++){
            while(!s.isEmpty() && heights[s.peek()]>=heights[i]){
                s.pop();
            }
            if(s.isEmpty()) ls[i]=0;
            else  ls[i]=s.peek()+1;   
            s.push(i);
        }

        while(!s.isEmpty()) s.pop();  

        int maxi=0;
        int rs[] = new int[n];
        rs[n-1]=n-1;
        s.push(n-1);
        for(int i=n-1;i>=0;i--){
            while(!s.isEmpty() && heights[s.peek()]>=heights[i]){
                s.pop();
            }
            if(s.isEmpty()) rs[i]=n-1;
            else  rs[i]=s.peek()-1;
            maxi = Math.max(maxi,(rs[i]-ls[i]+1) * heights[i]);
            s.push(i);
        }
        return maxi;
    }

    public static int maximalRectangle(char[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int ht[] = new int[c];
        int maxi=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                // int val = (int) matrix[i][j] - '0';
                // if(i>0){
                //     if(val!=0){
                //         ht[j] = ht[j] + val;
                //     }
                //     else{
                //         ht[j] = 0;
                //     }
                // }
                // else{
                //     ht[j] = val;
                // }

                //these two lines are enough
                if(matrix[i][j]=='1') ht[j]++;
                else ht[j]=0;
            }
            maxi = Math.max(maxi,largestRectangleArea(ht));
        }
        return maxi;
    }
    public static void main(String[] args) {
        char[][]  matrix = {{'1', '0', '1', '0', '0'},
                            {'1', '0', '1', '1', '1'},
                            {'1', '1', '1', '1', '1'},
                            {'1', '0', '0', '1', '0'}};
        System.out.println(maximalRectangle(matrix));
                        
    }
}
