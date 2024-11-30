public class PoliceThieves {
    static int catchThieves(char arr[], int n, int k) { 
        int[] P = new int[n];
        int[] T = new int[n];
        int j=0,l=0,count=0;
        for(int i=0;i<n;i++){
            if(arr[i]=='P'){
                P[j++]=i;
            }
            else{
                T[l++]=i;
            }
        }
        int pind=0,tind=0;
        while(pind<j && tind<l){
            if(Math.abs(P[pind]-T[tind])<=k){
                count++;
                pind++;
                tind++;
            }
            else if(T[tind]<P[pind]-k){
                tind++;
            }
            else if(T[tind]>P[pind]+k){
                pind++;
            }
        }
        return count;
	} 
    public static void main(String[] args) {
        char[] arr = {'P', 'T', 'T', 'P', 'T'};
        System.out.println(catchThieves(arr, 5, 1));
    }
	
} 

