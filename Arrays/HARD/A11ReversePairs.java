public class A11ReversePairs {
    //BRUTE
    // public int reversePairs(int[] nums) {
    //     int cnt=0,n=nums.length;
    //     for(int i=0;i<n;i++){
    //         for(int j=i+1;j<n;j++){
    //             if(nums[i]>(long)2*nums[j]){
    //                 cnt++;
    //             }
    //         }
    //     }
    //     return cnt;
    // }

    //OPTIMAL
    public int m(int arr[],int lb,int mid,int ub){
        int i=lb,j=mid+1,k=0;
        int cnt=0;
        int b[] = new int[ub-lb+1];
        int j1=mid+1;
        for(int ind=lb;ind<=mid;ind++){
            while(j1<=ub && arr[ind]>(long)2*arr[j1]){
                j1++;
            }
            cnt+=(j1-mid-1);
        }
        
        while(i<=mid && j<=ub){
            if(arr[i]<arr[j]){
                b[k++]=arr[i++];
            }
            else{
                b[k++]=arr[j++];
            }
        }
        while(i<=mid){
            b[k++]=arr[i++];
        }
        while(j<=ub){
            b[k++]=arr[j++];
        }

        for(k=0;k<b.length;k++){
            arr[lb+k]=b[k];
        }
        return cnt;
    }
    
    public int merge(int arr[],int lb,int ub){
        int cnt = 0;
        if(lb<ub){
            int mid = (lb+ub)/2;
            cnt += merge(arr,lb,mid);
            cnt += merge(arr,mid+1,ub);
            cnt += m(arr,lb,mid,ub);
        }
        return cnt;
    }
    public int reversePairs(int[] nums) {
        return merge(nums,0,nums.length-1);
    }
}

