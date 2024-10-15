import java.util.*;
public class SUBSETS_1 {
    // public void subs(List<Integer> tempList,int []nums,int start,List<List<Integer>> ans){
    //     if(start==nums.length){
    //         ans.add(new ArrayList<>(tempList));
    //         return;
    //     }
    //     if(start>=nums.length) return;
    //     tempList.add(nums[start]);
    //     subs(tempList, nums, start+1, ans);

    //     tempList.remove(tempList.size()-1);
    //     subs(tempList, nums, start+1, ans);
    // }

    public void subs(List<Integer> tempList,int []nums,int start,List<List<Integer>> ans){
        ans.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            subs(tempList, nums, i + 1,ans);
            tempList.remove(tempList.size() - 1);
        }        
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        subs(new ArrayList<>(),nums,0,ans);
        return ans;
    }
    public static void main(String[] args) {
        int nums[] = {1,2,3};
        SUBSETS_1 s = new SUBSETS_1();
        System.out.println(s.subsets(nums));
    }
}





