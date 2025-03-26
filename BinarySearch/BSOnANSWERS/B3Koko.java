class B3Koko{
    public int f(int[] piles, int h){
        int hrs = 0;
        for(int i=0;i<piles.length;i++){
            hrs+=Math.ceil((double)piles[i]/h);
        }
        return hrs;
    }

    public int minEatingSpeed(int[] piles, int h) {
        // int n = piles.length,k=1;
        // while(true){
        //     int sum = 0;
        //     for(int i=0;i<n;i++){
        //         float t = (float) piles[i]/k;
        //         sum+=Math.ceil(t);
        //     }
        //     if(sum<=h)return k;
        //     k++;
        // }      

        // int n = piles.length,maxi=0;
        // for(int i=0;i<n;i++){
        //     maxi=Math.max(maxi,piles[i]);
        // }   
        // for(int i=1;i<=maxi;i++){
        //     int reqTime = f(piles,i);
        //     if(reqTime<=h)return i;
        // }
        // return -1;


        int low=1,n = piles.length,maxi=0;
        for(int i=0;i<n;i++){
            maxi=Math.max(maxi,piles[i]);
        }   
        int high=maxi,mini=Integer.MAX_VALUE;
        while(low<=high){
            int mid=low+(high-low)/2;
            int poss = f(piles,mid);
            if(poss<=h){
                // mini = Math.min(mini,mid);
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
}