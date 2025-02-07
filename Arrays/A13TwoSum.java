import java.util.Arrays;

public class A13TwoSum {
    // BRUTE
    // public int[] twoSum(int[] nums, int target) {
    //     int n = nums.length;
    //     for(int i=0;i<n;i++){
    //         for(int j=i+1;j<n;j++){
    //             if(i!=j && nums[i]+nums[j]==target){
    //                 return new int[] {i,j};
    //             }
    //         }
    //     }       
    //     return new int[]{};
    // }


    // BETTER
    // public int[] twoSum(int[] nums, int target){
    //     int n=nums.length;
    //     HashMap<Integer,Integer> map = new HashMap<>();
    //     for(int i=0;i<n;i++){
    //         int y = target - nums[i];
    //         if(map.containsKey(y)){
    //             return new int[] {map.get(y),i};
    //         }
    //         map.put(nums[i],i);
    //     }
    //     return new int[]{};
    // }



    // OPTIMAL FOR RETURNING NUMS BUT NOT INDICES
    // public int[] twoSum(int[] nums, int target) {
    //     Arrays.sort(nums);
    //     int n = nums.length;
    //     int l=0,r=n-1,sum=0;
    //     while(l<r){
    //         sum=nums[l]+nums[r];
    //         if(sum==target){
    //             return new int[] {l,r};
    //         }
    //         else if(sum<target) l++;
    //         else r--;
    //     }
    //     return new int[] {};
    // }


    public static int[] twoSum(int[] nums, int target){
        Arrays.sort(nums);
        int n=nums.length;
        int l=0,r=0,sum=0;
        while(r<n){
            sum+=nums[r];
            while(sum>target){
                sum-=nums[l];
                l++;
            }
            if(sum==target){
                return new int[] {l,r};
            }
            r++;
        }
        return new int[]{};
    }
    public static void main(String[] args) {
        int arr[] = {1,2,4,5,6,8,9};
        int tar = 7;
        System.out.println(Arrays.toString(twoSum(arr,tar)));
    }
}
