import java.util.*;
public class H6TaskSheduler {

    // BRUTE FORCE
    // public int leastInterval(char[] tasks, int n) {
    //     int freq[] = new int[26];
    //     for(int i=0;i<tasks.length;i++){
    //         freq[tasks[i]-'A']++;
    //     }
    //     PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->Integer.compare(b,a));
    //     for(int num:freq){
    //         if(num>0)pq.add(num);
    //     }
    //     int ans=0;
    //     while(!pq.isEmpty()){
    //         int len=n+1;
    //         ArrayList<Integer> li = new ArrayList<>();
    //         int executed = 0;
    //         while(len>0 && !pq.isEmpty()){
    //             li.add(pq.poll()-1);
    //             executed+=1;
    //             len--;
    //         }
    //         for (int count : li) {
    //             if (count > 0) pq.add(count);
    //         }

    //         if(pq.isEmpty())ans+=executed;
    //         else ans+=(n+1);
    //     }
    //     return ans;
    // }


    // OPTIMISED
    public int leastInterval(char[] tasks, int n) {
        int freq[] = new int[26];

        for(int i=0;i<tasks.length;i++){
            freq[tasks[i]-'A']++;
        }

        int maxFreq = Integer.MIN_VALUE;
        for(int count:freq){
            maxFreq = Math.max(maxFreq,count);
        }

        int maxCount=0;
        for(int count:freq){
            if(count==maxFreq) maxCount++;
        }

        int skeleton =((maxFreq-1) * (n+1)) + maxCount;
        return Math.max(tasks.length,skeleton);
    }
}