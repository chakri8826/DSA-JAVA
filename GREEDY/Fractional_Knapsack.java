import java.util.*;

//USING COMPARATOR
// class Mycmp implements Comparator<Item>{
//          public int compare(Item a,Item b){
//                 return (b.val)*(a.wt)-(a.val)*(b.wt);
//             }
// }
// class Item {
//         int wt;
//         int val;
//         public Item(int wt,int val){
//             this.wt=wt;
//             this.val=val;
//         }

//     static double fracknapsack(Item arr[],int w){
//         Arrays.sort(arr,new Mycmp());
//         double res=0.0;
//         for(int i=0;i<arr.length;i++){
//             if(arr[i].wt<=w){
//                 res=res+arr[i].val;
//                 w=w-arr[i].wt;
//             }
//             else{
//                 res=res+arr[i].val*((double)w/(double)arr[i].wt);
//                 break;
//             }
//         }
//         return res;

//     }   
// }

// USING COMPARABLE
class Item implements Comparable<Item>{
    int wt;
    int val;
    public Item(int wt,int val){
        this.wt=wt;
        this.val=val;
    }
    public int compareTo(Item i){
        return (i.val)*(this.wt)-(i.wt)*(this.val);
    }

    static double fracknapsack(Item arr[],int w){
        Arrays.sort(arr);
        double res=0.0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].wt<=w){
                res=res+arr[i].val;
                w=w-arr[i].wt;
            }
            else{
                res=res+arr[i].val*((double)w/(double)arr[i].wt);
                break;
            }
        }
        return res;
    }
} 
 class Fractional_Knapsack{
       public static void main(String[] args){
        Item arr[]={new Item(10,60),
                          new Item(40,40 ),
                          new Item(20,100),
                          new Item(30,120)
                    };
        int w=50;
        System.out.println(Item.fracknapsack(arr, w));
        
    }
}





