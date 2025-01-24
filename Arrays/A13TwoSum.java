import java.util.Arrays;

public class A13TwoSum {
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




    public int[] twoSum(int[] nums, int target){
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
}
