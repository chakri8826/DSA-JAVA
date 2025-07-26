import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class M1sortByFreq {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(Character c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        List<Character> li = new ArrayList<>(map.keySet());
        Collections.sort(li,(a,b)->map.get(b)-map.get(a));
        StringBuilder sb = new StringBuilder();
        // for(int i=0;i<li.size();i++){
        //     for(int j=0;j<map.get(li.get(i));j++){
        //         sb.append(li.get(i));
        //     }
        // }

        for(int i=0;i<li.size();i++){
            sb.append(String.valueOf(li.get(i)).repeat(map.get(li.get(i))));
        }
        return sb.toString();
    }
}