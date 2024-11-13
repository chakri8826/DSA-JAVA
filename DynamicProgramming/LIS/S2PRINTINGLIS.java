import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class S2PRINTINGLIS {
        public ArrayList<Integer> longestIncreasingSubsequence(int n, int arr[]) {
            int dp[] = new int[n];
            Arrays.fill(dp,1);
            int hash[] = new int[n];
            int maxi=1,lastInd=0;
            for(int i=0;i<n;i++){
                hash[i]=i;
                for(int j=0;j<i;j++){
                    if(arr[j]<arr[i] && 1+dp[j]>dp[i]){
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
            li.add(arr[lastInd]);
            while(hash[lastInd]!=lastInd){
                lastInd = hash[lastInd];
                li.add(arr[lastInd]);
            }
            Collections.reverse(li);
            return li;
        }
}

