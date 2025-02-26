import java.util.HashMap;

public class S51LONG_SUB_EQ_0S_1S {
    public int maxLen(int[] arr) {
        int n=arr.length,psum=0,len=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            psum+=arr[i]==0?-1:1;
            if(psum==0) len=Math.max(len,i+1);
            if(map.containsKey(psum)){
                len=Math.max(len,i-map.get(psum));
            }
            if(!map.containsKey(psum)){
                map.put(psum,i);
            }
        }
        return len;
    }
    public static void main(String[] args) {
        S51LONG_SUB_EQ_0S_1S obj = new S51LONG_SUB_EQ_0S_1S();
        int[] arr = {0, 1, 0, 1, 1, 0, 0};
        System.out.println("Longest subarray length: " + obj.maxLen(arr)); // Output: 6
    }
    
}
