class A10MissingNumbers{
    // public int missingNumber(int[] nums) {
        //int n=nums.length;
        // int vis[] = new int[n+1];
        // for(int i=0;i<n;i++){
        //     vis[nums[i]]=1;
        // }
        // int j=-1;
        // for(int i=0;i<=n;i++){
        //     if(vis[i]==0){
        //         j=i;
        //         break;
        //     }
        // }
        //     return j;
    // }

    
    // public int missingNumber(int[] nums) {
    //     int n=nums.length,sum=0;
    //     for(int i=0;i<=n;i++){
    //         sum+=i;
    //     }
    //     for(int i=0;i<n;i++){
    //         sum-=nums[i];
    //     }
    //     return sum;
    // }

    //USING XOR
    // public int missingNumber(int[] nums) {
    //     int n=nums.length,xor1=0,xor2=0;
    //     for(int i=0;i<=n;i++){
    //         xor1^=i;
    //     }
    //     for(int i=0;i<n;i++){
    //         xor2^=nums[i];
    //     }
    //     return xor1^xor2;
    // }    


    //USING XOR  still optimizing
    // public static int missingNumber(int[] nums) {
    //     int n=nums.length,xor1=0,xor2=0;
    //     for(int i=0;i<n;i++){
    //         xor1^=i;
    //         xor2^=nums[i];
    //     }
    //     xor1^=n;
    //     return xor1^xor2;
    // } 


     public static int missingNumber(int[] nums){
        int n=nums.length,ans=0;
        for(int i=0;i<32;i++){
            int cnt=0;
            for(int j=0;j<n;j++){
                if((nums[j]&(1<<i))!=0)cnt++;
            }
            if(cnt%2!=0){
                ans=ans|(1<<i);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int nums[] = {2,2,4};
        System.out.println(missingNumber(nums));
    }   
}