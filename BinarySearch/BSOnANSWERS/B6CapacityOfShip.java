import java.util.Arrays;
import java.util.Scanner;

public class B6CapacityOfShip {
    public int findMaxWt(int[] weights, int d, int cap){
        int loadDay=0,totalLoad=0,days=1;
        for(int i=0;i<weights.length;i++){
            loadDay+=weights[i];
            if(loadDay>cap){
                days++;
                loadDay=weights[i];
            }
            totalLoad+=weights[i];
            if(days==d)break;
        }
        return totalLoad;
    }

    public static void main(String[] args) {
        
        // Compute the total weight that can be shipped
        int weights[] = {1,2,3,4,5,6,7,8,9,10};
        int d = 5;
        int cap=15;
        B6CapacityOfShip obj = new B6CapacityOfShip();
        int result = obj.findMaxWt(weights, d, cap);
        System.out.println(result);
    }

}
