import java.util.*;
public class W419 {
    public static void main(String[] args) {
        int arr[] = {1,1,2,2,3,4,2,3};
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<8;i++){
            map.put(arr[i],map.getOrDefault(arr[i], 0)+1);
        }
        System.out.println(map);
    }
}
