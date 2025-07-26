import java.util.HashMap;

public class M4DIstinctKSubStrs {
    public int calc(String s,int k){
        HashMap<Character,Integer>  map = new HashMap<>();
        int l=0,r=0,cnt=0;
        while(r<s.length()){
            map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)+1);
            while(map.size()>k){
                map.put(s.charAt(l),map.get(s.charAt(l))-1);
                if(map.get(s.charAt(l))==0){
                    map.remove(s.charAt(l));
                }
                l++;
            }
            cnt+=(r-l+1);
            r++;
        }
            return cnt;~
    }
    int countSubstr(String s, int k) {
        return calc(s,k)-calc(s,k-1);
    }
}