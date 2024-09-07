import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void combs(List<Integer> nums,List<Integer> curr ,int l,int start, List<List<Integer>> ans){
        if(curr.size()==l){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(start>=nums.size()){
            return;
        }
        curr.add(nums.get(start));
        combs(nums, curr,l,start+1,ans);

        curr.remove(curr.size()-1);
        combs(nums,curr,l,start+1,ans);

    
    }
    public static List<List<Integer>> combine(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        for(int i=1;i<=n;i++){
            nums.add(i);
        }
        List<List<Integer>> ans = new ArrayList<>();
        combs(nums,new ArrayList<>(),k,0,ans);
        return ans;
    }
    public static void main(String[] args){
        System.out.println(combine(4,2));
    
        
    }
}





