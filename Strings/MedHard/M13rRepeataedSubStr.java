public class M13rRepeataedSubStr {
    public int repeatedStringMatch(String a, String b) {
        if(a.length()>=b.length() && a.contains(b))return 1;
        int repeats = b.length()/a.length();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<repeats+2;i++){
            sb.append(a);
            if(sb.toString().contains(b)) return i+1;
        }
        return -1;
    }
}