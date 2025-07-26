import java.util.HashMap;

public class B7Anagram {
    // public boolean isAnagram(String s, String t) {
    //     if(s.length()!=t.length())return false;
    //     HashMap<Character,Integer> map = new HashMap<>();
    //     for(char c:s.toCharArray()){
    //         map.put(c,map.getOrDefault(c,0)+1);
    //     }
    //     for(char c:t.toCharArray()){
    //         // if(map.containsKey(c)){
    //         //     map.put(c,map.get(c)-1);
    //         //     if(map.get(c)==0){
    //         //         map.remove(c);
    //         //     }
    //         // }
    //         // else return false;

    //         if(!map.containsKey(c)) return false;
    //         map.put(c,map.get(c)-1);
    //         if(map.get(c)<0)return false;
    //     }
    //     return true;
    // }


    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] count = new int[26];//O(1) space

        //O(n) time
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int c : count) {
            if (c != 0) return false;
        }

        return true;
    }
}
