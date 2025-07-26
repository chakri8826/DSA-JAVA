import java.util.HashMap;

public class M2RomanToInt {
    public int romanToInt(String s) {
        HashMap<Character,Integer> value = new HashMap<>();
        value.put('I',1);
        value.put('V',5);
        value.put('X',10);
        value.put('L',50);
        value.put('C',100);
        value.put('D',500);
        value.put('M',1000);

        int res=0;
        for(int i=0;i<s.length();i++){
            int currVal = value.get(s.charAt(i));
            int nextVal = (i+1<s.length()) ? value.get(s.charAt(i+1)) : 0;
            if(currVal<nextVal){
                res-=currVal;
            }
            else{
                res+=currVal;
            }
        }
        return res;
    }
}
