import java.util.*;
class BookCollection {
    public static boolean isAllocPoss(int barrier,int arr[],int m){
        int ac=1;
        int pages=0;
        if(arr[0]>barrier){
            return false;
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]+pages>barrier){
                ac+=1;
                pages=arr[i];
            }
            else{
                pages+=arr[i];
            }
        }
        if(ac>m){
            return false;
        }
        return true;
    }
    public static long findPages(int n, int[] arr, int m) {
        Arrays.sort(arr);
        int low=arr[0];
        int high=0;
        long res=0;
        if (n < m) return -1;
        for(int i=0;i<n;i++){
            high+=arr[i];
        }
        while(low<=high){
            int mid=(low+high)/2;
            if(isAllocPoss(mid,arr,m)){
                res=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int arr[]={12,34,67,90};
        System.out.println(findPages(4, arr,2));    
    }
}




// class Solution {
//     // Function to find minimum number of pages.
//     public static boolean isPossible(int n, int[] arr, int m, long curMin) {
//         int studentsRequired = 1;
//         long curSum = 0;

//         // Iterating over all the books.
//         for (int i = 0; i < n; i++) {
//             // If current number of pages are greater than curMin, return false.
//             if (arr[i] > curMin) return false;

//             // Counting number of students required to distribute curMin pages.
//             if (curSum + arr[i] > curMin) {
//                 // Incrementing student count and updating curSum.
//                 studentsRequired++;
//                 curSum = arr[i];

//                 // If students required becomes greater than the given number of
//                 // students, return false.
//                 if (studentsRequired > m) return false;
//             } else {
//                 // Else updating curSum.
//                 curSum += arr[i];
//             }
//         }
//         return true;
//     }

//     // Function to find the minimum number of pages.
//     public static long findPages(int n, int[] arr, int m) {
//         long sum = 0;

//         // Returning -1 if the number of books is less than the number of students.
//         if (n < m) return -1;

//         // Counting total number of pages.
//         for (int i = 0; i < n; i++) sum += arr[i];

//         // Initializing start as 0 pages and end as total pages.
//         long start = 0;
//         long end = sum;
//         long ans = (long)1e15;

//         while (start <= end) {
//             long mid = (start + end) / 2;

//             // Checking if it is possible to distribute books using mid as the current
//             // minimum.
//             if (isPossible(n, arr, m, mid)) {
//                 // If yes, then we find the minimum distribution.
//                 ans = Math.min(ans, mid);

//                 // As we are finding minimum and books are sorted, reducing end as end =
//                 // mid - 1.
//                 end = mid - 1;
//             } else {
//                 // If not possible, pages should be increased so updating start = mid
//                 // + 1.
//                 start = mid + 1;
//             }
//         }
//         // Returning minimum number of pages.
//         return ans;
//     }
// };