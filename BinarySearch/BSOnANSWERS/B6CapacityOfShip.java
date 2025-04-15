import java.util.Arrays;
import java.util.Scanner;

public class B6CapacityOfShip {
    // GurhtuUndedi
   
    // public int findMaxDays(int[] weights, int d, int cap){
    //     int loadDay=0,totalLoad=0,days=1;
    //     for(int i=0;i<weights.length;i++){
    //         loadDay+=weights[i];
    //         if(loadDay>cap){
    //             days++;
    //             loadDay=weights[i];
    //         }
    //     }
    //     return days;
    // }

    // BRUTE
    // public int shipWithinDays(int[] weights, int days) {
    //     int total=0;
    //     for(int i=0;i<weights.length;i++){
    //         total+=weights[i];
    //     }
    //     for(int cap=1;cap<=total;cap++){
    //         int res = findMaxDays(weights,days,cap);
    //         if(res<=days)return cap;
    //     }
    //     return -1;
    // } 

    // public int shipWithinDays(int[] weights, int days) {
    //     int total=0,maxi=Integer.MIN_VALUE;
    //     for(int i=0;i<weights.length;i++){
    //         maxi=Math.max(maxi,weights[i]);
    //         total+=weights[i];
    //     }
    //     // Min capacity should be max of wts as it should be shipped.
    //     int low=maxi,high=total;
        
    //     while(low<=high){
    //         int mid = low+(high-low)/2;
    //         int maxDays = findMaxDays(weights,days,mid);
    //         if(maxDays<=days) high=mid-1;
    //         else low=mid+1;
    //     }
    //     return low;
    // } 





     public boolean poss(int[] weights, int d, int cap){
        int loadDay=0,totalLoad=0,days=1;
        for(int i=0;i<weights.length;i++){
            if(weights[i]+totalLoad<=cap)totalLoad+=weights[i];
            else{
                days++;
                totalLoad=weights[i];
            }
        }
        return days<=d;
    }
    public int shipWithinDays(int[] weights, int days) {
        int total=0,maxi=Integer.MIN_VALUE;
        for(int i=0;i<weights.length;i++){
            maxi=Math.max(maxi,weights[i]);
            total+=weights[i];
        }
        // Min capacity should be max of wts as it should be shipped.
        int low=maxi,high=total;
        
        while(low<=high){
            int mid = low+(high-low)/2;
            if(poss(weights,days,mid)) high=mid-1;
            else low=mid+1;
        }
        return low;
    } 

    public static void main(String[] args) {
        
        // Compute the total weight that can be shipped
        int weights[] = {1,2,3,4,5,6,7,8,9,10};
        int d = 5;
        B6CapacityOfShip obj = new B6CapacityOfShip();
        int result = obj.shipWithinDays(weights, d);
        System.out.println(result);
    }

}
