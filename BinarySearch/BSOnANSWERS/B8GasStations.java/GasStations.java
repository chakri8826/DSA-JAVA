public class GasStations {
       /*
        int a = 5;
        int b = 2;

        double result1 = a / b; // Integer division, result: 2 (not 2.5)
        double result2 = a / (b + 1.0); // Ensures floating-point division
        double result3 = a / (b + 1); // Still integer division

        System.out.println(result1); // Output: 2.0 (Wrong!)
        System.out.println(result2); // Output: 1.666... (Correct)
        System.out.println(result3); // Output: 2.0 (Wrong!)
    */

    // BRUTE FORCE
    // public static double findSmallestMaxDist(int stations[], int k) {
    //     int n = stations.length;
    //     int track[] = new int[n-1];
    //     while(k!=0){
    //         double maxi=0;
    //         int ind=-1;
    //         for(int i=1;i<n;i++){
    //             double dist = (stations[i]-stations[i-1])/(track[i-1]+1.0);
    //             if(dist>maxi){
    //                 maxi=dist;
    //                 ind = i-1;
    //             }
    //         }
    //         track[ind]++;
    //         k--;
    //     }
        
    //     double maxi=0.0;
    //     for(int i=1;i<n;i++){
    //         maxi = Math.max(((stations[i]-stations[i-1]) / (track[i-1] + 1.0)), maxi);
    //     }
    //     return maxi;
    // }


    // BETTER 
    // public static double findSmallestMaxDist(int stations[], int k) {
    //     int n = stations.length;
    //     int track[] = new int[n-1];
    //     // PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);  // Max-heap based on gas
    //     PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));  // Max-heap

    //     for(int i=1;i<n;i++){
    //         pq.add(new double[]{stations[i]-stations[i-1],i-1});
    //     }
    //     while(k!=0){
    //         double maxi[]=pq.poll();
    //         int ind = (int)maxi[1]; 
    //         track[ind]++;
    //         pq.add(new double[]{(stations[ind+1]-stations[ind])/(track[ind]+1.0), maxi[1]}); 
    //         k--;
    //     }
    //     return pq.poll()[0];
    // }
    

    // OPTIMIZED
    public static int noOfStations(int stations[], double dist){
        int cnt=0;
        for(int i=1;i<stations.length;i++){
            int numInBw =(int)((stations[i]-stations[i-1])/dist);
            // if(stations[i]-stations[i-1] == dist*numInBw)numInBw--;
            cnt+=numInBw;
        }
        return cnt;
    }
    
    public static double findSmallestMaxDist(int stations[], int k) {
        int n = stations.length;
        double maxi=0.0;
        for(int i=1;i<n;i++){
            maxi=Math.max(maxi,stations[i]-stations[i-1]);
        }
        double low=0,high=maxi,diff=1e-6;
        while(high-low>diff){
            double mid = low+(high-low)/2.0;
            int cnt = noOfStations(stations,mid);
            if(cnt>k)low=mid;
            else high=mid;
        }
        return high;
    }
    public static void main(String[] args) {
        int stations[] = {0, 2, 4, 8, 9};
        int k = 3;
        System.out.println(findSmallestMaxDist(stations, k));
    }
}
