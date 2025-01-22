public class A12MaxProdSubArr {
    //BRUTE
    // public int maxProduct(int[] nums) {
    //     int maxi=Integer.MIN_VALUE,n=nums.length;
    //     for(int i=0;i<n;i++){
    //         int prod=1;
    //         for(int j=i;j<n;j++){
    //             prod*=nums[j];
    //             maxi=Math.max(maxi,prod);
    //         }
    //     }
    //     return maxi;
    // }

    //OPTI-1
    public int maxProduct(int[] nums) {
        int n=nums.length,maxi=Integer.MIN_VALUE,pre=1,suff=1;
        for(int i=0;i<n;i++){
            if(pre==0) pre=1;
            if(suff==0) suff=1;
            pre*=nums[i];
            suff*=nums[n-i-1];
            maxi = Math.max(maxi,Math.max(pre,suff));
        }
        return maxi;
    }
}


