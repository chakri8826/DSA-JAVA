class D2 {
    public int countPermutations(int[] complexity) {
        int n = complexity.length;
        for(int i=1;i<n;i++){
            if(complexity[i]<=complexity[0])return 0;
        }
        return (int) fact(n-1);
    }
    private long fact(int n){
        int mod = 1000000007;
        if(n==0 || n==1) return 1;
        return  (long) n*fact(n-1) % mod;
    }
}
