public class M3Jump2 {
    public int f(int[] nums,int ind,Integer dp[]){
        if(ind>=nums.length-1)return 0;
        if(nums[ind]==0) return Integer.MAX_VALUE;
        
        if(dp[ind]!=null) return dp[ind];
        
        int maxJump = nums[ind];
        int res = Integer.MAX_VALUE;
        for(int step=1;step<=maxJump;step++){
            int cnt = f(nums,ind+step,dp);
            if(cnt!=Integer.MAX_VALUE){
                res = Math.min(res,cnt+1);
            }
        }
        return dp[ind] = res;
    }

    public int jump(int[] nums) {
        Integer dp[] = new Integer[nums.length];
        return f(nums,0,dp);
    }
}
