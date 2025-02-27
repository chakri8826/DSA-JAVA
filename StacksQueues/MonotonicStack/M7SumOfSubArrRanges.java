import java.util.Stack;

public class M7SumOfSubArrRanges {
    // BRUTE
    // public long subArrayRanges(int[] nums) {
    //     int n = nums.length;
    //     long sum=0;
    //     for(int i=0;i<n;i++){
    //         long maxi=nums[i];
    //         long mini=nums[i];
    //         for(int j=i;j<n;j++){
    //             maxi=Math.max(maxi,nums[j]);
    //             mini=Math.min(mini,nums[j]);
    //             sum+=(maxi-mini);
    //         }
    //     }
    //     return sum;
    // }


    // OPTIMAL  
    public int[] findNSE(int[] nums){
        int res[] = new int[nums.length];
        Stack<Integer> st = new Stack<>();
        for(int i=nums.length-1;i>=0;i--){
            while(!st.isEmpty() && nums[i]<=nums[st.peek()]){
                st.pop();
            }
            res[i]=st.isEmpty()?nums.length:st.peek();
            st.push(i);
        }
        return res;
    }

    public int[] findPSE(int[] nums){
        int res[] = new int[nums.length];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<nums.length;i++){
            while(!st.isEmpty() && nums[i]<nums[st.peek()]){
                st.pop();
            }
            res[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        return res;
    }


    public long minimum(int[] nums){
        int nse[] = findNSE(nums);
        int pse[] = findPSE(nums);
        long total=0;
        for(int i=0;i<nums.length;i++){
            long r = nse[i]-i;
            long l = i-pse[i];
            total = total+(r*l*nums[i]);
        }
        return total;
    }







    public int[] findNGE(int[] nums){
        int res[] = new int[nums.length];
        Stack<Integer> st = new Stack<>();
        for(int i=nums.length-1;i>=0;i--){
            while(!st.isEmpty() && nums[i]>=nums[st.peek()]){
                st.pop();
            }
            res[i]=st.isEmpty()?nums.length:st.peek();
            st.push(i);
        }
        return res;
    }

    public int[] findPGE(int[] nums){
        int res[] = new int[nums.length];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<nums.length;i++){
            while(!st.isEmpty() && nums[i]>nums[st.peek()]){
                st.pop();
            }
            res[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        return res;
    }


    public long maximum(int[] nums){
        int nge[] = findNGE(nums);
        int pge[] = findPGE(nums);
        long total=0;
        for(int i=0;i<nums.length;i++){
            long r = nge[i]-i;
            long l = i-pge[i];
            total = total+(r*l*nums[i]);
        }
        return total;
    }

    public long subArrayRanges(int[] nums) {
        return maximum(nums)-minimum(nums);
    }
}
