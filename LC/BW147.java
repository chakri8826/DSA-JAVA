public class BW147 {
    public static void main(String[] args) {
        String s ="jjj";
        String p ="*j";

        int ind = p.indexOf("*"); 

        // If ind = 0, p.substring(0, ind) will return an empty string (""), and s.indexOf("") will return 0 (Java treats an empty string as present at every position in s).
        int fp = s.indexOf(p.substring(0,ind));
        int sp = s.indexOf(p.substring(ind+1),fp+ind);
        System.out.println(ind);

    }
}

