public class Contest138 {
    //FIRST PROBLEM
    public static int generateKey(int num1, int num2, int num3){
        String n1=Integer.toString(num1);
        String n2=Integer.toString(num2);
        String n3=Integer.toString(num3);
        if(n1.length()<4){
            n1="0".repeat(4-n1.length())+n1;
        }
        if(n2.length()<4){
            n2="0".repeat(4-n2.length())+n2;
        }
        if(n3.length()<4){
            n3="0".repeat(4-n3.length())+n3;
        }
        char[] res = new char[4];
        for(int i=0;i<4;i++){
            res[i]=(char)Math.min(Math.min(n1.charAt(i),n2.charAt(i)),n3.charAt(i));  
        }
        return Integer.parseInt(new String(res));
    }

    //SECOND PROBLEM
    public static char ind(String ss){
        int sum=0;
        for(int i=0;i<ss.length();i++){
            sum+=ss.charAt(i)-'a';
        }
        sum=sum%26;
        char r = (char) ('a'+sum);
        return r;
    }
    public static String stringHash(String s, int k){ 
        int n = s.length();
        int numSubstrings = n / k;  // Calculate the number of substrings
        char[] res = new char[numSubstrings];
        for (int i = 0, j = 0; i < n; i += k){ 
            String ss = s.substring(i,i+k);
            res[j++] = ind(ss);
        }
        return new String(res);
    }
 

   
    public static void main(String[] args) {
        // System.out.println(generateKey(987,879 ,798 ));
        System.out.println(stringHash("abcd",2));        

         

    }
}

