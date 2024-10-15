import java.util.*;
class Mycmp implements Comparator<int[]>{
    public int compare(int m1[],int m2[]){
        if(m1[1]==m2[1]){
            return m2[0]-m1[0];
        }
        else{
            return m2[1]-m1[1];
        }
    }
}
public class W419 {
    public static int[] sub(int[] nums, int i,int k){
        int sa[] = new int[k];
        for(int j=0;j<k;j++){
            sa[j]= nums[i+j];
        }
        return sa;
    }
    public static int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int ans[] = new int[n-k+1];
        for(int i=0;i<n-k+1;i++){
            int sa[] = sub(nums,i,k);
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int j=0;j<k;j++){
                map.put(sa[j],map.getOrDefault(sa[j], 0)+1);
            }
            List<int[]> freqList = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                freqList.add(new int[]{entry.getKey(), entry.getValue()});
            }
            // Collections.sort(freqList, (a, b) -> {
            //     if (b[1] == a[1]) {
            //         return b[0] - a[0]; // Sort by value descending
            //     }
            //     return b[1] - a[1]; // Sort by frequency descending
            // });
            Collections.sort(freqList,new Mycmp());
            int sum=0,l=0;
            for (int[] pair : freqList) {
                if(l>=x) break;
                sum+=pair[0]*pair[1];
                l++;
            }
            ans[i] = sum;
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {1,1,2,2,3,4,2,3};
        int k = 6,x=2;
        int [] res  = findXSum(arr, k, x);
        for(int i = 0 ;i<res.length;i++){
            System.out.println(res[i]);
        }
        
    }
}
