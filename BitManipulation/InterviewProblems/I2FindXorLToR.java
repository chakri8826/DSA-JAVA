class I2FindXorLToR{
      // BRUTE
    // public static int findXOR(int l, int r) {
    //     int res=0;
    //     for(int i=l;i<=r;i++){
    //         res^=i;
    //     }
    //     return res;
    // }
    
    // This function will return XOR of all numbers from 1 to n
    public static int f(int n){
        if(n%4==1) return 1;
        else if(n%4==2) return n+1;
        else if(n%4==3) return 0;
        else return n;
    }
    public static int findXOR(int l, int r) {
        return f(l-1) ^ f(r);
    }
    public static void main(String[] args) {
        System.out.println(findXOR(5, 8));
    }   
}