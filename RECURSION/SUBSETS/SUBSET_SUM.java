import java.util.*;
public class SUBSET_SUM {
    public void subs(List<Integer> tempList,ArrayList<Integer> nums,int start,List<Integer> ans){
        int sum=0;
        for(int v:tempList){
            sum+=v;
        }
        ans.add(sum);
        for(int i = start; i < nums.size(); i++){
            tempList.add(nums.get(i));
            subs(tempList, nums, i + 1,ans);
            tempList.remove(tempList.size() - 1);
        }        
    }
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        subs(new ArrayList<>(),arr,0,ans);
        return ans;
    }
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        int n = nums.size();
        SUBSET_SUM s = new SUBSET_SUM();
        System.out.println(s.subsetSums(nums,n));
    }
}
