import java.util.*;
class Contest417{
    //FIRST PROBLEM
    public static char kthCharacter(int k) {
        StringBuilder word = new StringBuilder("a");
        while(word.length()<k){
            int currentLength = word.length();
            for(int i=0;i<currentLength;i++){
                word.append((char)(word.charAt(i)+1));
            }
        }
        return word.charAt(k-1);
    }


    //SECOND PROBLEM
    public static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
    public static int countOfSubstrings(String word, int k) {
        int n = word.length();
        int count = 0;

        // Sliding window approach
        //n-5 substring length should be minimum 5 and after n-5 it will be less than so it doesn't make sense to check beyond n-5
        for (int i = 0; i <= n - 5; i++) {
            int consonantCount = 0;
            HashSet<Character> vowelsSet = new HashSet<>();

            for (int j = i; j < n; j++) {
                char c = word.charAt(j);
                
                if (isVowel(c)) {
                    vowelsSet.add(c);  // Add vowels to the set
                } else {
                    consonantCount++;  // Count consonants
                }

                // If the current substring contains all 5 vowels and exactly k consonants
                if (vowelsSet.size() == 5 && consonantCount == k) {
                    count++;
                }
                
                // If consonants exceed k, break early
                if (consonantCount > k) {
                    break;
                }
            }
        }
        
        return count;
    }
    public static void main(String[] args) {
        // System.out.println(kthCharacter(5));

        System.out.println(countOfSubstrings("ieaouqqieaouqq", 1));
    }
}
