import java.util.HashMap;
import java.util.Map;

public class WC436 {
     // public int[] assignElements(int[] groups, int[] elements) {
    //     int n=groups.length,m=elements.length,ind=0;
    //     int res[] = new int[n];
    //     for(int i=0;i<n;i++){
    //         boolean flag=false;
    //         for(int j=0;j<m;j++){
    //             if(groups[i]%elements[j]==0){
    //                 res[i]=j;
    //                 flag=true;
    //                 break;
    //             }
    //         }
    //         if(!flag){
    //             res[i]=-1;
    //         }
    //     } 
    //     return res;
    // }     


    public static int[] assignElements(int[] groups, int[] elements) {
        Map<Integer, Integer> elementIndexMap = new HashMap<>();
        for (int i = 0; i < elements.length; i++) {
            elementIndexMap.putIfAbsent(elements[i], i);
        }

        int[] result = new int[groups.length];
        for (int i = 0; i < groups.length; i++) {
            result[i] = findSmallestIndex(groups[i], elementIndexMap);
        }
        return result;
    }

    private static int findSmallestIndex(int groupSize, Map<Integer, Integer> elementIndexMap) {
        int minIndex = Integer.MAX_VALUE;
        for (int i = 1; i * i <= groupSize; i++) {
            if (groupSize % i == 0) {
                if (elementIndexMap.containsKey(i)) {
                    minIndex = Math.min(minIndex, elementIndexMap.get(i));
                }

                // divisors like (8)={1,2} varaku loop veltundi but after 2, 4 and 8 are also possible so by dividing 8/2 and 8/1 we get those numbers.
                if (elementIndexMap.containsKey(groupSize / i)) {
                    minIndex = Math.min(minIndex, elementIndexMap.get(groupSize / i));
                }
            }
        }
        return (minIndex == Integer.MAX_VALUE) ? -1 : minIndex;
    }
}