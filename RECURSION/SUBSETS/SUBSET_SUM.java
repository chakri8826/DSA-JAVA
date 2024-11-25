// import java.util.*;
// public class SUBSET_SUM {
//     public void subs(List<Integer> tempList,ArrayList<Integer> nums,int start,List<Integer> ans){
//         int sum=0;
//         for(int v:tempList){
//             sum+=v;
//         }
//         ans.add(sum);
//         for(int i = start; i < nums.size(); i++){
//             tempList.add(nums.get(i));
//             subs(tempList, nums, i + 1,ans);
//             tempList.remove(tempList.size() - 1);
//         }        
//     }
//     ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
//         ArrayList<Integer> ans = new ArrayList<>();
//         subs(new ArrayList<>(),arr,0,ans);
//         return ans;
//     }
//     public static void main(String[] args) {
//         ArrayList<Integer> nums = new ArrayList<>();
//         nums.add(1);
//         nums.add(2);
//         nums.add(3);
//         int n = nums.size();
//         SUBSET_SUM s = new SUBSET_SUM();
//         System.out.println(s.subsetSums(nums,n));
//     }
// }



//SUBSET SUM EQUAL TO A TARGET
import java.util.*;

public class SUBSET_SUM {
    
    public void subs(List<Integer> tempList, ArrayList<Integer> nums, int start, int target, List<List<Integer>> ans) {
        int sum = 0;
        for (int v : tempList) {
            sum += v;
        }
        
        // If the subset sum matches the target, add a copy of tempList to ans
        if (sum == target) {
            ans.add(new ArrayList<>(tempList));
        }

        for (int i = start; i < nums.size(); i++) {
            tempList.add(nums.get(i));
            subs(tempList, nums, i + 1, target, ans);
            tempList.remove(tempList.size() - 1); // backtrack
        }
    }
    
    List<List<Integer>> subsetSums(ArrayList<Integer> arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        subs(new ArrayList<>(), arr, 0, target, ans);
        return ans;
    }
    

    
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3));
        int target = 3; // Example target sum
        
        SUBSET_SUM s = new SUBSET_SUM();
        System.out.println("Subsets with sum equal to target: " + s.subsetSums(nums, target));
    }
}
