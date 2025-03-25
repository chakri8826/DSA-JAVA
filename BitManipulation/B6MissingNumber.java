public class B6MissingNumber {
        // public int missingNumber(int[] nums) {
    //     int n=nums.length;
    //     int vis[] = new int[n+1];
    //     for(int i=0;i<n;i++){
    //         vis[nums[i]]=1;
    //     }
    //     int j=-1;
    //     for(int i=0;i<=n;i++){
    //         if(vis[i]==0){
    //             j=i;
    //             break;
    //         }
    //     }
    //     return j;
    // }

    // IN THIS IF ARR HAVE MAX_LENGTH THEN INT CAN'T STORE IT, WE SHOULD USE LONG SO SLIGHTLY TAKES MUCH SPACE THAN XOR METHOD
    // public int missingNumber(int[] nums) {
    //     int n=nums.length,sum=0;
    //     sum=n*(n+1)/2;
    //     for(int i=0;i<n;i++){
    //         sum-=nums[i];
    //     }
    //     return sum;
    // }

    //USING XOR
    // public int missingNumber(int[] nums) {
    //     int n=nums.length,xor1=0,xor2=0;
    //     for(int i=0;i<=n;i++){
    //         xor1^=i;
    //     }
    //     for(int i=0;i<n;i++){
    //         xor2^=nums[i];
    //     }
    //     return xor1^xor2;
    // }    

    //USING XOR  still optimizing
    // public int missingNumber(int[] nums) {
    //     int n=nums.length,xor1=0,xor2=0;
    //     for(int i=0;i<n;i++){
    //         xor1^=i;
    //         xor2^=nums[i];
    //     }
    //     xor1^=n;
    //     return xor1^xor2;
    // }  
}
