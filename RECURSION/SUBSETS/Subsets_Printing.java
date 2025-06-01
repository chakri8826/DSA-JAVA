import java.util.*;
public class Subsets_Printing {
    List<List<Integer>> ans = new ArrayList<>();
    static List<String> res = new ArrayList<>();
    //USING A FOR--LOOP
    // public void subs(List<Integer> tempList,int []nums,int start){
    //     ans.add(new ArrayList<>(tempList));
    //     for(int i = start; i < nums.length; i++){
    //         tempList.add(nums[i]);
    //         subs(tempList, nums, i + 1);
    //         tempList.remove(tempList.size() - 1);
    //     }        
    // }


    // public void subs(List<Integer> tempList,int []nums,int start){
    //     if(start==nums.length){
    //         ans.add(new ArrayList<>(tempList));
    //         return;
    //     }
    //     tempList.add(nums[start]);
    //     subs(tempList,nums,start+1);
    //     tempList.remove(tempList.size()-1);
    //     subs(tempList,nums,start+1);
    // }
    
    // public List<List<Integer>> subsets(int[] nums) {
    //     subs(new ArrayList<>(),nums,0);
    //     return ans;
    // }

    public static void genAllSubStrings(StringBuilder templi,String str,int i) {
        res.add(templi.toString());
        for(int j=i;j<str.length();j++){
            templi.append(str.charAt(j));
            genAllSubStrings(templi, str, j+1);
            templi.deleteCharAt(templi.length()-1);
        }
    }
    public static List<String> SubSetsStr(String str){
        genAllSubStrings(new StringBuilder(),str,0);
        return res;
    }

    public static void main(String[] args) {
        //FOR NUMBERS 
        // int nums[]={1,2,3};
        // Subsets_Printing s = new Subsets_Printing();
        // System.out.println(s.subsets(nums));

        //FOR STRING
        String str = "abc";
        System.out.println(SubSetsStr(str));


    }
}

















