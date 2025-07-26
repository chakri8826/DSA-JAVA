public class M6SumOfBeauty {
    public int beautySum(String s) {
        int n = s.length(),res=0;
        for(int i=0;i<n;i++){
            int hash[] = new int[26];
            for(int j=i;j<n;j++){
                int charDig = s.charAt(j)-'a';
                hash[charDig]++;
                int maxi=Integer.MIN_VALUE,mini=Integer.MAX_VALUE;
                for(int ind=0;ind<26;ind++){
                    if(hash[ind]>0){
                        maxi=Math.max(maxi,hash[ind]);
                        mini=Math.min(mini,hash[ind]);
                    }
                }
                res+=(maxi-mini);
            }
             
        }
        return res;
    }
}
