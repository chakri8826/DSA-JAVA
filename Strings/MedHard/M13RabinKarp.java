class M13RabinKarp{
    public ArrayList<Integer> rabinKarp(String txt, String pat) {
        int d=256,mod=101,n=txt.length(),m=pat.length();
        ArrayList<Integer> ans = new ArrayList<>();
        
        int patHash=0,tHash=0;
        for(int i=0;i<m;i++){
            patHash = (patHash*d+pat.charAt(i))%mod;
            tHash = (tHash*d+txt.charAt(i))%mod;
        }
        int h=1;
        for(int i=0;i<m-1;i++){
            h=(h*d)%mod;
        }
        int i=0,j=m-1;
        while(j<n){
            if(patHash==tHash){
                if(txt.substring(i,j+1).equals(pat)){
                    ans.add(i);
                }
            }
            if(j+1<n){
                tHash = ((tHash-txt.charAt(i)*h)*d+txt.charAt(j+1))%mod;
                if(tHash<0)tHash+=mod;
            }
            i++;j++;
        }
        return ans;
    }
}