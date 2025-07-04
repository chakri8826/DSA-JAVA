import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class G19CourseShedule {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int v = prerequisites.length;
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int edge[]:prerequisites){
            int u = edge[0];
            int u2 = edge[1];
            adj.get(u2).add(u);
        }

        int inDeg[] = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            for(int it:adj.get(i)){
                inDeg[it]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
 
        for(int i=0;i<numCourses;i++){
            if(inDeg[i]==0){
                q.offer(i);
            }
        }

        int res[] = new int[numCourses];
        int ind=0;
        while(!q.isEmpty()){
            int top = q.poll();
            res[ind++]=top;
            for(int it:adj.get(top)){
                inDeg[it]--;
                if(inDeg[it]==0)q.offer(it);
            }
        }

        if(ind==numCourses)return res;
        return new int[0];
    }
}
