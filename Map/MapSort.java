import java.util.*;
class MyCmp implements Comparator<Map.Entry<Integer,Integer>>{
    public int compare(Map.Entry<Integer,Integer> m1,Map.Entry<Integer,Integer> m2){
        if(m1.getValue()==m2.getValue()){
            return m1.getKey()-m2.getKey();
        }
            return  m2.getValue()-m1.getValue();
    }
}   
public class MapSort {
    public static void sort(int arr[],int n){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        ArrayList<Map.Entry<Integer,Integer>> freqList = new ArrayList<>(map.entrySet());
        Collections.sort(freqList,new MyCmp());
        int index=0;
        for(Map.Entry<Integer,Integer> e: freqList){
            for(int i=0;i<e.getValue();i++){
                arr[index++]=e.getKey();
            }
        }   
    }
    public static void main(String[] args) {
        int arr[] = {1,1,2,2,3,4,2,3};
        int n=arr.length;
        sort(arr, n);
        System.out.println(Arrays.toString(arr));

    }
}
