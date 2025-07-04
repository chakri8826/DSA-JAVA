import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class G21WordLadder2 {
    // MY APPROACH
    public ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList) {

        ArrayList<ArrayList<String>> res = new ArrayList<>();

        Queue<ArrayList<String>> q = new LinkedList<>();

        Set<String> st = new HashSet<>();
        for (String word : wordList) {
            st.add(word);
        }

        ArrayList<String> startPath = new ArrayList<>();
        startPath.add(startWord);
        q.add(startPath);

        boolean found = false;
        while (!q.isEmpty()) {
            int size = q.size();
            Set<String> wordsUsedThisLevel = new HashSet<>();
            for (int i = 0; i < size; i++) {
                ArrayList<String> li = q.poll();
                String word = li.get(li.size() - 1);
                if (word.equals(targetWord)) {
                    found = true;
                    res.add(li);
                    continue;
                }
                for (int j = 0; j < word.length(); j++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char[] charArr = word.toCharArray();
                        charArr[j] = c;
                        String replacedWord = new String(charArr);
                        if (st.contains(replacedWord)) {
                            wordsUsedThisLevel.add(replacedWord);
                            ArrayList<String> newPath = new ArrayList<>(li);
                            newPath.add(replacedWord);
                            q.add(newPath);
                        }
                    }
                }
            }
            st.removeAll(wordsUsedThisLevel);
            if (found)
                break;
        }

        return res;

    }

    // public ArrayList<ArrayList<String>> findSequences(String startWord,
    //         String targetWord,
    //         String[] wordList) {
    //     ArrayList<ArrayList<String>> res = new ArrayList<>();

    //     Queue<ArrayList<String>> q = new LinkedList<>();
    //     Set<String> st = new HashSet<>();
    //     for (String word : wordList) {
    //         st.add(word);
    //     }

    //     Set<String> wordsUsedThisLevel = new HashSet<>();
    //     wordsUsedThisLevel.add(startWord);

    //     ArrayList<String> startPath = new ArrayList<>();
    //     startPath.add(startWord);
    //     q.add(startPath);

    //     int level = 0;
    //     while (!q.isEmpty()) {
    //         ArrayList<String> li = q.poll();
    //         if (li.size() > level) {
    //             level++;
    //             for (String wrd : wordsUsedThisLevel) {
    //                 st.remove(wrd);
    //             }
    //         }
    //         String word = li.get(li.size() - 1);
    //         if (word.equals(targetWord)) {
    //             res.add(li);
    //             continue;
    //         }
    //         for (int j = 0; j < word.length(); j++) {
    //             for (char c = 'a'; c <= 'z'; c++) {
    //                 char[] charArr = word.toCharArray();
    //                 charArr[j] = c;
    //                 String replacedWord = new String(charArr);
    //                 if (st.contains(replacedWord)) {
    //                     wordsUsedThisLevel.add(replacedWord);
    //                     ArrayList<String> newPath = new ArrayList<>(li);
    //                     newPath.add(replacedWord);
    //                     q.add(newPath);
    //                 }
    //             }
    //         }
    //     }

    //     return res;

    // }
}