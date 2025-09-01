public class M6SumOfBeauty {
    // public int beautySum(String s) {
    //     int n = s.length(),res=0;
    //     for(int i=0;i<n;i++){
    //         int hash[] = new int[26];
    //         for(int j=i;j<n;j++){
    //             int charDig = s.charAt(j)-'a';
    //             hash[charDig]++;
    //             int maxi=Integer.MIN_VALUE,mini=Integer.MAX_VALUE;
    //             for(int ind=0;ind<26;ind++){
    //                 if(hash[ind]>0){
    //                     maxi=Math.max(maxi,hash[ind]);
    //                     mini=Math.min(mini,hash[ind]);
    //                 }
    //             }
    //             res+=(maxi-mini);
    //         }
             
    //     }
    //     return res;
    // }

    // SAME CODE BUT IT WILL BE UNDERSTOOD EASILY
    public int findBeauty(String str){
        int hash[] = new int[26];
        int maxi=Integer.MIN_VALUE,mini=Integer.MAX_VALUE;
        for(int i=0;i<str.length();i++){
            int charDig = str.charAt(i)-'a';
            hash[charDig]++;
        }
        for(int count:hash){
            if(count>0){
                maxi=Math.max(maxi,count);
                mini=Math.min(mini,count);
            }
        }
        return maxi-mini;
    }

    public int beautySum(String s) {
        int n = s.length(),res=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<s.length();j++){
                String str = s.substring(i,j+1);
                int cnt = findBeauty(str);
                res+=cnt;
            }
        }
        return res;
    }
}
