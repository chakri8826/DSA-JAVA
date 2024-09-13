import java.util.*;
public class CombinationsSums2 {
    public List<List<Integer>> ans = new ArrayList<>();
    //LESS EFFICIENT APPROACH
    // public void cal(int i,int s,List<Integer> templi,int[] cand,int tar){
    //     if(s==tar){
    //         ans.add(new ArrayList<>(templi));
    //         return;
    //     }
    //     if(i>=cand.length){
    //         return;
    //     }
    //     templi.add(cand[i]);
    //     s+=cand[i];
    //     cal(i+1,s,templi,cand,tar);
    //     templi.remove(templi.size()-1);
    //     s-=cand[i];
    //     while (i + 1 < cand.length && cand[i] == cand[i + 1]) {
    //         i++;
    //     }
    //     cal(i+1,s,templi,cand,tar);
    // }
    public void cal(int i,int s,List<Integer> templi,int[] cand,int tar){
        if(s==tar){
            ans.add(new ArrayList<>(templi));
            return;
        }
        if(i>=cand.length){
            return;
        }
        for(int j=i;j<cand.length;j++){
            if(j>i && cand[j]==cand[j-1]){
                continue;
            }
            templi.add(cand[j]);
            cal(j+1,s+cand[j],templi,cand,tar);
            templi.remove(templi.size()-1);
        }
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans=new ArrayList<>();
        Arrays.sort(candidates);
        cal(0,0,new ArrayList<>(),candidates,target);
        return ans;
    }
    public static void main(String[] args) {
        int arr[] ={2,5,2,1,2};
        CombinationsSums2 cs = new CombinationsSums2();
        System.out.println(cs.combinationSum2(arr, 5));
    }
}




