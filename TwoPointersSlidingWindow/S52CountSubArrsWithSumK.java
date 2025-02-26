import java.util.HashMap;

public class S52CountSubArrsWithSumK {
    // public static int subarraySum(int[] nums, int k) {
    //     HashMap<Integer,Integer> map = new HashMap<>();
    //     int count=0,sum=0,n=nums.length;;
    //     map.put(0,1);
    //     for(int i=0;i<n;i++){
    //         sum+=nums[i];
    //         //checking method 1
    //         if(map.containsKey(sum-k)){
    //             count+=map.get(sum-k);
    //         }

    //         //checking method 2
    //         // int remove=sum-k;
    //         // count+=map.getOrDefault(remove,0);
    //         map.put(sum,map.getOrDefault(sum,0)+1);
    //     }
    //     return count;
    // } 



    // IF U WANT TO IMPLEMENT LIKE LONGEST SUBARRAY WITH SUM PROBLEM U DONT NEED TO PUT (0,1) IN MAP U CAN DO LIKE THAT ITSELF
    public static int subarraySum(int[] arr, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int psum=0;
        int c=0;
        for(int i=0;i<arr.length;i++){
            psum+=arr[i];
            if (psum == k) c++;
            if(map.containsKey(psum-k)){
                c+=map.get(psum-k);
            }
            // HERE WE WONT CHECK LIKE if   -->(!map.containsKey(psum)) BECOZ WE NEED TO MAXIMIZE THE PREV psum
            map.put(psum,map.getOrDefault(psum,0)+1);
        }
        return c;   
    }


    public static void main(String[] args) {
        int[] arr = {3,-3,1,1,1};
        int k = 3;
        int cnt = subarraySum(arr, k);
        System.out.println("The number of subarrays is: " + cnt);
    }
}

