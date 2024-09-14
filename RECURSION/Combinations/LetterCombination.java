import java.util.*;

class LetterCombination {
    //LESS EFFICIENT CODE   
    // private static final String[] digitToLetters = {
    //     "",     // 0 has no letters
    //     "",     // 1 has no letters
    //     "abc",  // 2 -> 'a', 'b', 'c'
    //     "def",  // 3 -> 'd', 'e', 'f'
    //     "ghi",  // 4 -> 'g', 'h', 'i'
    //     "jkl",  // 5 -> 'j', 'k', 'l'
    //     "mno",  // 6 -> 'm', 'n', 'o'
    //     "pqrs", // 7 -> 'p', 'q', 'r', 's'
    //     "tuv",  // 8 -> 't', 'u', 'v'
    //     "wxyz"  // 9 -> 'w', 'x', 'y', 'z'
    // };

    // private List<String> res = new ArrayList<>();

    // public void possLC(String curr, String digits, int index) {
    //     // Base case: if the current combination length matches digits length
    //     if(curr.length()==digits.length()){
    //         res.add(curr);
    //         return;
    //     }
    //     if (index == digits.length()) {
    //         return;
    //     }
    //     // Get the letters for the current digit
    //     String letters = digitToLetters[digits.charAt(index) - '0'];
   
    //     // Loop through each letter and recurse
    //     for (int i = 0; i < letters.length(); i++) {
    //         possLC(curr + letters.charAt(i), digits, index + 1);
    //     }
    // }

    // public List<String> letterCombinations(String digits) {
    //     // Handle empty input
    //     if (digits == null || digits.isEmpty()) {
    //         return res;
    //     }
        
    //     // Start recursion from index 0
    //     possLC("", digits, 0);
    //     return res;
    // }


    //MORE EFFICIENT CODE
    private static final String[] digitToLetters = {
        "",     // 0 has no letters
        "",     // 1 has no letters
        "abc",  // 2 -> 'a', 'b', 'c'
        "def",  // 3 -> 'd', 'e', 'f'
        "ghi",  // 4 -> 'g', 'h', 'i'
        "jkl",  // 5 -> 'j', 'k', 'l'
        "mno",  // 6 -> 'm', 'n', 'o'
        "pqrs", // 7 -> 'p', 'q', 'r', 's'
        "tuv",  // 8 -> 't', 'u', 'v'
        "wxyz"  // 9 -> 'w', 'x', 'y', 'z'
    };

    private List<String> res = new ArrayList<>();

    public void possLC(int i,StringBuilder curr, String digits) {
        // Base case: if the current combination length matches digits length
        if (curr.length() == digits.length()) {
            res.add(curr.toString());
            return;
        }
        if(i==digits.length()){
            return;
        }
        // Get the letters for the current digit
        String letters = digitToLetters[digits.charAt(i) - '0'];
        
        // Loop through each letter and recurse
        for (int j = 0; j < letters.length(); j++) {
            curr.append(letters.charAt(j));
            possLC(i+1,curr, digits);
            curr.deleteCharAt(curr.length()-1);

        }
    }

    public List<String> letterCombinations(String digits) {
        // Handle empty input
        if (digits == null || digits.isEmpty()) {
            return res;
        }
        
        // Start recursion from index 0
        possLC(0,new StringBuilder(), digits);
        return res;
    }

    public static void main(String[] args) {
        LetterCombination lc = new LetterCombination();
        System.out.println(lc.letterCombinations("23")); // Example usage
    }
}
