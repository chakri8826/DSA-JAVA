import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class M1NMeetingsOneRoom {
    public int maxMeetings(int start[], int end[]) {
         int n = start.length;
         List<int[]> li = new ArrayList<>();
         for(int i=0;i<n;i++){
             li.add(new int[]{start[i],end[i]});
         }
        //  Collections.sort(li,Comparator.comparingInt(c->c[1]));
        Collections.sort(li,(a,b)->a[1]-b[1]);
         int cnt = 1,prev=li.get(0)[1];
         for(int i=1;i<n;i++){
             if(li.get(i)[0]>prev){
                 cnt++;
                 prev=li.get(i)[1];
             }
         }
         return cnt;
    }
    public static void main(String[] args) {
        int start[] = {1,3,0,5,8,5};
        int end[] = {2,4,6,7,9,9};
        M1NMeetingsOneRoom obj = new M1NMeetingsOneRoom();
        System.out.println(obj.maxMeetings(start,end));
    }
}
