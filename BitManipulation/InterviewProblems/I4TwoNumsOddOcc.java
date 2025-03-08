public class I4TwoNumsOddOcc {
    public int[] twoOddNum(int Arr[], int N)
    {
        int xor=Arr[0];
        for(int i=1;i<N;i++){
            xor^=Arr[i];
        }
        int bitNo=0;
        while((xor&(1<<bitNo))==0){
            bitNo++;
        }
        int zero=0,one=0;
        for(int i=0;i<N;i++){
            if((Arr[i]&(1<<bitNo))==0) zero^=Arr[i];
            else one^=Arr[i];
        }
        if(zero>one) return new int[]{zero,one};
        return new int[]{one,zero};
    }
    
    
    //  public int[] twoOddNum(int Arr[], int N)
    // {
    //     int xor=Arr[0];
    //     for(int i=1;i<N;i++){
    //         xor^=Arr[i];
    //     }
 
    //     int bitNo = (xor & (~(xor - 1)));
    //     int zero=0,one=0;
    //     for(int i=0;i<N;i++){
    //         if((Arr[i]&bitNo)==0) zero^=Arr[i];
    //         else one^=Arr[i];
    //     }
    //     return new int[]{Math.max(zero, one), Math.min(zero, one)};
    // }


}
