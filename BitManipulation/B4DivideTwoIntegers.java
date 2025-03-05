class B4DivideTwoIntegers{
    public int divide(int dividend, int divisor) {
        boolean sign=true;
        // OVERFLOW WILL HAPPEN ONLY FOR THIS CASE AND FOR (INT_MIN,1) (INT_MAX,1) (INT_MAX,-1) FOR THESE THREE INT CAN STROE THEM
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;


// Even though int can store most results, bitwise operations (d << cnt) can overflow when d is large, leading to infinite loops (TLE).
// To prevent this, converting dividend and divisor to long avoids bitwise shift overflow and ensures correct execution.
        if((dividend>0 && divisor<0) || (dividend<0 && divisor>0)) sign=false;
        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        int ans=0;
        while(n>=d){
            int cnt=0;
            while(n>=(d<<(cnt+1))){
                cnt++;
            }
            ans+=(1<<cnt);
            n=n-(d<<cnt);
        }
        
        return sign?ans:(-1*ans);
    }
}