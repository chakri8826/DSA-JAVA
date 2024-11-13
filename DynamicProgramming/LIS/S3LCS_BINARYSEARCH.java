import java.util.ArrayList;
import java.util.Collections;

public class S3LCS_BINARYSEARCH {
    static int longestSubsequence(int arr[]) {
        ArrayList<Integer> li = new ArrayList<>();
        int len=1;
        li.add(arr[0]);
        for(int i=1;i<arr.length;i++){
            if(arr[i]>li.get(li.size()-1)){
                li.add(arr[i]);
                len++;
            }
            else{
                int ind = Collections.binarySearch(li,arr[i]);
                if(ind<0){
                    ind = -ind-1;
                }
                li.set(ind,arr[i]);
            }
        }
        return len;
    }
}

