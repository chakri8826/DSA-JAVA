import java.util.Arrays;

public class MinPlatforms {
        static int findPlatform(int arr[], int dep[]) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int aind=0,dind=0,count=0,maxPlat=0,n=arr.length;
        while(aind<n ){
            if(arr[aind]<=dep[dind]){
                count++;
                aind++;
            }
            else if(arr[aind]>=dep[dind]){
                count--;
                dind++;
            }
            maxPlat = Math.max(maxPlat,count);
        }
        return maxPlat;
    }
    public static void main(String[] args) {
        int[] arr ={900,945,955,1100,1500,1800};
		int[] dep={920,1200,1130,1150,1900,2000};
		int n=arr.length;
		int totalCount=findPlatform(arr,dep);
		System.out.println("Minimum number of Platforms required "+totalCount);
	}
    
}
