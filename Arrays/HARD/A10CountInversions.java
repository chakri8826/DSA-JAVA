public class A10CountInversions {
    //BRUTE
    // static int inversionCount(int arr[]) {
    //     int cnt = 0;
    //     int n = arr.length;
    //     for(int i=0;i<n;i++){
    //         for(int j=i+1;j<n;j++){
    //             if(arr[i]>arr[j]){
    //                 cnt++;
    //             }
    //         }
    //     }
    //     return cnt;
    // }
    
    // OPTIMAL
    static int m(int arr[],int lb,int mid,int ub){
        int i=lb,j=mid+1,cnt=0,k=0;
        int b[] = new int[ub-lb+1];
        
        while(i<=mid && j<=ub){
            if(arr[i]<=arr[j]){
                b[k++]=arr[i++];
            }
            else{
                b[k++]=arr[j++];
                cnt+=(mid-i+1);
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
    
    static int merge(int arr[],int lb,int ub){
        int cnt = 0;
        if(lb<ub){
            int mid = (lb+ub)/2;
            cnt += merge(arr,lb,mid);
            cnt += merge(arr,mid+1,ub);
            cnt += m(arr,lb,mid,ub);
        }
        return cnt;
    }
    static int inversionCount(int arr[]) {
        return merge(arr,0,arr.length-1);
    }
}
