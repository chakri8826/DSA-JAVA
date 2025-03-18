import java.util.Arrays;

public class B2FloorCeil {
    static int findFloor(int[] arr, int x) {
        int n=arr.length;
        int low=0,high=n-1,ans=-1;
        while(low<=high){
            int mid = low+(high-low)/2; 
            if(arr[mid]<=x){
                ans=arr[mid];
                low=mid+1;
            }
            else high=mid-1;
        }
        return ans;
    }
    
    static int findCeil(int[] arr, int x) {
        int n=arr.length;
        int low=0,high=n-1,ans=-1;
        while(low<=high){
            int mid = low+(high-low)/2; 
            if(arr[mid]>=x){
                ans=arr[mid];
                high=mid-1;
            }
            else low=mid+1;
        }
        return ans;
    }
    
    public int[] getFloorAndCeil(int x, int[] arr) {
        Arrays.sort(arr);
        int flor = findFloor(arr,x);
        int ceil = findCeil(arr,x);
        return new int[]{flor,ceil};
    }
}
