import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A3ThreeSum {
    // public List<List<Integer>> threeSum(int[] nums) {
    //     Set<List<Integer>> st = new HashSet<>();
    //     int n = nums.length;
    //     // check all possible triplets:
    //     for (int i = 0; i < n; i++) {
    //         for (int j = i+1; j < n; j++) {
    //             for (int k = j+1; k < n; k++) {
    //                 if (nums[i] + nums[j] + nums[k] == 0) {
    //                     List<Integer> temp = new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k]));
    //                     Collections.sort(temp);
    //                     st.add(temp);
    //                 }
    //             }
    //         }
    //     }
    //     List<List<Integer>> ans = new ArrayList<>(st);
    //     return ans;
    // }


    
    // public List<List<Integer>> threeSum(int[] nums){
    //     Set<List<Integer>> st = new HashSet<>();
    //     int n = nums.length;
    //     // check all possible triplets:
    //     for (int i = 0; i < n; i++) {
    //         Set<Integer> set = new HashSet<>();
    //         for (int j = i+1; j < n; j++) {
    //             int k = -(nums[i]+nums[j]); 
    //             if (set.contains(k)) {
    //                 List<Integer> temp = new ArrayList<>(Arrays.asList(nums[i],nums[j],k));
    //                 Collections.sort(temp);
    //                 st.add(temp);
    //             }
    //             set.add(nums[j]);
    //         }
    //     }
    //     List<List<Integer>> ans = new ArrayList<>(st);
    //     return ans;
    // }



    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0;i<n;i++){
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            int j=i+1;
            int k=n-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(sum==0){
                    List<Integer> li = new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k]));
                    ans.add(li);
                    while(j<k && nums[j]==nums[j+1]){
                        j++;
                    }
                    while(j<k && nums[k]==nums[k-1]){
                        k--;
                    }
                    j++;
                    k--;
                }
                else if(sum<0){
                    while(j<k && nums[j]==nums[j+1]){
                        j++;
                    }
                    j++;
                }
                else{
                    while(j<k && nums[k]==nums[k-1]){
                        k--;
                    }
                    k--;
                }
            }
        }
        return ans;
    }
}
