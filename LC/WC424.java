public class WC424 {
    //FIRST 
    public boolean canPossible(int dup[],int curr,int dir){
        int n = dup.length;
        int flag=0;
        while(curr<n && curr>=0){
                if(dup[curr]==0){
                    curr=curr+dir;
                }
                else if(dup[curr]>0){
                    dup[curr] = dup[curr]-1;
                    dir = dir*-1;
                    curr=curr+dir;
                }
                flag=0;
                for(int num:dup){
                    if(num!=0){
                        flag=1;
                        break;
                    }
                }
        }
        return flag!=1;
    }
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int ans=0;
        for(int start=0;start<n;start++){
            if(nums[start]==0){
                if(canPossible(nums.clone(),start,1)){
                    ans++;
                }
                if(canPossible(nums.clone(),start,-1)){
                    ans++;
                }
            }
        }
        return ans;
    }



    //SECOND
    public boolean isZeroArray(int[] nums, int[][] queries) {
        for(int i=0;i<queries.length;i++){
            for(int st=queries[i][0];st<=queries[i][1];st++){
                if(nums[st]!=0){
                    nums[st]-=1; 
                }
            }
        }
        for(int num:nums){
            if(num!=0) return false;
        }
        return true;
    }
}
