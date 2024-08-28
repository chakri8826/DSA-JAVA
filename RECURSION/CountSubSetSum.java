public class CountSubSetSum {
    static int countSubsets(int arr[],int i,int sum){
        if(i==arr.length){
            return (sum==0)?1:0;
        }
        return countSubsets(arr, i+1, sum)+countSubsets(arr, i+1, sum-arr[i]);
    }
 
    // static int countSubsets(int arr[],int n,int sum){
    //     if(n==0){
    //         return (sum==0)?1:0;
    //     }
    //     return countSubsets(arr, n-1, sum)+countSubsets(arr, n-1, sum-arr[n-1]);
    // }


    

    public static void main(String[] args){
         int arr[]={10,20,15};
         int res=countSubsets(arr, 0, 25);
        // int res=countSubsets(arr, 3, 25);
         System.out.println(res);
        

        

    }   
}


 








