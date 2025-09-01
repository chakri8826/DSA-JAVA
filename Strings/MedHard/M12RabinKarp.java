public class M12RabinKarp {
    public int rabinKarp(String text,String patt){
        int m = text.length(),n = patt.length();
        int d = 256,prime=101;
        int t=0,p=0;
        for(int i=0;i<n;i++){
            p = (p * d + patt.charAt(i)) % prime;
            t = (t * d + text.charAt(i)) % prime;
        }
        int x = 1;
        for(int i=1;i<n;i++){
            x=(x*d)%prime;
        }
        for(int i=0;i<=m-n;i++){
            if(p==t){
                int j;
                for(j=0;j<n;j++){
                    if (patt.charAt(j) != text.charAt(i + j)) break;
                }
                if(j==n)return i;
            }
            if(i<m-n){
                t = ((t - text.charAt(i) * x) * d + text.charAt(i + n)) % prime;
                if(t<0)t=t+prime;
            }
        }
        return -1;
    }
}
