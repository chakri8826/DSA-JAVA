import java.util.HashMap;

public class S5LongSubStrWIthAtMostK {
    //BRUTE
	// public static int getLengthofLongestSubstring(int k, String s) {
	// 	int n = s.length();
    //     int len = -1; // Initialize to -1 in case no valid substring is found
    //     for (int i = 0; i < n; i++) {
    //         HashMap<Character, Integer> map = new HashMap<>();
    //         for (int j = i; j < n; j++) {
    //             map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
    //             if (map.size() <= k) {
    //                 len = Math.max(j - i + 1,len);
    //             } else {
    //                 break;
    //             }
    //         }
    //     }
    //     return len;
	// }


    //BRUTE
    // public static int getLengthofLongestSubstring(int k, String s) {
    //     int n = s.length();
    //     int len = -1; // Initialize to -1 in case no valid substring is found
    //     for (int i = 0; i < n; i++) {
    //         HashSet set = new HashSet<>();
    //         for (int j = i; j < n; j++) {
    //             set.add(s.charAt(j));
    //             if (set.size()>k) break;
    //             len = Math.max(j - i + 1,len);
    //         }
    //     }
    //     return len;
    // }


    //OPTI
    public static int getLengthofLongestSubstring(int k, String s){
        int l=0,r=0,n=s.length(),maxLen=0;
        HashMap<Character, Integer> map = new HashMap<>();
        while(r<n){
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            while(map.size()>k){
                map.put(s.charAt(l),map.get(s.charAt(l))-1);
                if(map.get(s.charAt(l))==0){
                    map.remove(s.charAt(l));
                }
                l++;
            }
            maxLen = Math.max(maxLen,r-l+1);
            r++;
        }
        return maxLen;
    }
}
