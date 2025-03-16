import java.util.*;
class G6MinPlatforms{
    static int findPlatform(int arr[], int dep[]) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int aind=0,dind=0,count=0,maxPlat=0,n=arr.length;
        while(aind<n){
             if(arr[aind]<=dep[dind]){
                 count++;
                 aind++;
                 maxPlat = Math.max(maxPlat,count);
             }
             else{
                 count--;
                 dind++;
             }
        }
        return maxPlat;
    }
    public static void main(String[] args) {
        int arr[] = {900, 940, 950, 1100, 1500, 1800};
        int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
        System.out.println(findPlatform(arr,dep));
    }
}