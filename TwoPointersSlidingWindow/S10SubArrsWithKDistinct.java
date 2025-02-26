import java.util.HashMap;

public class S10SubArrsWithKDistinct {
      // public int subarraysWithKDistinct(int[] nums, int k) {
    //     int res=0,n=nums.length; 
    //     for(int i=0;i<n;i++){
    //         HashSet<Integer> set = new HashSet<>();
    //         for(int j=i;j<n;j++){
    //             set.add(nums[j]);
    //             if(set.size()==k){
    //                 res++;
    //             }
    //             else if(set.size()>k) break;
    //         }
    //     }
    //     return res;
    // }


    public int calc(int[] nums, int k){
        int l=0,r=0,n=nums.length,res=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        while(r<n){
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);
            while(map.size()>k){
                map.put(nums[l],map.get(nums[l])-1);
                if(map.get(nums[l])==0){
                    map.remove(nums[l]);
                }
                l++;
            }
            res+=(r-l+1);
            r++;
        }
        return res;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return calc(nums,k)-calc(nums,k-1);
    }
}
