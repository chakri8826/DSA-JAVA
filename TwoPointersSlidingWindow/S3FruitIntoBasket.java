import java.util.HashMap;
public class S3FruitIntoBasket {
    public static int totalFruits(Integer[] arr) {
        int l=0;
        int r=0;
        int maxlen = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = arr.length;
        while(r<n){
            map.put(arr[r],map.getOrDefault(arr[r],0)+1);
            while(map.size()>2){  //LESS OPTI
            // if(map.size()>2){    //MORE OPTI
                map.put(arr[l],map.get(arr[l])-1);
                if(map.get(arr[l])==0){
                    map.remove(arr[l]);
                }
                l++;
            }
            maxlen=Math.max(maxlen,r-l+1);
            r++;
        }
        return maxlen;
    }
}

