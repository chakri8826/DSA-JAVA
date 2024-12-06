import java.util.*;
class S3MinCostRopes{
    public static int minCost(int[] arr) {
        PriorityQueue<Integer> mh = new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            mh.add(arr[i]);
        }
        int sum=0;
        while(mh.size()>1){
            int first = mh.poll();
            int second = mh.poll();
            int cost = first+second;
            sum+=cost;
            mh.add(cost);
        }
        return sum;
    }
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            System.out.print("Enter the element "+(i+1)+": " );
            arr[i] = sc.nextInt();
        }
        System.out.println(minCost(arr));
    }
}

