class B5CountNoOfBits1toN{
    static int largestPowerOf2InRange(int n){
        int x=0;
        while((1<<x)<=n){
            x++;
        }
        return x-1;
    }
    static int countSetBits(int n){
        if(n==0)return 0;
        int x= largestPowerOf2InRange(n);
        int nbsbeforex = x*(1<<(x-1));
        int afterz = n-(1<<x)+1;
        int res = n-(1<<x);
        int ans =nbsbeforex + afterz + countSetBits(res);
        return ans;
    }
    public static void main(String[] args) {
        int n = 17;
        System.out.println(countSetBits(n));
    }
}