public class A12AppearsOnce {
     // public int singleNumber(int[] nums) {
    //     int n = nums.length,maxi=0;
    //     for(int i=0;i<n;i++){
    //         maxi = Math.max(maxi,nums[i]);
    //     }
    //     int vis[] = new int[maxi+1];
    //     for(int i=0;i<n;i++){
    //         vis[nums[i]]++;
    //     }   
    //     int j=1;
    //     for(int i=0;i<n;i++){
    //         if(vis[i]==1){
    //             j=i;
    //         }
    //     }
    //     return j;
    // }

    // public int singleNumber(int[] nums){
    //     int n = nums.length;
    //     HashMap<Integer,Integer> m = new HashMap<>();
    //     for(int i=0;i<n;i++){
    //         m.put(nums[i],m.getOrDefault(nums[i],0)+1);
    //     }
    //     for(Map.Entry<Integer,Integer> e :m.entrySet()){
    //         if(e.getValue()==1){
    //             return e.getKey();
    //         }
    //     }
    //     return -1;
    // }

    //OPTI
    public int singleNumber(int[] nums){
        int res=0;
        for(int num:nums){
            res^=num;
        }
        return res;
    }
}
