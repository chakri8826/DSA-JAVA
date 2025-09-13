import java.util.*;
public class H8NearlySorted {
    public static void nearlySorted(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int ind=0;
        for(int num:arr){
            pq.add(num);
            if(pq.size()>k+1){
                arr[ind++]=pq.poll();
            }
        }
        while(!pq.isEmpty()){
           arr[ind++]=pq.poll();
        }
    }
    public static void main(String[] args) {
        int arr[] = {6, 5, 3, 2, 8, 10, 9};
        int k=3;
        nearlySorted(arr, k);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }   
}
