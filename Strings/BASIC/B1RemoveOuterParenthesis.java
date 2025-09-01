public class B1RemoveOuterParenthesis {
    // BRUTE FORCE
    // public String removeOuterParentheses(String s) {
    //     StringBuilder result = new StringBuilder();
    //     int open = 0, start = 0;
    
    //     for (int i = 0; i < s.length(); i++) {
    //         char ch = s.charAt(i);
    //         if (ch == '(') open++;
    //         else open--;
    
    //         if (open == 0) {
    //             result.append(s.substring(start + 1, i));
    //             start = i + 1;
    //         }
    //     }    
    
    //     return result.toString();
    // }
    

    // OPTIMIZED
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int cnt=0;
        for(char ch:s.toCharArray()){
            if(ch=='('){
                if(cnt>0){
                    sb.append(ch);
                }
                cnt++;
            }
            else{
                cnt--;
                if(cnt>0){
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }
}