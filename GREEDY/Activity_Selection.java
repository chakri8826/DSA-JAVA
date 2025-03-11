import java.util.*;
class Mycmp implements Comparator<Activity>{
    public int compare(Activity a1,Activity a2){
        return a1.finish-a2.finish;
    }
}
class Activity{
    int start;
    int finish;
    Activity(int s,int f){
        start=s;
        finish=f;
    }
    static int maxActivity(Activity arr[]){
        Arrays.sort(arr,new Mycmp());
        int res=1;
        int prev=0;
        for(int curr=1;curr<arr.length;curr++){
            if(arr[curr].start>=arr[prev].finish){
                res++;
                prev=curr;
            }
        }
        return res;
    }
}

 class Activity_Selection {

    // WITHOUT ANY CLASS DIRECTLY WE ARE TAKING IN List<int[]> AND RETURNING THE COUNT
      public int activitySelection(List<Integer> start, List<Integer> end) {
        int n = start.size();
        List<int[]> li = new ArrayList<>();
        for(int i=0;i<n;i++){
            li.add(new int[]{start.get(i),end.get(i)});
        }
        Collections.sort(li,Comparator.comparingInt(a->a[1]));
        int cnt = 1;
        int prev = li.get(0)[1];
        for(int i=1;i<n;i++){
            if(li.get(i)[0]>prev){
                prev=li.get(i)[1];
                cnt++;
            }
        }
        return cnt;
    }
    
    public static void main(String[] args) {
        // Activity arr[] = {new Activity(12,25),
        //                   new Activity(10,20 ),
        //                   new Activity(20,30)
        //                  };
        // System.out.println(Activity.maxActivity(arr));
        
         //TAKING INPUT FROM USER
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of Activites: ");
        int n = sc.nextInt();

        Activity arr[] = new  Activity[n];
        for(int i=0;i<n;i++){
            System.out.print("Enter the start value: ");
            int s = sc.nextInt();
            System.out.print("Enter the finsih value: ");
            int f = sc.nextInt();
            arr[i]=new Activity(s,f);
        }
        System.out.println(Activity.maxActivity(arr));
    }







  


}
