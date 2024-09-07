class Permutations{
	static void per(String s,int i){
        if(i==s.length()-1){
            System.out.println(s);
            return;
        }
        for(int j=i;j<s.length();j++){
             char[] charArray = s.toCharArray();
             char temp = charArray[i];
             charArray[i] = charArray[j];
             charArray[j] = temp;
             s = new String(charArray);

             per(s, i+1);

             char[] charArray1 = s.toCharArray();
             char temp1 = charArray1[i];
             charArray1[i] = charArray1[j];
             charArray1[j] = temp1;
             s = new String(charArray1);
        }
    }
    
     public static void main(String[] args){
        // per("()()()",0);
        String s="()";
        System.out.println(s.length());
    } 










}
