public class B2PowOf2 {
    public boolean isPowerOfTwo(int n) {
        // if(n <= 0)?
        // Negative numbers (n < 0) are not powers of 2 because they use    two’s complement representation in Java.

        if(n<=0) return false;
        return (n&n-1)==0;
    }
}
