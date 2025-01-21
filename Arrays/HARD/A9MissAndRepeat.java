import java.util.ArrayList;
import java.util.HashMap;

public class A9MissAndRepeat {
    
    //OPTI-1
    // ArrayList<Integer> findTwoElement(int arr[]) {
    //     long n = arr.length;
    //     long sn = (n*(n+1))/2;
    //     long sn2 = (n*(n+1)*(2*n+1))/6; 
    //     long s1=0,s2=0;
    //     for(int num:arr){
    //         s1+=num;
    //         s2+=(long)num*(long)num;
    //     }
        
    //     long e1 = s1-sn;  //x-y
    //     long e2 = s2-sn2;
        
    //     long total = e2/e1;
        
    //     long rep = (total+e1)/2;
    //     long miss = total-rep;
        
    //     ArrayList<Integer> res = new ArrayList<>();
    //     res.add((int)rep);
    //     res.add((int)miss);
    //     return res;
    // }
    
    
    
    //OPTI-2
    static ArrayList<Integer> findTwoElement(int arr[]) {
        long n = arr.length,xor=0;
        for(int i=0;i<n;i++){
            xor^=arr[i];
            xor^=(i+1);
        }
        int bitNo = 0;
        while(true){
            if( (xor & (1<<bitNo))!=0){
                break;
            }
            bitNo++;
        }
        
        int zero=0,one=0;
        for(int i=0;i<n;i++){
            //ZERO CLUB
            if((arr[i] & (1<<bitNo))==0){
                zero ^= arr[i];
            }
            //ONE CLUB
            else{
                one ^= arr[i];
            }
        }
        for(int i=1;i<=n;i++){
            //ZERO CLUB
            if((i & (1<<bitNo))==0){
                zero ^= i;
            }
            //ONE CLUB
            else{
                one ^= i;
            }
        }
        int cnt = 0;
        for(int i=0;i<n;i++){
            if(arr[i]==zero){
                cnt++;
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        if(cnt==2){
            res.add(zero);
            res.add(one);
        }
        else{
            res.add(one);
            res.add(zero);
        }
        return res;
    }

    
    // FURTHER optimizing OPTI-2
    // ArrayList<Integer> findTwoElement(int arr[]) {
    //     int n = arr.length;
    //     int xor=0;
    //     for(int i=0;i<n;i++){
    //         xor^=arr[i];
    //         xor^=(i+1);
    //     }
    //     // int bitNo = 0;
    //     // while(true){
    //     //     if( (xor & (1<<bitNo))!=0){
    //     //         break;
    //     //     }
    //     //     bitNo++;
    //     // }
        
    //     int number = xor & ~(xor-1);  //That number with 1 at required bit position
    //     int zero=0,one=0;
    //     for(int i=0;i<n;i++){
    //         //ZERO CLUB
    //         if((arr[i] & number)==0){
    //             zero ^= arr[i];
    //         }
    //         //ONE CLUB
    //         else{
    //             one ^= arr[i];
    //         }
    //     }
    //     for(int i=1;i<=n;i++){
    //         //ZERO CLUB
    //         if((i & number)==0){
    //             zero ^= i;
    //         }
    //         //ONE CLUB
    //         else{
    //             one ^= i;
    //         }
    //     }
    //     int cnt = 0;
    //     for(int i=0;i<n;i++){
    //         if(arr[i]==zero){
    //             cnt++;
    //         }
    //     }
    //     ArrayList<Integer> res = new ArrayList<>();
    //     if(cnt==2){
    //         res.add(zero);
    //         res.add(one);
    //     }
    //     else{
    //         res.add(one);
    //         res.add(zero);
    //     }
    //     return res;
    // }
    public static void main(String[] args) {
        int arr[] = {1,3,3};
        System.out.println(findTwoElement(arr));
    }
}

