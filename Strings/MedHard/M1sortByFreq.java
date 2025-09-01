import java.util.*;

public class M1sortByFreq {
    // public String frequencySort(String s) {
    //     HashMap<Character,Integer> map = new HashMap<>();
    //     for(Character c:s.toCharArray()){
    //         map.put(c,map.getOrDefault(c,0)+1);
    //     }
    //     List<Character> li = new ArrayList<>(map.keySet());
    //     Collections.sort(li,(a,b)->map.get(b)-map.get(a));
    //     StringBuilder sb = new StringBuilder();
    //     // for(int i=0;i<li.size();i++){
    //     //     for(int j=0;j<map.get(li.get(i));j++){
    //     //         sb.append(li.get(i));
    //     //     }
    //     // }
    
    //     for(int i=0;i<li.size();i++){
    //         sb.append(String.valueOf(li.get(i)).repeat(map.get(li.get(i))));
    //     }
    //     return sb.toString();
    // }


    // PIORITY QUEUE
    // public String frequencySort(String s) {
    //     // Step 1: Count frequency
    //     Map<Character, Integer> freq = new HashMap<>();
    //     for (char c : s.toCharArray()) {
    //         freq.put(c, freq.getOrDefault(c, 0) + 1);
    //     }

    //     // Step 2: Use max-heap sorted by frequency
    //     PriorityQueue<Map.Entry<Character, Integer>> pq = 
    //         new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

    //     pq.addAll(freq.entrySet());

    //     // Step 3: Build result
    //     StringBuilder sb = new StringBuilder();
    //     while (!pq.isEmpty()) {
    //         Map.Entry<Character, Integer> entry = pq.poll();
    //         char c = entry.getKey();
    //         int count = entry.getValue();
    //         for (int i = 0; i < count; i++) {
    //             sb.append(c);
    //         }
    //     }

    //     return sb.toString();
    // }


    // BUCKET SORT
    public String frequencySort(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // Bucket array: index = frequency, value = list of chars
        List<Character>[] bucket = new List[s.length() + 1];
        for (char c : freq.keySet()) {
            int f = freq.get(c);
            if (bucket[f] == null) {
                bucket[f] = new ArrayList<>();
            }
            bucket[f].add(c);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = s.length(); i >= 1; i--) {
            if (bucket[i] != null) {
                for (char c : bucket[i]) {
                    for (int j = 0; j < i; j++) {
                        sb.append(c);
                    }
                }
            }
        }

        return sb.toString();
    }

}