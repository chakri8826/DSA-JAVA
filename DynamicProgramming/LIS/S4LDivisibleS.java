import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class S4LDivisibleS {
 
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int dp[] = new int[n];
        Arrays.fill(dp,1);
        int hash[] = new int[n];
        int maxi=1,lastInd=0;
        for(int i=0;i<n;i++){
            hash[i]=i;
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0 && 1+dp[j]>dp[i]){
                    dp[i]=1+dp[j];
                    hash[i]=j;
                }
            }
            if(dp[i]>maxi){
                maxi=dp[i];
                lastInd=i;
            }
        }
        ArrayList<Integer> li = new ArrayList<>();
        li.add(nums[lastInd]);
        while(hash[lastInd]!=lastInd){
            lastInd = hash[lastInd];
            li.add(nums[lastInd]);
        }
        Collections.reverse(li);
        return li;
    }
}
