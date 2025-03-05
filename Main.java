import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        String code = """
            class Solution {
                static ArrayList<Integer> subarraySum(int[] arr, int target) {
                    ArrayList<Integer> res = new ArrayList<>();
                    int psum = 0;
                    HashMap<Integer, Integer> map = new HashMap<>();
                    for (int i = 0; i < arr.length; i++) {
                        psum += arr[i];
                        map.put(psum, i);
                        if (psum == target) {
                            res.add(1);
                            res.add(i + 1);
                            return res;
                        }
                        if (map.containsKey(psum - target)) {
                            res.add(map.get(psum - target) + 2);
                            res.add(i + 1);
                            return res;
                        }
                    }
                    res.add(-1);
                    return res;
                }
            }
        """;

        StringTokenizer tokenizer = new StringTokenizer(code, " \t\n\r\f{}[]();");
        // System.out.println("Number of tokens: " + tokenizer.countTokens());
        System.out.println(1%2 );
    }
}
