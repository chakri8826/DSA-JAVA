import java.util.*;
public class SUBSETS_2 {
    List<List<Integer>> ans = new ArrayList<>();
    public void subs(int i,List<Integer> li, int[] nums){
        ans.add(new ArrayList<>(li));
        for(int j=i;j<nums.length;j++){
            if(j>i && nums[j]==nums[j-1]){
                continue;
            }
            li.add(nums[j]);
            subs(j+1,li,nums);
            li.remove(li.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans = new ArrayList<>();
        Arrays.sort(nums);
        subs(0,new ArrayList<>(),nums);
        return ans;
    }
    public static void main(String[] args) {
        int nums[] = {1,2,2};
        SUBSETS_2 s = new SUBSETS_2();
        System.out.println(s.subsetsWithDup(nums));
    }
}