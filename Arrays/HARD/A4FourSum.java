import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class A4FourSum {
    //BRUTE
    // public static List<List<Integer>> fourSum(int []nums, int target) {
    //     HashSet<List<Integer>> set = new HashSet<>();
    //     int n = nums.length;
    //     for(int i=0;i<n;i++){
    //         for(int j=i+1;j<n;j++){
    //             for(int k=j+1;k<n;k++){
    //                 for(int l=k+1;l<n;l++){
    //                     if(nums[i]+nums[j]+nums[k]+nums[l] == target){
    //                         List<Integer> li = new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
    //                         Collections.sort(li);
    //                         set.add(li);
    //                     }
    //                 }
    //             }       
    //         }   
    //     }
    //     List<List<Integer>> ans = new ArrayList<>(set);
    //     return ans;
    // }


    //BETTER APPROACH
    // public static List<List<Integer>> fourSum(int []nums, int target) {
    //     int n = nums.length;
    //     HashSet<List<Integer>> st = new HashSet<>();
    //     for(int i=0;i<n;i++){
    //         for(int j=i+1;j<n;j++){
    //             HashSet<Long> set = new HashSet<>();
    //             for(int k=j+1;k<n;k++){
    //                 long tar = target - (nums[i]+nums[j]+nums[k]);
    //                 if(set.contains(tar)){
    //                     List<Integer> li = new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k],(int)tar));
    //                     Collections.sort(li);
    //                     st.add(li);
    //                 }
    //                 set.add((long)nums[k]);
    //             }
    //         }
    //     }
    //     List<List<Integer>> ans = new ArrayList<>(st);
    //     return ans;
    // }

    // OPTIMAL
     public static List<List<Integer>> fourSum(int []nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0;i<n-3;i++){
            if(i!=0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<n-2;j++){
                if(j!=i+1 && nums[j]==nums[j-1]) continue;
                int k=j+1;
                int l=n-1;
                while(k<l){
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
                    if(sum==target){
                        List<Integer> li = new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                        ans.add(li);
                        while(k<l && nums[k]==nums[k+1]){
                            k++;
                        }
                        k++;
                        while(k<l && nums[l]==nums[l-1]){
                            l--;
                        }
                        l--;
                    }
                    else if(sum<target){
                        k++;
                    }
                    else{
                        l--;
                    }
                }
            }            
        }
        return ans;
    }
    
    public static void main(String[] args) {
        
    }
}
