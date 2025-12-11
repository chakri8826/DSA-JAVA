class D1 {
    // public int specialTriplets(int[] nums) {
    //     int n = nums.length,cnt=0;
    //     for(int i=0;i<n;i++){
    //         for(int j=i+1;j<n;j++){
    //             if(nums[i]==nums[j]*2){
    //                 for(int k=j+1;k<n;k++){
    //                     if(nums[k]==nums[i]){
    //                         cnt++;
    //                     }
    //                 }
    //             }
    //         }
    //     }
    //     return cnt;
    // }

    public int specialTriplets(int[] nums) {
        final int MOD = 1000000007;
        Map<Integer,Integer> pmap = new HashMap<>();
        Map<Integer,Integer> nmap = new HashMap<>();

        for(int n:nums){
            nmap.put(n,nmap.getOrDefault(n,0)+1);
        }

        long ans = 0;
        for(int i=0;i<nums.length;i++){
            int tar = nums[i]*2;
            int f1 = pmap.getOrDefault(tar,0);

            // we need to add this before calculating f2 Bcoz in (0,0,0) if i is at
            // 2nd 0 then f1=1 and f2 will be 3-1=2 which is wrong, So we add it to 
            // the pmap, as next in calculating f2 we remove the updated pmap count
            //  then 3-2=1 ==> 1*1=1 which is correct.
            pmap.put(nums[i],pmap.getOrDefault(nums[i],0)+1);

            int f2 = nmap.getOrDefault(tar,0) - pmap.getOrDefault(tar,0);
            ans = (ans+(long) f1*f2) % MOD;
        }
        return (int) ans;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(specialTriplets(nums));
    }
}
