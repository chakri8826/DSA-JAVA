public class A8MergeSortedArrsLeetCode {
    // public void merge(int[] nums1, int m, int[] nums2, int n) {
    //     int i=0,j=0,ind=0;
    //     int res[] = new int[m+n];
    //     while(i<m && j<n){
    //         if(nums1[i]<nums2[j]){
    //             res[ind++] = nums1[i];
    //             i++;
    //         }
    //         else if(nums2[j]<nums1[i]){
    //             res[ind++] = nums2[j];
    //             j++;
    //         }
    //         else{
    //             res[ind++]=nums1[i];
    //             res[ind++]=nums2[j];
    //             i++;
    //             j++;
    //         }
    //     }
    //     while(i<m){
    //         res[ind++] = nums1[i];
    //         i++;
    //     }
    //     while(j<n){
    //         res[ind++] = nums2[j];
    //         j++;
    //     }
    //     for(int k=0;k<m+n;k++){
    //         nums1[k]=res[k];
    //     }
    // }    


    //OPTIMAL
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1,j=n-1,ind=m+n-1;
        while(i>=0 && j>=0){
            if(nums1[i]>nums2[j]){
                nums1[ind--]=nums1[i--];
            }
            else{
                nums1[ind--]=nums2[j--];
            }
        }
        while(j>=0){
            nums1[ind--]=nums2[j--];
        }
    }
    

}
