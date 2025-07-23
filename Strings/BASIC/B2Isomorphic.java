public class B2Isomorphic {
    // public boolean isIsomorphic(String s, String t) {
    //     HashMap<Character, Character> mapST = new HashMap<>();
    //     HashMap<Character, Character> mapTS = new HashMap<>();

    //     for (int i = 0; i < s.length(); i++) {
    //         char c1 = s.charAt(i);
    //         char c2 = t.charAt(i);

    //         if (mapST.containsKey(c1)) {
    //             if (mapST.get(c1) != c2) return false;
    //         }

    //         if (mapTS.containsKey(c2)) {
    //             if (mapTS.get(c2) != c1) return false;
    //         }

    //         mapST.put(c1, c2);
    //         mapTS.put(c2, c1);
    //     }

    //     return true;
    // }
    

    
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> charMapping = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sourceChar = s.charAt(i);
            char targetChar = t.charAt(i);

            if (charMapping.containsKey(sourceChar)) {
                if (charMapping.get(sourceChar) != targetChar) return false;
            } else if (charMapping.containsValue(targetChar)) {
                return false; // targetChar is already mapped to another sourceChar
            }

            charMapping.put(sourceChar, targetChar);
        }
        return true;
    }
}
