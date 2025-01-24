import java.util.ArrayList;
import java.util.List;
public class A24SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int top=0,left=0,right=n-1,btm=m-1;
        List<Integer> li = new ArrayList<>();
        while(top<=btm && left<=right){
            for(int i=left;i<=right;i++){
                li.add(matrix[top][i]);
            }
            top++;
            for(int i=top;i<=btm;i++){
                li.add(matrix[i][right]);
            }
            right--;
            if(top<=btm){
                for(int i=right;i>=left;i--){
                    li.add(matrix[btm][i]);
                }
                btm--;
            }
            if(left<=right){
                for(int i=btm;i>=top;i--){
                    li.add(matrix[i][left]);
                }
                left++;
            }
        }
        return li;
    }
}
