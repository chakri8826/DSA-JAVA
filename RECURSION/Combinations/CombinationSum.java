import java.util.*;
public class CombinationSum {
    List<List<Integer>> ans = new ArrayList<>();
    // public void cal(int i,int s,List<Integer> templi,int[] cand,int tar){
    //     if(s==tar){
    //         ans.add(new ArrayList<>(templi));
    //         return;
    //     }
    //     if(s>tar|| i==cand.length){
    //         return;
    //     }
    //     templi.add(cand[i]);
    //     s+=cand[i];
    //     cal(i,s,templi,cand,tar);
    //     templi.remove(templi.size()-1);
    //     s-=cand[i];
    //     cal(i+1,s,templi,cand,tar);
    // }
    public void cal(int i,int s,List<Integer> templi,int[] cand,int tar){
        if(s==tar){
            ans.add(new ArrayList<>(templi));
            return;
        }
        if(s>tar|| i==cand.length){
            return;
        }
        for(int j=i;j<cand.length;j++){
            templi.add(cand[j]);
            cal(j,s+cand[j],templi,cand,tar);
            templi.remove(templi.size()-1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        cal(0,0,new ArrayList<>(),candidates,target);
        return ans;
    }
    public static void main(String[] args) {
        int arr[] ={2,3,6,7};
        CombinationSum cs = new CombinationSum();
        System.out.println(cs.combinationSum(arr, 7));
    }
}
