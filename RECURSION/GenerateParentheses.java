import java.util.*;
public class GenerateParentheses {
    public static List<String> genp(int n, int open, int close, String current, List<String> result) {
        if (open == n && close == n) {
            result.add(current);
        }
        if (open < n) {
            genp(n, open + 1, close, current + "(", result);
        }
        if (close < n && open>close) {
            genp(n, open, close + 1, current + ")", result);
        }
        return result;
    }
    public static void main(String[] args) {
        int n = 3;
        int open = 0;
        int close = 0;
        String current = "";
        List<String> result = new ArrayList<>();
        List<String> res = genp(n, open, close, current, result);
        System.out.println(res);
    }
}

