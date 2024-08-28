import java.util.*;
// public class GenerateAllBinarySubStrs{
//     public static void gen(int k,char arr[],int n){
//         if(n==k){
//             System.out.println(new String(arr));
//             return;
//         }
//         if(arr[n-1]=='1'){
//             arr[n]='0';
//             gen(k,arr,n+1);
//         }
//         if(arr[n-1]=='0'){
//             arr[n]='0';
//             gen(k,arr,n+1);
//             arr[n]='1';
//             gen(k,arr,n+1);
//         }
//     }
//     public static void  generateBinaryStrings(int k) {
//         char arr[] = new char[k];
//         for(int i=0;i<2;i++){
//             char ch = (char) (i+ '0');
//             arr[0]=ch;
//             int n=1;
//             // System.out.println(arr[0]);
//             gen(k,arr,n);
//         }
//     }
//     public static void main(String[] args) {
//         generateBinaryStrings(4);
//     }
// }


class GenerateAllBinarySubStrs {
    public static void gen(int n,char arr[],int k,List<String> li){
        if(n==k){
            li.add(new String(arr));
            return;
        }
        if(arr[k-1]=='1'){
            arr[k]='0';
            gen(n,arr,k+1,li);
        }
        if(arr[k-1]=='0'){
            arr[k]='0';
            gen(n,arr,k+1,li);
            arr[k]='1';
            gen(n,arr,k+1,li);
        }
    }
  public static List<String> generateBinaryStrings(int n){
        List<String> result = new ArrayList<>();
        char arr[] = new char[n];
        for(int i=0;i<2;i++){
            char ch = (char) (i+ '0');
            arr[0]=ch;
            int k=1;
            gen(n,arr,k,result);
        }        
        return result;  
  }
  public static void main(String[] args) {
        List<String> li =generateBinaryStrings(3);
        System.out.println(li);
    
  }
}




