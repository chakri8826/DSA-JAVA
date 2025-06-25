class Pair{
    String word;
    int len;
    public Pair(String word,int len){
        this.word = word;
        this.len = len;
    }
}
class G20WordLadder1{
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> st = new HashSet<>(wordList);
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord,1));
        while(!q.isEmpty()){
            Pair p = q.poll();
            String word = p.word;
            int len = p.len;
            if(word.equals(endWord))return len;
            for(int i=0;i<word.length();i++){
                for(char c='a';c<='z';c++){
                    char[] charArr = word.toCharArray();
                    charArr[i]=c;
                    String replacedWord = new String(charArr);
                    if(st.contains(replacedWord)){
                        q.offer(new Pair(replacedWord,len+1));
                        st.remove(replacedWord);                    
                    }
                }
            }
        }
        return 0;
    }
}