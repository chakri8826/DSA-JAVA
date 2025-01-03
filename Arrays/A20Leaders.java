import java.util.*;

public class A20Leaders {
     // static ArrayList<Integer> leaders(int arr[]) {
        // ArrayList<Integer> li = new ArrayList<>();
        // int n = arr.length;
        // for(int i=0;i<n;i++){
        //     int flag=0;
        //     for(int j=i+1;j<n;j++){
        //         if(arr[j]>arr[i]){
        //             flag=1;
        //             break;
        //         }
        //     }
        //     if(flag==0){
        //         li.add(arr[i]);
        //     }
        // }
        // return li;
    // }
    
    static ArrayList<Integer> leaders(int arr[]) {
        ArrayList<Integer> li = new ArrayList<>();
        int n = arr.length,maxi=-1;
        for(int i=n-1;i>=0;i--){
            if(arr[i]>=maxi){
                maxi=arr[i];
                li.add(maxi);
            }
        }
        
        ArrayList<Integer> re = new ArrayList<>();
        for(int i=li.size()-1;i>=0;i--){
            re.add(li.get(i));
        }
        return re;
    }
}
