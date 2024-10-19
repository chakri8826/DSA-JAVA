public class HOUSE_ROBBER2_05 {
    public static int r(int[] nums){
        int prev=nums[0],prev2=0;
        for(int i=1;i<nums.length;i++){
            int le = nums[i];
            if(i>1)
                le+=prev2;
            int ri = prev;
            int curr = Math.max(le,ri);
            prev2=prev;
            prev=curr;
        }
        return prev;
    }
    public static int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int n = nums.length;
        int le[] = new int[n];
        int ri[] = new int[n];
        for(int i=0;i<n;i++){
            if(i!=0) le[i] = nums[i];
            if(i!=n-1) ri[i] = nums[i];
        }
        return Math.max(r(le),r(ri));
    }
    public static void main(String[] args) {
        int nums[] = {2,3,2};
        System.out.println(rob(nums));
    }
}

