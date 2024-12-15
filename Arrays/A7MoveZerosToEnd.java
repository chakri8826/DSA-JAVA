public class A7MoveZerosToEnd {
    //brute
    // public void moveZeroes(int[] nums) {
    //     int zeroCount=0,n=nums.length,j=0;
    //     int res[] = new int[n];
    //     for(int i=0;i<n;i++){
    //         if(nums[i]==0)zeroCount++;
    //         else{
    //             res[j++]=nums[i];
    //         }
    //     }
    //     while(j<zeroCount){
    //         res[j]=0;
    //         j++;
    //     }
    //     for(int i=0;i<n;i++){
    //         nums[i]=res[i];
    //     }
    // }

    //OPTIMAL
    // public void moveZeroes(int[] nums){
    //     int l=0,r=0,n=nums.length;
    //     while(r<n){
    //         if(nums[r]!=0 && nums[l]==0){
    //             int temp = nums[r];
    //             nums[r]=nums[l];
    //             nums[l]=temp;
    //             l++;
    //         }
    //         else if(nums[l]!=0) l++;
    //         r++;
    //     }
    // }

    //OPTIMAL
    public void moveZeroes(int[] nums){
        int j=-1,n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                j=i;
                break;
            }
        }
        if(j!=-1){
            for(int i=j+1;i<n;i++){
                if(nums[i]!=0){
                    int temp = nums[i];
                    nums[i]=nums[j];
                    nums[j]=temp;
                    j++;
                }
            }
        }
    }




}
