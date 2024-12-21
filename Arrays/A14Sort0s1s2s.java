public class A14Sort0s1s2s {
     // public void sortColors(int[] nums) {
    //     int n = nums.length,j=0;
    //     int count[] = new int[3];
    //     for(int i=0;i<n;i++){ 
    //         count[nums[i]]++; 
    //     }
    //     for(int i=0;i<3;i++){
    //         int cnt=0;
    //         while(cnt<count[i]){
    //             nums[j++] = i; 
    //             cnt++;
    //         }
    //     }
    // }


    public static void swap(int mid,int low,int nums[]){
        int temp = nums[mid];
        nums[mid]=nums[low];
        nums[low]=temp;
    }

    public void sortColors(int[] nums){
        int n=nums.length,low=0,mid=0,high=n-1;
        while(mid<=high){
            if(nums[mid]==0){
                swap(mid,low,nums);
                low++;
                mid++;
            }
            else if(nums[mid]==2){
                swap(mid,high,nums);
                high--;
            }
            else {
                mid++;
            }
        }
    }
}
