import java.util.Stack;

public class M10MaxRectArea {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        for(int i=0;i<heights.length;i++){
            while(!st.isEmpty() && heights[i]<heights[st.peek()]){
                int ele = heights[st.pop()],nse=i;
                int pse = st.isEmpty()?-1:st.peek();
                maxArea = Math.max(ele*(nse-pse-1),maxArea);
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int ele = heights[st.pop()],nse=heights.length;
            int pse = st.isEmpty()?-1:st.peek();
            maxArea = Math.max(ele*(nse-pse-1),maxArea);
        }
        return maxArea;
    } 
    public int maximalRectangle(char[][] matrix) {
        int r=matrix.length,c=matrix[0].length,maxArea=0;
        int hts[] = new int[c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                hts[j]=matrix[i][j]=='1'?hts[j]+1:0;
            } 
            maxArea=Math.max(largestRectangleArea(hts),maxArea);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        M10MaxRectArea sol = new M10MaxRectArea();
        char[][] matrix = {
            {'1','0','1','0','0'},
            {'1','0','1','1','1'},
            {'1','1','1','1','1'},
            {'1','0','0','1','0'}
        };
        System.out.println(sol.maximalRectangle(matrix));
    }
}
