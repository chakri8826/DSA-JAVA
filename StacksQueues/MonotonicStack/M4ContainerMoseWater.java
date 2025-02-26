class M4ContainerMoseWater{
// public int maxArea(int[] height) {
    //     int n=height.length, maxA = Integer.MIN_VALUE;
    //     for(int i=0;i<n;i++){
    //         for(int j=i+1;j<n;j++){
    //             maxA = Math.max(maxA,(j-i)*Math.min(height[i],height[j]));
    //         }
    //     }
    //     return maxA;
    // }


    public int maxArea(int[] height) {
        int n=height.length,l=0,r=n-1,maxA = Integer.MIN_VALUE;
        while(l<r){
            if(height[l]<height[r]){
                maxA = Math.max(maxA,(r-l)* height[l]);
                l++;
            }
            else{
                maxA = Math.max(maxA,(r-l)* height[r]);
                r--;
            }
        }
        return maxA;
    }
}

