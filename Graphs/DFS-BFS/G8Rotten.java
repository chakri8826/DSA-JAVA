import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int first, second;
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class G8Rotten {
    int dx[] = {-1, 0, 1, 0};
    int dy[] = {0, 1, 0, -1};

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int fresh = 0, cnt = 0;

        boolean[][] vis = new boolean[n][m]; // ✅ visitation tracker
        Queue<Pair> q = new LinkedList<>();

        // Add all initially rotten oranges to queue, mark them visited
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Pair(i, j));
                    vis[i][j] = true;
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();
            boolean rotted = false;

            for (int i = 0; i < size; i++) {
                Pair p = q.poll();
                int f = p.first;
                int s = p.second;

                for (int j = 0; j < 4; j++) {
                    int ni = f + dx[j];
                    int nj = s + dy[j];

                    if (ni >= 0 && nj >= 0 && ni < n && nj < m
                            && grid[ni][nj] == 1 && !vis[ni][nj]) {
                        q.offer(new Pair(ni, nj));
                        vis[ni][nj] = true; // ✅ mark as rotten
                        fresh--;
                        rotted = true;
                    }
                }
            }

            if (rotted) cnt++;
        }

        return fresh == 0 ? cnt : -1;
    }
}
