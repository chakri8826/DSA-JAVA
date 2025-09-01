public class M5Atoi {
    public int myAtoi(String s) {
        int i=0;
        while (i < s.length() && s.charAt(i) == ' ') i++;
        if(s.length()==0)return 0;
        int sign=1;
        long result=0;

        if(i<s.length() && (s.charAt(i)=='-' || s.charAt(i)=='+')){
            if(s.charAt(i)=='-'){
                sign=-1;
            }
            i++;
        }
        
        while(i<s.length() && Character.isDigit(s.charAt(i))){
            int dig=s.charAt(i)-'0';
            result = result*10+dig;
            if(result*sign<=Integer.MIN_VALUE)return Integer.MIN_VALUE;
            if(result*sign>=Integer.MAX_VALUE)return Integer.MAX_VALUE;
            i++;
        }
        
        return (int)(sign * result);
    }
}
    