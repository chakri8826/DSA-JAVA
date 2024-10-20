import java.util.*;
public class Contest420 {
    public String key2(String s) {
        char[] ch = s.toCharArray();
        char lastChar = ch[ch.length - 1]; // Get the last character
        char nextChar = (char)(lastChar + 1); // Increment to the next character
        ch[ch.length - 1] = nextChar; // Update the last character
        return new String(ch); // Return the modified string
    }
    public List<String> stringSequence(String target) {
        List<String> ans = new ArrayList<>();
        String curr = "";
        for (int i = 0; i < target.length(); i++) {
            curr+="a";
            ans.add(curr);
            while (curr.charAt(i) != target.charAt(i)) {
                curr = key2(curr); // Change the last character
                ans.add(curr); // Add the current state to the result
            }
        }
        return ans; // Return the generated sequence
    }



    // public static boolean valid(String s,int k){
    //     HashMap<Character,Integer> map = new HashMap<>();
    //     for(int i=0;i<s.length();i++){
    //         map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
    //     }
    //     for(Map.Entry<Character,Integer> e : map.entrySet()){
    //         if(e.getValue()>=k){
    //             return true;
    //         }
    //     }
    //     return false;
        
    // }
    // public int numberOfSubstrings(String s, int k) {
    //     int count=0;
    //     for(int i=0;i<s.length();i++){
    //         for(int j=i+1;j<=s.length();j++){
    //             String sub = s.substring(i,j);
    //             if(valid(sub,k)){
    //                 count++;
    //             }
    //         }
    //     }
    //     return count;
    // }

    public int numberOfSubstrings(String s, int k) {
        int n = s.length();
        int count = 0;
        for (int left = 0; left < n; left++) {
            int[] freq = new int[26];
            int maxFreq = 0;
            for (int right = left; right < n; right++) {
                freq[s.charAt(right) - 'a']++;
                maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'a']);
                if (maxFreq >= k) {
                    count += n - right;
                    break;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Contest420 c = new Contest420();
        // System.out.println(c.stringSequence("abc"));
        
        System.out.println(c.numberOfSubstrings("abacb", 2));
    }
}


