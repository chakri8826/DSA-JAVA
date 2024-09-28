import java.util.*;
public class Subsets_Printing {
    List<List<Integer>> ans = new ArrayList<>();
    //USING A FOR--LOOP
    public void subs(List<Integer> tempList,int []nums,int start){
        ans.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            subs(tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }        
    }
    // public void subs(List<Integer> tempList,int []nums,int start){
    //     if(start==nums.length){
    //         ans.add(new ArrayList<>(tempList));
    //         return;
    //     }
    //     tempList.add(nums[start]);
    //     subs(tempList,nums,start+1);
    //     tempList.remove(tempList.size()-1);
    //     subs(tempList,nums,start+1);
    // }

    public List<List<Integer>> subsets(int[] nums) {
        subs(new ArrayList<>(),nums,0);
        return ans;
    }
    public static void main(String[] args) {
        int nums[]={1,2,3};
        Subsets_Printing s = new Subsets_Printing();
        System.out.println(s.subsets(nums));
    }
}

















