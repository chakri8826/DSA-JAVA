public class I8PowXN {
    public double myPow(double x, int n) {
        boolean neg = (n<0)?true:false;
        long m = n;
        double res=1;

        // m = Math.abs(m); can cause overflow when n = Integer.MIN_VALUE (-2³¹),
        // because Math.abs(Integer.MIN_VALUE) = Integer.MIN_VALUE (it cannot be represented as a positive integer in int).
        // So, we will use long instead of int.

        m=Math.abs(m);
        while(m>0){
            if((m&1)==1){
                res=res*x;
                m=m-1;
            }
            else{
                x=x*x;
                m>>=1;
            }
        }
        if(neg)return 1/res;
        return res;
    }
    public static void main(String[] args) {
        I8PowXN obj = new I8PowXN();
        double res = obj.myPow(2.00000, 10);
        System.out.println(res);
    }
}

