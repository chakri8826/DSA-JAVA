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


class S4Fractional_Knapsack{
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of items: ");
        int n = sc.nextInt();

        Item[] arr = new Item[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter the weight and value for item " + (i + 1) + ": ");
            int wt = sc.nextInt();
            int val = sc.nextInt();
            arr[i] = new Item(wt, val);
        }

        System.out.print("Enter the maximum weight capacity of the knapsack: ");
        int w = sc.nextInt();

        double maxValue = Item.fracknapsack(arr, w);
        System.out.println("Maximum value that can be obtained: " + maxValue);

        sc.close();
    }

}

