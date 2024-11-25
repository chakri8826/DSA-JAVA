class S1MaxPoints {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        if(k==n){
            int s=0;
            for(int i=0;i<n;i++){
                s+=cardPoints[i];
            }
            return s;
        }
        int Maxsum=0,lsum=0,rsum=0,l=k-1,r=n-1;
        for(int i=0;i<k;i++){
            lsum+=cardPoints[i];
        }
        Maxsum=lsum;
        while(lsum!=0){
            lsum=lsum-cardPoints[l];
            rsum=rsum+cardPoints[r];
            int sum=lsum+rsum;
            Maxsum=Math.max(Maxsum,sum);
            l--;
            r--;
        }
        return Maxsum;
    }

 
//     public int maxScore(int[] cardPoints, int k) {
//         int lsum,rsum,l,r;
//         lsum=rsum=0;
//         l=k-1;
//         r=cardPoints.length-1;
//         int maxsum=0;
//         for(int i=0;i<k;i++){
//             maxsum+=cardPoints[i];
//         }
//         int res=maxsum;
//         while(l>=0){
//             maxsum-=cardPoints[l];
//             maxsum+=cardPoints[r];
//             res=Math.max(maxsum,res);
//             l--;
//             r--;
//         }  
//         return res;      
//     }
        public static void main(String[] args) {
            int arr[] = {1,2,3,4,5,6,7,8,9,10};

        }
 

 
}