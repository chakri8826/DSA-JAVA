package PrefixSuffixArrays;

public class MaxNoOfSubSeqs {
    //LEETCODE-> WEEKLY CONTEST 450, 2ND QUESTION 
    public long numOfSubsequences(String s) {
        int n=s.length();
        long pL[] = new long[n+1];
        long sT[] = new long[n+1];
        long pLC[] = new long[n+1];
        long sCT[] = new long[n+1];

        for(int i=0;i<n;i++){
            pL[i+1]=pL[i] + (s.charAt(i)=='L'?1:0);
        }

        for(int i=n-1;i>=0;i--){
            sT[i]=sT[i+1] + (s.charAt(i)=='T'?1:0);
        }

        long base=0,Lcnt=0;
        for(int i=0;i<n;i++){
            pLC[i+1]=pLC[i];
            if(s.charAt(i)=='C'){
                pLC[i+1]+=Lcnt;
                base+=(Lcnt*sT[i+1]);
            }
            else if(s.charAt(i)=='L'){
                Lcnt++;
            }
        }

        long Tcnt=0;
        for(int i=n-1;i>=0;i--){
            sCT[i]=sCT[i+1];
            if(s.charAt(i)=='C'){
                sCT[i]+=Tcnt;
            }
            else if(s.charAt(i)=='T'){
                Tcnt++;
            }
        }

        long best=0;
        for(int i=0;i<=n;i++){
            best = Math.max(best,sCT[i]);
            best = Math.max(best,pL[i]*sT[i]);
            best = Math.max(best,pLC[i]);
        }
        return base+best;
    }
}
