import java.util.*;
class A8UnionTwoSorted{
    // public static ArrayList<Integer> findUnion(int a[], int b[]) {
        //     HashSet<Integer> set = new HashSet<>();
        //     for (int num : a) {
        //         set.add(num);
        //     }
        //     for (int num : b) {
        //         set.add(num);
        //     }
        //     ArrayList<Integer> res = new ArrayList<>(set);
        //     Collections.sort(res); // Sort the ArrayList
        //     return res;
        // }
        
    public static ArrayList<Integer> findUnion(int a[], int b[]){
        int i=0,j=0,n=a.length,m=b.length;
        ArrayList<Integer> res = new ArrayList<>();
        while(i<n&&j<m){
        if(a[i]==b[j]){
            if (res.isEmpty() || res.get(res.size() - 1) != a[i]) {
                res.add(a[i]);
            }
            i++;
            j++;
        }
        else if(a[i]<b[j]){
            if (res.isEmpty() || res.get(res.size() - 1) != a[i]) {
                res.add(a[i]);
            }
            i++;
        }
        else{
            if (res.isEmpty() || res.get(res.size() - 1) != b[j]) {
                res.add(b[j]);
            }
            j++;
        }
        }
        while(i<n){
            if (res.isEmpty() || res.get(res.size() - 1) != a[i]) {
                res.add(a[i]);
            }
            i++;
        }
        while(j<m){
            if (res.isEmpty() || res.get(res.size() - 1) != b[j]) {
                res.add(b[j]);
            }
            j++;
        }
        return res;
    }
}