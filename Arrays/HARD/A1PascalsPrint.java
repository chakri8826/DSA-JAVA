import java.util.ArrayList;
import java.util.List;

public class A1PascalsPrint {
    public List<Integer> generateRow(int r){
        List<Integer> li = new ArrayList<>();
        li.add(1);
        int val = 1;
        for(int c=1;c<r;c++){
            val = val * (r-c);
            val = val/c;
            li.add(val);
        }
        return li;
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for(int r=1;r<=numRows;r++){
            res.add(generateRow(r));
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }
}
