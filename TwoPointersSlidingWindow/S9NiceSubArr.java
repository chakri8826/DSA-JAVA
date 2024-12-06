public class S6NiceSubArr {
    // public int numberOfSubarrays(int[] nums, int k) {
    //     int n = nums.length;
    //     int res=0;
    //     for(int i=0;i<n;i++){
    //         int cnt=0;
    //         for(int j=i;j<n;j++){
    //             if(nums[j]%2!=0) cnt++;
    //             if(cnt==k) res++;
    //         }
    //     }
    //     return res;
    // }


    public static int calSum(int[] nums, int k){
        int l=0,r=0,n=nums.length,sum=0,cnt=0;
        while(r<n){
            sum+=nums[r]%2;
            while(sum>k){
                sum-=(nums[l]%2);
                l++;
            }
            cnt += r-l+1;
            r++;
        }
        return cnt;
    }
    public static int numberOfSubarrays(int[] nums, int k){
        return calSum(nums,k) - calSum(nums,k-1); 
    }

    public static void main(String[] args) {
        int nums[] = {1,1,2,1,1};
        int k=3;
        System.out.println(numberOfSubarrays(nums, k));
    }
}

