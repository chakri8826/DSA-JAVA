public class A19NextPermutation {
    // public void nextPermutation(int[] nums) {
    //     int bp=-1,poss=-1,n=nums.length;
    //     int res[] = new int[n];
    //     boolean look[] = new boolean[n];
    //     ArrayList<Integer> li = new ArrayList<>();
    //     for(int i=n-2;i>=0;i--){
    //         if(nums[i]<nums[i+1]){
    //             bp=i;
    //             break;
    //         }
    //     }
    //     if(bp==-1){
    //         ArrayList<Integer> list = new ArrayList<>();
    //         for(int i=0;i<n;i++){
    //             list.add(nums[i]);
    //         }
    //         Collections.sort(list);
    //         int ind=0;
    //         for(int i=0;i<n;i++){
    //             nums[i]=list.get(ind++);
    //         }
    //     }
    //     else{
    //         for(int i=0;i<bp;i++){
    //             look[i]=true;
    //             res[i]=nums[i];
    //         }

    //         for(int i=n-1;i>=0;i--){
    //             if(nums[i]>nums[bp]){
    //                 poss=i;
    //                 break;
    //             }
    //         }
    //         res[bp]=nums[poss];
    //         look[poss]=true;
    //         for(int i=0;i<n;i++){
    //             if(!look[i]){
    //                 li.add(nums[i]);
    //             }
    //         }
    //         Collections.sort(li);
    //         int ind=0;
    //         for(int i=bp+1;i<n;i++){
    //             res[i]=li.get(ind++);
    //         }
    //         for(int i=0;i<n;i++){
    //             nums[i]=res[i];
    //         }
    //     }
    // }

    public void swap(int a,int b,int[] nums){
        int temp = nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
    public void reverse(int start,int end,int[] nums){
        while(start<end){
            swap(start++,end--,nums);
        }
    }

     // WE CANNOT DO LIKE THIS
    // public void nextPermutation(int[] nums) {
    //     int bp=-1,n=nums.length;
    //     for(int i=n-1;i>0;i--){
    //         for(int j=i-1;j>=0;j--){
    //             if(nums[j]<nums[i]){
    //                 swap(i,j,nums);
    //                 reverse(j+1,n-1,nums);
    //                 bp=1;
    //                 break;
    //             }
    //         }
    //             if(bp==1)break;
    //     }
    //     if(bp==-1){
    //         reverse(0,n-1,nums);
    //     }
    // }

    public void nextPermutation(int[] nums) {
        int bp=-1,n=nums.length;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                bp=i;
                break;
            }
        }
        if(bp==-1){
            reverse(0,n-1,nums);
        }
        else{
            for(int i=n-1;i>=0;i--){
                if(nums[i]>nums[bp]){
                    swap(bp,i,nums);
                    break;
                }
            }
            reverse(bp+1,n-1,nums);
        }
    }

    
}

