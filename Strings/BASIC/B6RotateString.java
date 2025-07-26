public class B6RotateString {
    // public boolean rotateString(String s, String goal) {
    //     if (s.length() != goal.length()) return false;
    //     String main = s + s;
    //     for (int i = 0; i <= main.length() - goal.length(); i++) {
    //         String str = main.substring(i, i + goal.length());
    //         if (str.equals(goal)) return true;
    //     }

    //     return false;
    // }

    public boolean rotateString(String s, String goal) {
        return s.length()==goal.length() && (s+s).contains(goal);
    }
}
