public class A18ReArrangeElesArr {
    // public int[] rearrangeArray(int[] nums) {
    //     ArrayList<Integer> pos = new ArrayList<>();
    //     ArrayList<Integer> neg = new ArrayList<>();
    //     int n = nums.length;
    //     for(int i=0;i<n;i++){
    //         if(nums[i]>0) pos.add(nums[i]);
    //         else neg.add(nums[i]);
    //     } 
    //     int pind=0,nind=0;
    //     for(int i=0;i<n;i++){
    //         if(i%2==0){
    //             nums[i]=pos.get(pind++);
    //         }
    //         else{
    //             nums[i]=neg.get(nind++);
    //         }
    //     }
    //     return nums;
    // }


    public int[] rearrangeArray(int[] nums){
        int pind=0,nind=1,n=nums.length;
        int res[] = new int[n];
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                res[pind]=nums[i];
                pind+=2;
            }
            else{
                res[nind]=nums[i];
                nind+=2;
            }
        }
        return res;
    }
}
