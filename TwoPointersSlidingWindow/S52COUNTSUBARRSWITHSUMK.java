import java.util.HashMap;

public class S52COUNTSUBARRSWITHSUMK {
    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int count=0,sum=0,n=nums.length;;
        map.put(0,1);
        for(int i=0;i<n;i++){
            sum+=nums[i];
            //checking method 1
            if(map.containsKey(sum-k)){
                count+=map.get(sum-k);
            }

            //checking method 2
            // int remove=sum-k;
            // count+=map.getOrDefault(remove,0);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,-3,1,1,1,4,2,-3};
        int k = 3;
        int cnt = subarraySum(arr, k);
        System.out.println("The number of subarrays is: " + cnt);
    }
}

