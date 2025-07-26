public class B4LongestCommonPrefix {
    // public String longestCommonPrefix(String[] strs) {
    //     int ind=0;
    //     StringBuilder sb = new StringBuilder();

    //     int minLen=Integer.MAX_VALUE;
    //     String str = "";
    //     for(String word:strs){
    //         if(word.length()<minLen){
    //             str=word;
    //             minLen=word.length();
    //         }
    //     }
    //     for(int i=0;i<minLen;i++){
    //         for(int j=0;j<strs.length;j++){
    //             if(str.charAt(i)!=strs[j].charAt(i))return sb.toString();
    //         }
    //         sb.append(str.charAt(i));
    //     }
    //     return sb.toString();
    // }

    
    // optimized solution
    public String longestCommonPrefix(String[] strs) {
        int ind=0;
        String str=strs[0];
        while(true){
            for(int j=0;j<strs.length;j++){
                if(ind==strs[j].length())return str.substring(0,ind);
                if(str.charAt(ind)!=strs[j].charAt(ind))return str.substring(0,ind);
            }
            ind++;
        }
    }
}
