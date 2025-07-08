package ShortestPath;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int steps, num;

    public Pair(int steps, int num) {
        this.steps = steps;
        this.num = num;
    }
}
public class S8MinMultiplications {
    int minimumMultiplications(int[] arr, int start, int end) {
        if (start == end) return 0;

        int[] dist = new int[100000];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, start));

        int mod = 100000;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int steps = p.steps;
            int num = p.num;

            for (int i = 0; i < arr.length; i++) {
                int newNum = (num * arr[i]) % mod;

                if (newNum == end) return steps + 1;

                if (steps + 1 < dist[newNum]) {
                    dist[newNum] = steps + 1;
                    q.offer(new Pair(steps + 1, newNum));
                }
            }
        }

        return -1;
    }
}
