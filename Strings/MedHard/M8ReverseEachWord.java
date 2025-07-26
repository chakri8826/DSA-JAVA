public class M8ReverseEachWord {
    public String reverse(String str){
        char[] arr = str.toCharArray();
        int i=0,j=arr.length-1;
        while(i<j){
            char temp =arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
        return new String(arr);
    }
    public String reverseWords(String s) {
        String[] words = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<words.length;i++){
            String rev = reverse(words[i]);
            sb.append(rev);
            if(i<words.length-1)sb.append(" ");
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        M8ReverseEachWord obj = new M8ReverseEachWord();
        String s = "Hello World";
        System.out.println(obj.reverseWords(s));
    }
}
