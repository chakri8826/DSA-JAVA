import java.util.ArrayList;
import java.util.HashMap;

public class S51Ind_First_SubArr_Sum {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        int psum=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> li = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            psum+=arr[i];
            if(psum==target){
                li.add(1);
                li.add(i+1);
                return li;
            }
            if(map.containsKey(psum-target)){
                li.add(map.get(psum-target)+2);
                li.add(i+1);
                return li;
            }
            if(!map.containsKey(psum)){
                map.put(psum,i);
            }
        }
        li.add(-1);
        return li;
    }
}
