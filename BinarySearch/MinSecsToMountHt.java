class MinSecsToMountHt{
    public static boolean canReduce(long mid, int mountainHeight, int[] workerTimes){
        long sh=0;
        for(int i=0;i<workerTimes.length;i++){
            long h = (long) ((-1+Math.sqrt(1+8.0 * mid/workerTimes[i]))/2);
            sh+=h;
            if(sh>=mountainHeight){
                return true;
            }
        }
        return sh>=mountainHeight;
    }
    public static long minNumberOfSeconds(int mountainHeight, int[] workerTimes){
        long low=Integer.MAX_VALUE;
        int maxx=Integer.MIN_VALUE;
        for(int wt:workerTimes){
            low=Math.min(low,wt);
            maxx=Math.max(maxx,wt);
        }
        long high =(long) (maxx*(mountainHeight * (mountainHeight+1L))/2);
        while(low<=high){
            long mid=low+(high-low)/2;
            if(canReduce(mid,mountainHeight,workerTimes)){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        int mountainHeight = 4;
        int[] workerTimes = {2,1,1};
        long res = minNumberOfSeconds(mountainHeight,workerTimes);
        System.out.println(res);
    }
}
