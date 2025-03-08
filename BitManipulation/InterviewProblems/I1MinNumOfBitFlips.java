public class I1MinNumOfBitFlips {
    public int minBitFlips(int start, int goal) {
        int n = start^goal,cnt=0;
        while(n!=0){
            cnt++;
            n=n&n-1;
        }
        return cnt;

        // O(31) METHOD
        //  for(int i=0;i<=31;i++){
        //     if((n&(1<<i))!=0)cnt++;
        // }
        // return cnt;


        // DIRECT METHOD
        // return Integer.bitCount(n);
    }
}
