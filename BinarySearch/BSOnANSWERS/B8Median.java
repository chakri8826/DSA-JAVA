class B8Median{
        // public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    //     int m=nums1.length,n=nums2.length;
    //     int arr[] = new int[m+n];
    //     for(int i=0;i<m;i++){
    //         arr[i]=nums1[i];
    //     }
    //     for(int i=0;i<n;i++){
    //         arr[m+i]=nums2[i];
    //     }
    //     Arrays.sort(arr);
    //     if((m+n)%2==0){
    //         return (double) ((arr[(m+n)/2] + arr[((m+n)/2)-1])/(2.0));
    //     }
    //     else return (double) arr[(m+n)/2];
    // }


    // BRUTE
    // public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    //     int m=nums1.length,n=nums2.length,i=0,j=0;
    //     int arr[] = new int[m+n];
    //     List<Integer> li = new ArrayList<>();
    //     while(i<m && j<n){
    //         if(nums1[i]<nums2[j]){
    //             li.add(nums1[i]);
    //             i++;
    //         }
    //         else{
    //             li.add(nums2[j]);
    //             j++;
    //         }
    //     }   
    //     while(i<m){
    //         li.add(nums1[i]);
    //         i++;
    //     }
    //     while(j<n){
    //         li.add(nums2[j]);
    //         j++;
    //     }

    //     if((m+n)%2==0){
    //         return (double) ( (li.get((m+n)/2) + li.get(((m+n)/2)-1))/(2.0) );
    //     }
    //     else return (double) li.get((m+n)/2);
    // }


    // BETTER
    // public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    //     int m=nums1.length,n=nums2.length,i=0,j=0,mid1Ele=-1,mid2Ele=-1,cnt=0;
    //     int mid2 = (m+n)/2;
    //     int mid1 = mid2-1;
    //     while(i<m && j<n){
    //         if(nums1[i]<nums2[j]){
    //             if(cnt==mid2) mid2Ele = nums1[i]; 
    //             if(cnt==mid1) mid1Ele = nums1[i];
    //             i++;
    //         }
    //         else{
    //             if(cnt==mid2) mid2Ele = nums2[j]; 
    //             if(cnt==mid1) mid1Ele = nums2[j];
    //             j++;
    //         }
    //         cnt++;
    //     }   
    //     while(i<m){
    //         if(cnt==mid2) mid2Ele = nums1[i]; 
    //         if(cnt==mid1) mid1Ele = nums1[i];
    //         i++;
    //         cnt++;
    //     }
    //     while(j<n){
    //         if(cnt==mid2) mid2Ele = nums2[j]; 
    //         if(cnt==mid1) mid1Ele = nums2[j];
    //         j++;
    //         cnt++;
    //     }
    //     if((m+n)%2==0){
    //         return (double) ((mid1Ele+mid2Ele)/(2.0));
    //     }
    //     else return (double) mid2Ele;
    // }


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length,n=nums2.length;
        if(m>n)return findMedianSortedArrays(nums2,nums1);
        int low=0,high=m;
        int left = (m+n+1)/2;
        while(low<=high){
            int mid1 = (low+high)>>1;
            int mid2 = left-mid1;
            int l1 = Integer.MIN_VALUE,l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE,r2 = Integer.MAX_VALUE;
            if(mid1<m) r1 = nums1[mid1];
            if(mid2<n) r2 = nums2[mid2];
            if(mid1-1>=0) l1 = nums1[mid1-1];
            if(mid2-1>=0) l2 = nums2[mid2-1];
            if(l1<=r2 && l2<=r1){
                if((m+n)%2==0) return (double)((Math.max(l1,l2)+Math.min(r1,r2))/(2.0));
                return (double)(Math.max(l1,l2));
            } 
            else if(l1>r2) high=mid1-1;
            else low=mid1+1;
        }
        return 0;
    }
    public static void main(String[] args) {
        B8Median obj = new B8Median();
        int nums1[] = {1,3};
        int nums2[] = {2};
        System.out.println(obj.findMedianSortedArrays(nums1,nums2));
        int nums3[] = {1,2};
        int nums4[] = {3,4};
        System.out.println(obj.findMedianSortedArrays(nums3,nums4));
    }
}