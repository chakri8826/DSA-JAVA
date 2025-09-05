import java.util.*;
public class H2MinToMax {
    static void maxHeapify(int arr[],int n,int i){
        int left = (2*i)+1;
        int right = (2*i)+2;
        int lar=i;
        if(left<n && arr[left]>arr[lar]){
            lar=left;
        }
        if(right<n && arr[right]>arr[lar]){
            lar=right;
        }
        if(lar!=i){
            int temp = arr[i];
            arr[i] = arr[lar];
            arr[lar]=temp;
            maxHeapify(arr,n,lar);
        }
    }
    static void convertMinToMaxHeap(int N, int arr[]) {
        for(int i=((N/2)-1);i>=0;i--){
            maxHeapify(arr,N,i);
        }
    }
}
