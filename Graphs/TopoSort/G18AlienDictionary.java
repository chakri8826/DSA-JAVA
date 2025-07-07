import java.util.LinkedList;
import java.util.Queue;

public class G18AlienDictionary {
    public StringBuilder topoSort(ArrayList<ArrayList<Integer>> graph,boolean[] exists,int inDegree[]){
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            if (exists[i] && inDegree[i] == 0) {
                q.offer(i);
            }
        }
        
        StringBuilder result = new StringBuilder();

        while (!q.isEmpty()) {
            int u = q.poll();
            result.append((char)(u + 'a'));

            for (int v : graph.get(u)) {
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    q.offer(v);
                }
            }
        }
        return result;
    }
    public String findOrder(String[] words) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[26];
        boolean[] exists = new boolean[26];

        // Initialize graph
        for (int i = 0; i < 26; i++) {
            graph.add(new ArrayList<>());
        }


        // Mark characters that exist in the input
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                exists[ch - 'a'] = true;
            }
        }
        int cnt = 0;
        for (int i = 0; i < 26; i++) {
            if (exists[i]) cnt++;
        }

        for(int i=0;i<words.length-1;i++){
            String w1 = words[i];
            String w2 = words[i+1];

            
            if(w1.startsWith(w2) && w1.length() > w2.length()) return "";

            int len = Math.min(w1.length(), w2.length());
            for(int j=0;j<len;j++){
                if(w1.charAt(j)!=w2.charAt(j)){
                    graph.get(w1.charAt(j)-'a').add(w2.charAt(j)-'a');
                    inDegree[w2.charAt(j)-'a']++;
                    break;
                }
            }
        }
    
        StringBuilder result = topoSort(graph,exists,inDegree);
        // CYCLE DETECTION CHECK
        if(result.length()!=cnt)return "";
        return result.toString();
    }
}
