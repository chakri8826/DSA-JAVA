class Contest498 {
    public int[] suffMin(int[] nums){
        int n = nums.length;
        int suff[] = new int[n];
        suff[n-1] = nums[n-1];
        for(int i=n-2;i>=0;i--){
            suff[i] = Math.min(nums[i],suff[i+1]);
        }
        return suff;
    }

    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length,maxi = Integer.MIN_VALUE;
        int suff[] = suffMin(nums);
        for(int i=0;i<n;i++){
            maxi = Math.max(maxi,nums[i]);
            System.out.println("MAXI: "+maxi);
            System.out.println("SUFF: "+suff[i]);
            int sc = maxi-suff[i];
            System.out.println("SC: "+sc);
            if(sc<=k)return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        int nums[] = {5,5};
        int k = 2;
        Contest498 c = new Contest498();
        System.out.println(c.firstStableIndex(nums, k));
    }
}