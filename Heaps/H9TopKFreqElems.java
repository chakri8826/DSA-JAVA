import java.util.*;
class Pair {
    int freq;
    int num;
    Pair(int num, int freq) {
        this.freq = freq;
        this.num = num;
    }
}

public class H9TopKFreqElems {
     // public int[] topKFrequent(int[] nums, int k) {
    //     HashMap<Integer,Integer> map = new HashMap<>();
    //     PriorityQueue<Pair> pq = new  PriorityQueue<>((a, b) -> a.freq - b.freq);

    //     for(int i=0;i<nums.length;i++){
    //         map.put(nums[i],map.getOrDefault(nums[i],0)+1);
    //     }

    //     for(Map.Entry<Integer,Integer> e: map.entrySet()){
    //         pq.add(new Pair(e.getKey(),e.getValue()));
    //         if(pq.size()>k)pq.poll();
    //     }

    //     int res[] = new int[k];
    //     int ind=0;
    //     while(ind<k){
    //         res[ind++]=pq.poll().num;
    //     }
    //     return res;
    // }



    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        
        ArrayList<ArrayList<Integer>> freq = new ArrayList<>();
        for(int i=0;i<=n;i++){
            freq.add(new ArrayList<>());
        }

        for(Map.Entry<Integer,Integer> e: map.entrySet()){
            freq.get(e.getValue()).add(e.getKey());
        }

        int res[] = new int[k];
        int ind=0;
        for(int i=n;i>=0;i--){
            if(k>0){
                for(int num:freq.get(i)){
                    res[ind++]=num;
                    k--;
                }
            }
            else break;
        }
        return res;
    }
}
