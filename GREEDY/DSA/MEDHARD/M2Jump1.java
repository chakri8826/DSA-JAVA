public class M2Jump1 {
    // public boolean f(int[] nums,int ind){
    //     if(ind>=nums.length-1)return true;
    //     int maxJump = nums[ind];
    //     for(int step=1;step<=maxJump;step++){
    //         if(f(nums,ind+step)) return true; 
    //     }
    //     return false;
    // }

    public boolean f(int[] nums,int ind,Boolean dp[]){
        if(ind>=nums.length-1)return true;
        if(dp[ind]!=null) return dp[ind];
        int maxJump = nums[ind];
        for(int step=1;step<=maxJump;step++){
            // CHAKRI THINKS
            // dp[ind] = f(nums,ind+step,dp);
            // if(dp[ind]) return true;
            if(f(nums,ind+step,dp)) return dp[ind]=true;
        }
        dp[ind]=false;
        return dp[ind];
    }

    public boolean canJump(int[] nums) {
        if(nums.length==1)return true;
        Boolean dp[] = new Boolean[nums.length];
        return f(nums,0,dp);
    }    
}
