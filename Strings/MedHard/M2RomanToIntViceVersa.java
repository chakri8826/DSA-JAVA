import java.util.HashMap;

public class M2RomanToIntViceVersa {
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int romanToInt(String s) {
        HashMap<Character, Integer> value = new HashMap<>();
        value.put('I', 1);
        value.put('V', 5);
        value.put('X', 10);
        value.put('L', 50);
        value.put('C', 100);
        value.put('D', 500);
        value.put('M', 1000);

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int currVal = value.get(s.charAt(i));
            int nextVal = (i + 1 < s.length()) ? value.get(s.charAt(i + 1)) : 0;
            if (currVal < nextVal) {
                res -= currVal;
            } else {
                res += currVal;
            }
        }
        return res;
    }

    // Time Complexity: O(1)
    // Space Complexity: O(1)
    public String intToRoman(int num) { 
        int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

        int val = num;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (val >= values[i]) {
                val -= values[i];
                sb.append(symbols[i]);
            }
        }

        return sb.toString();
    }
}