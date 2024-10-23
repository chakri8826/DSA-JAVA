import java.util.*;

class SplitString{
    public static int maxUniqueSplit(String s) {
        int max[]={0};
        HashSet<String> set = new HashSet<>();
        backtrack(set,0,s,s.length(),max);

        return max[0];
    }
    public static void backtrack(Set<String> set, int index,String str,int n, int max[]){
        if(index==n){
            max[0] = Math.max(max[0],set.size());
            return;
        }
        for(int i=index;i<n;i++){
            if(str.length()-(i+1)+set.size()<max[0]){
                break;
            }
            String sub = str.substring(index,i+1);
            if(!set.contains(sub)){
                set.add(sub);
                backtrack(set, i+1, str, n, max);
                set.remove(sub);
            }
        }
    }
    public static void main(String[] args) {
        String str = "ababccc";
        System.out.println(maxUniqueSplit(str));
    }   
}
