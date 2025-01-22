public class A1SecondLargest {
    //BETTER
    // public int getSecondLargest(int[] arr) {
    //     int n = arr.length;
    //     int lar=arr[0];
    //     for(int i=1;i<n;i++){
    //         if(arr[i]>lar){
    //             lar=arr[i];
    //         }
    //     }
    //     int slar=-1;
    //     for(int i=0;i<n;i++){
    //         if(arr[i]>slar && arr[i]!=lar){
    //             slar=arr[i];
    //         }
    //     }
    //     return slar;
    // }
    
    
    //OPTIMAL
    public int getSecondLargest(int[] arr) {
        int lar = arr[0],slar = -1;
        int n = arr.length;
        for(int i=1;i<n;i++){
            if(arr[i]>lar){
                slar=lar;
                lar=arr[i];
            }
            else if(arr[i]!=lar && arr[i]>slar){
                slar = arr[i];
            }
        }
        return slar;
    }
}
