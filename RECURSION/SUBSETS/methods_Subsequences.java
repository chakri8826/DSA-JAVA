import java.util.*;
public class methods_Subsequences {

    //PRINTING ALL SUBSEQUENCES WITH GIVEN SUM
    static void countSubsets(int ind,List<Integer> li,int s,int arr[],int sum){
        if(s==sum){
            System.out.print("Sub Sequence List:");
            for(int it:li){
                System.out.print(it+" ");
            }
            return;
        }
        if(ind==arr.length){
                return;
        }
        li.add(arr[ind]);       
        s+=arr[ind];
        countSubsets(ind+1,li,s,arr,sum);
        li.remove(Integer.valueOf(arr[ind]));
        s-=arr[ind];
        countSubsets(ind+1,li,s,arr,sum);
    }

    //PRINTING ONLY ONE ANSWER 
    // static boolean countSubsets(int ind,List<Integer> li,int s,int arr[],int sum){
    //     if(s>sum){
    //         return false;
    //     }
    //     if(ind==arr.length){
    //         if(s==sum){
    //             for(int it:li){
    //                 System.out.print(it+" ");
    //             }
    //             return true;
    //             // System.out.println(li.size());
    //         }
    //         else return false;
    //     }
    //     li.add(arr[ind]);
    //     s+=arr[ind];
    //     if(countSubsets(ind+1,li,s,arr,sum)==true){
    //         return true;
    //     }
    //     li.remove(Integer.valueOf(arr[ind]));
    //     s-=arr[ind];
    //     if(countSubsets(ind+1,li,s,arr,sum)==true){
    //         return true;
    //     }
    //     return false;
    // }


    //COUNTING THE NUMBER OF SUBSETS WHICH IS EQUAL TO THE GIVEN SUM
    // static int countSubsets(int ind ,int s,int arr[],int sum){
    //     if(ind==arr.length){
    //         if(s==sum){
    //             return 1;
    //         }
    //         else{
    //             return 0;
    //         }
    //     }
    //     s+=arr[ind];
    //     int l = countSubsets(ind+1,s,arr,sum);

    //     s-=arr[ind];
    //     int r = countSubsets(ind+1,s,arr,sum); 
    //     return l+r;
    // }

    public static void main(String[] args){
        int arr[]={2,3,5};
        List<Integer> li = new ArrayList<>();
       countSubsets(0,li,0,arr, 8);

    }   
}











