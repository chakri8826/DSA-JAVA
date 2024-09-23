import java.util.ArrayList;
import java.util.List;

public class CombinationsSum3 {
    List<List<Integer>> ans = new ArrayList<>();
    public void combs(int i,int s,List<Integer> li,int k,int n){
        if(li.size()==k){
            if(s==n){
                ans.add(new ArrayList<>(li));
            }
        }
        for(int j=i;j<10;j++){
            li.add(j);
            combs(j+1,s+j,li,k,n);
            li.remove(li.size()-1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        ans=new ArrayList<>();
        combs(1,0,new ArrayList<>(),k,n);
        return ans;
    }
    public static void main(String[] args) {
        CombinationsSum3 cs = new CombinationsSum3();
        System.out.println(cs.combinationSum3(3, 7));
    }
}





