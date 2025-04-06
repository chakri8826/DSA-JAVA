class G7Candy{
        // BRUTE
    // public int candy(int[] ratings) {
    //     int n = ratings.length;
    //     int le[] = new int[n];
    //     int re[] = new int[n];
    //     le[0]=1;
    //     re[n-1]=1;
    //     for(int i=1;i<n;i++){
    //         if(ratings[i]>ratings[i-1]){
    //             le[i]=le[i-1]+1;
    //         }
    //         else{
    //             le[i]=1;
    //         }
    //     }
    //     for(int i=n-2;i>=0;i--){
    //         if(ratings[i]>ratings[i+1]){
    //             re[i]=re[i+1]+1;
    //         }
    //         else{
    //             re[i]=1;
    //         }
    //     }
    //     int sum=0;
    //     for(int i=0;i<n;i++){
    //         sum+=Math.max(le[i],re[i]);
    //     }
    //     return sum;
    // }


    // BETTER
    // public int candy(int[] ratings) {
    //     int n = ratings.length;
    //     int le[] = new int[n];
    //     le[0]=1;
    //     for(int i=1;i<n;i++){
    //         if(ratings[i]>ratings[i-1]){
    //             le[i]=le[i-1]+1;
    //         }
    //         else{
    //             le[i]=1;
    //         }
    //     }
    //     int sum=0,rmax=1;
    //     for(int i=n-2;i>=0;i--){
    //         if(ratings[i]>ratings[i+1]){
    //             rmax=rmax+1;
    //         }
    //         else{
    //             rmax=1;
    //         }
    //         sum+=Math.max(le[i],rmax);
    //     }
    //     // LAST ELEMENT WAS 1 THAT IS NOT CHECKED
    //     sum += Math.max(le[n - 1], 1);
    //     return sum;
    // }
   


    public int candy(int[] ratings) {
        // sum is initialized with 1 as for the first child(i=0) we need to give at least 1 candy.(we start with i=1)
        int i=1,n=ratings.length,sum=1;
        while(i<n){
            if(ratings[i]==ratings[i-1]){
                sum+=1;
                i++;
                continue;
            }
            int peek=1;
            while(i<n && ratings[i]>ratings[i-1]){
                peek++;
                sum+=peek;
                i++;
            }
            int down=1;
            while(i<n && ratings[i]<ratings[i-1]){
                sum+=down;
                down++;
                i++;
            }
            if(down>peek){
                sum+= (down-peek);
            }
        }
        return sum;
    }  

    public static void main(String[] args) {
        G7Candy obj = new G7Candy();
        int ratings[] = {1,0,2};
        System.out.println(obj.candy(ratings));
    }
}