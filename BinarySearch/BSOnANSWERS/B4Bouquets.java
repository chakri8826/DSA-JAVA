public class B4Bouquets {
    public int findBoq(int[] bloomDay,int day,int k){
        int boq=0,cnt=0;
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]<=day) cnt++;
            else cnt=0;
            if(cnt==k){
                boq++;
                cnt=0;
            }
        } 
        return boq;
    }
    // BRUTE
    // public int minDays(int[] bloomDay, int m, int k) {
    //     int maxi=0,n=bloomDay.length;
    //     for(int day:bloomDay){
    //         maxi=Math.max(maxi,day);
    //     } 
    //     for(int day=1;day<=maxi;day++){
    //         int boq = findBoq(bloomDay,day,k);
    //         if(boq>=m)return day;
    //     }
    //     return -1;
    // }
 public int minDays(int[] bloomDay, int m, int k) {
        int maxi=0,n=bloomDay.length;

        // IF NOT POSSIBLE TO MAKE M BOUQUETS
        long val = (long) m * k;
        if (val > n) return -1;
        for(int day:bloomDay){
            maxi=Math.max(maxi,day);
        } 
        int low=1,high=maxi;
        // int ans=-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            int boq = findBoq(bloomDay,mid,k);
            if(boq>=m){
                // ans=mid;
                high=mid-1;
            }
            else low=mid+1;
        }
        return low;
    }
}
