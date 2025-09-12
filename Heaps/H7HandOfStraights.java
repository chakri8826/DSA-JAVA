import java.util.*;
public class H7HandOfStraights {
     // Overall worst-case TC = O(n²) && SC = O(m)(all unique keys in map and pq)
    //  public boolean isNStraightHand(int[] hand, int groupSize) {
    //     if(hand.length%groupSize!=0)return false;
    //     PriorityQueue<Integer> pq = new PriorityQueue<>();
    //     HashMap<Integer,Integer> countMap = new HashMap<>();
    //     for(int num:hand){  //O(n)
    //         countMap.put(num,countMap.getOrDefault(num,0)+1);
    //     }

    //     for(int key:countMap.keySet()){  //O(m log m).
    //         pq.add(key);
    //     }
         
    //     while(!pq.isEmpty()){   //  O(n · m).
    //         int num = pq.peek();
    //         for(int i=0;i<groupSize;i++){
    //             if(!countMap.containsKey(num+i)) return false;
    //             countMap.put(num+i,countMap.get(num+i)-1);
    //             if(countMap.get(num+i)==0){
    //                 pq.remove(num+i);    // <-- this is O(m) !!
    //                 countMap.remove(num+i);
    //             }
    //         }
    //     }
    //     return true;
    // }

    //O(n log n) at worst case all are unique so (n log n)
    // public boolean isNStraightHand(int[] hand, int groupSize) {
    //     if(hand.length%groupSize!=0)return false;
    //     TreeMap<Integer,Integer> countMap = new TreeMap<>();

    //     for(int key:hand){  //O(n log m) m = unique keys of Map
    //         countMap.put(key, countMap.getOrDefault(key, 0) + 1);
    //     }

    //     while(!countMap.isEmpty()){  // O(n log m)
    //         int num = countMap.firstKey();
    //         for(int i=0;i<groupSize;i++){
    //             if(!countMap.containsKey(num+i)) return false;
    //             countMap.put(num+i,countMap.get(num+i)-1);
    //             if(countMap.get(num+i)==0){
    //                 countMap.remove(num+i);
    //             }
    //         }
    //     }
    //     return true;
    // }

    public boolean isNStraightHand(int[] hand, int groupSize) {
        Arrays.sort(hand); // O(n log n)

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int card : hand) {
            countMap.put(card, countMap.getOrDefault(card, 0) + 1);
        }

        for (int card : hand) {
            if (countMap.get(card) > 0) {
                // need to build a group starting at 'card'
                for (int i = 0; i < groupSize; i++) {
                    int curr = card + i;
                    if (!countMap.containsKey(curr) || countMap.get(curr) == 0) {
                        return false;
                    }
                    countMap.put(curr, countMap.get(curr) - 1);
                }
            }
        }
        return true;
    }

}
