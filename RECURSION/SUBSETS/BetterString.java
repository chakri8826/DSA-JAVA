import java.util.*;
public class BetterString {
    public static void genAllSubStrings(StringBuilder templi,String str,int i, Set<String> res) {
        res.add(templi.toString());
        for(int j=i;j<str.length();j++){
            templi.append(str.charAt(j));
            genAllSubStrings(templi, str, j+1,res);
            templi.deleteCharAt(templi.length()-1);
        }
    }
    public static Set<String> SubSetsStr(String str){
        Set<String> res = new HashSet<>();
        genAllSubStrings(new StringBuilder(),str,0,res);
        return res;
    }
    public static void main(String[] args) {
        String str1 = "ggg";
        Set<String> first = SubSetsStr(str1);
        System.out.println(first);
        System.out.println(first.size());
        
        String str2 = "gfg";
        Set<String> second = SubSetsStr(str2);
        System.out.println(second);
        System.out.println(second.size());
    }
}
