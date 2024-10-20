class KthBit{
    //BRUTE FORCE
    // public static String revInvert(StringBuilder sb){
    //     for(int i=0;i<sb.length();i++){
    //         if(sb.charAt(i)=='1'){
    //             sb.setCharAt(i, '0');
    //         }
    //         else{
    //             sb.setCharAt(i, '1');
    //         }
    //     }
    //     return sb.reverse().toString();
    // }
    // public static char findKthBit(int n, int k) {
    //     StringBuilder res = new StringBuilder();
    //     res.append("0");
    //     for(int i=1;i<n;i++){
    //         StringBuilder sb = new StringBuilder(res);
    //         res.append("1"+revInvert(sb));
    //     }
    //     System.out.println(res);
    //     return res.charAt(k-1);
    // }
    

    //OPTIMIZED
    public static char findKthBit(int n, int k) {
        if(n==1) return '0';
        int len = (int) Math.pow(2,n)-1;
        int mid = (len/2)+1;
        if(k==mid) return '1';
        else if(k<mid) return findKthBit(n-1,k);
        else{
            char r = findKthBit(n,len-k+1); 
            return r=='0'?'1':'0';
        }
    }
    public static void main(String[] args) {
        System.out.println(findKthBit(4, 11));
    }
}
