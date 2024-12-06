import java.util.HashMap;

public class S4LongestRepeatingChars {
    //BRUTE FORCE
    // public int characterReplacement(String s, int k) {
    //     int n = s.length();
    //     int maxlen=0;
    //     for(int i=0;i<n;i++){
    //         // HashMap<Character,Integer> map = new HashMap<>();
    //         int hash[] = new int[26];
    //         int maxi=0;
    //         for(int j=i;j<n;j++){
    //             // map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
    //             hash[s.charAt(j)-'A']++;
    //             // maxi = Math.max(maxi,map.get(s.charAt(j)));
    //             maxi = Math.max(maxi, hash[s.charAt(j)-'A']);
    //             if((j-i+1)-maxi<=k){
    //                 maxlen = Math.max(maxlen,j-i+1);
    //             }
    //             else{
    //                 break;
    //             }
    //         }
    //     }
    //     return maxlen;
    // }

    //OPTI
    public static int characterReplacement(String s, int k) {
        int n = s.length();
        int maxlen=0;
        // HashMap<Character,Integer> map = new HashMap<>();
        int hash[] = new int[26];
        int maxi=0;
        int l=0;
        int r=0;
        while(r<n){
            // map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)+1);
            hash[s.charAt(r)-'A']++;
            // maxi=Math.max(maxi,map.get(s.charAt(r)));
            maxi = Math.max(maxi, hash[s.charAt(r)-'A']);
            if((r-l+1)-maxi>k){
                // map.put(s.charAt(l),map.get(s.charAt(l))-1);
                hash[s.charAt(l)-'A']--;
                // if(map.get(s.charAt(l))==0){
                //     map.remove(s.charAt(l));
                // }
                l++;
            }
            maxlen = Math.max(maxlen,r-l+1);
            r++;
        }
        return maxlen;
    }
    public static void main(String[] args) {
        String s = "ABAB";
        int k=2;
        System.out.println(characterReplacement(s, k));
    }
}