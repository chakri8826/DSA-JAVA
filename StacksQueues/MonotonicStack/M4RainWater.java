public class M4RainWater {
    // BRUTE-FORCE
    // public int fml(int ind,int[] height){
    //     int maxi = height[ind];
    //     for(int i=ind-1;i>=0;i--){
    //         maxi=Math.max(maxi,height[i]);
    //     }
    //     return maxi;
    // }
    // public int fmr(int ind,int[] height){
    //     int maxi = height[ind];
    //     for(int i=ind+1;i<height.length;i++){
    //         maxi=Math.max(maxi,height[i]);
    //     }
    //     return maxi;
    // }

    // public int trap(int[] height) {
        // int total=0;
        // for(int i=0;i<height.length;i++){
        //     int ml = fml(i,height);
        //     int mr = fmr(i,height);
        //     if(ml>height[i] && mr>height[i]){
        //         total+=Math.min(ml,mr)-height[i];
        //     }
        // }
        // return total;
    // }




    // public int trap(int[] height) {
    //     int n=height.length;
    //     // int pre[] = new int[n];
    //     int suff[] = new int[n];

    //     // THIS CAN BE OPTIMIZED BY TRAVERSING IN LAST STEP ITSELF
    //     // pre[0]=height[0];
    //     // for(int i=1;i<n;i++){
    //     //     pre[i]=Math.max(pre[i-1],height[i]);
    //     // }

    //     suff[n-1]=height[n-1];
    //     for(int i=n-2;i>=0;i--){
    //         suff[i]=Math.max(suff[i+1],height[i]);
    //     }

    //     int total=0;
    //     int ml=Integer.MIN_VALUE;
    //     for(int i=0;i<height.length;i++){
    //         ml = Math.max(height[i],ml);
    //         int mr = suff[i];
    //         if(ml>height[i] && mr>height[i]){
    //             total+=Math.min(ml,mr)-height[i];
    //         }
    //     }
    //     return total;
    // }




    public int trap(int[] height) {
        int n=height.length,l=0,r=n-1,lmax=0,rmax=0,total=0;
        while(l<r){
            if(height[l]<height[r]){
                if(lmax>height[l]){
                    total+=lmax-height[l];
                }
                else{
                    lmax=height[l];
                }
                l++;
            }
            else{
                if(rmax>height[r]){
                    total+=rmax-height[r];
                }
                else{
                    rmax=height[r];
                }
                r--;
            }
        }
        return total;
    }





    


}
