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
// class Item implements Comparable<Item>{
//     int wt;
//     int val;
//     public Item(int wt,int val){
//         this.wt=wt;
//         this.val=val;
//     }
//     public int compareTo(Item i){
//         return (i.val)*(this.wt)-(i.wt)*(this.val);
//     }

//     static double fracknapsack(Item arr[],int w){
//         Arrays.sort(arr);
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

//  class Fractional_Knapsack{
//        public static void main(String[] args){
//         Item arr[]={new Item(10,60),
//                           new Item(40,40 ),
//                           new Item(20,100),
//                           new Item(30,120)
//                     };
//         int w=50;
//         System.out.println(Item.fracknapsack(arr, w));
        
//     }
// }



class Item{
    int wt,val;
    public Item(int wt,int val){
        this.wt=wt;
        this.val=val;
    }
    double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {
        double res = 0.0;
        List<Item> li = new ArrayList<>();
        for(int i=0;i<val.size();i++){
            li.add(new Item(wt.get(i),val.get(i)));
        }   
        Collections.sort(li,(a,b)-> b.val*a.wt - a.val*b.wt);
        //  Collections.sort(li, (a, b) -> Double.compare((double) b.val / b.wt, (double) a.val / a.wt));
        for(int i=0;i<li.size();i++){
            if(li.get(i).wt<=capacity){
                capacity-=li.get(i).wt;
                res+=li.get(i).val;
            }
            else{
                res=res+(double)(li.get(i).val/(double)li.get(i).wt)*capacity;
                break;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Item i = new Item(0,0);
        List<Integer> val = new ArrayList<>();
        List<Integer> wt = new ArrayList<>();
        val.add(60);
        val.add(100);
        val.add(120);
        wt.add(10);
        wt.add(20);
        wt.add(30);
        System.out.println(i.fractionalKnapsack(val, wt, 50));
    }
}








