public class RotateStr {
    public boolean rotateString(String s, String goal) {
        int n = s.length();
        char arr[] = s.toCharArray();
        for(int i=0;i<n;i++){
            char c = arr[0];
            for(int j=1;j<n;j++){
                arr[j-1]=arr[j];
            }
            arr[n-1]=c;
            String newStr = new String(arr);
            System.out.println(newStr);
            if(newStr.equals(goal))return true;
        }
        return false;
    }
    public static void main(String[] args) {
        RotateStr rs = new RotateStr();
        System.out.println(rs.rotateString("abcde", "cdeab"));
    }
}
