import java.util.*;
class contest412 {
	//FIRST PROBLEM
    // public static int[] getFinalState(int[] nums, int k, int multiplier) {
    //     int i=0;
    //     while(i<k){
    //         int min=0;
    //         for(int j=0;j<nums.length;j++){
    //             if(nums[j]<nums[min]){
    //                 min=j;
    //             }
    //         }
    //         nums[min]=nums[min]*multiplier;
    //         i++;
    //     }
    //     return nums;
    // }

	//SECOND PROBLEM
    public static String makeDigit(int num, int digits) {
        String numStr = Integer.toString(num);
        if (numStr.length() < digits) {
            numStr = "0".repeat(digits - numStr.length()) + numStr;
        }
        return numStr;
    }

    public static Set<String> makeSwapChanges(String num, int digits) {
        Set<String> possibleStrings = new HashSet<>();
        possibleStrings.add(num); // never swap // 1

        for (int i = 0; i < digits; i++) { // 7
            for (int j = i + 1; j < digits; j++) { // 7
                if (num.charAt(i) != num.charAt(j)) {
                    char[] numArray = num.toCharArray();
                    // swapping one time
                    char temp = numArray[i];
                    numArray[i] = numArray[j];
                    numArray[j] = temp;
                    possibleStrings.add(new String(numArray)); // 1

                    // swapping again to reverse the effects
                    numArray[j] = numArray[i];
                    numArray[i] = temp;
                }
            }
        } // 50
        return possibleStrings;
    }

    public static int countPairs(int[] nums) {
        int n = nums.length;
        int mx = 0;
        for (int it : nums) {
            mx = Math.max(it, mx);
        }

        int digits = Integer.toString(mx).length(); // highest limit
        List<String> arr = new ArrayList<>();
        for (int it : nums) { // n
            arr.add(makeDigit(it, digits));
        }
        int ans = 0;

        for (int i = 0; i < n; i++) { // n
            for (int j = i + 1; j < n; j++) { // n
                Set<String> possibleStrings = makeSwapChanges(arr.get(j), digits); // 50
                for(String s : possibleStrings) { // 20
                    if (s.equals(arr.get(i))) { // 6
                        ans++;
                    }
                }
            }
        } // (n*n*(100)) - 10^6 ~ O(10^6)
        return ans;


    // tc - O(10^6)
    // sc - O(20)
    }


    public static void main(String[] args) {
        // int nums[]={2,1,3,5,6};
        // int k=5;
        // int mul=2;
        // int res[]=getFinalState(nums,k,mul);
        // for(int i=0;i<res.length;i++){
        //     System.out.println(res[i]);
        // }

        // int nums[]={226726,387862,880512,611522,343461,420841,334461,10813,226726,334461,80113,314364,10813,163067,134364,332548,413463,343416,236429,164332,566432,226726,334164,343461,143463,163229,667555,667555,343461,657565,343461,770521,285866,930657,236429,502387,313446,334461,12219,163760,144363,227626};
        int nums[]={3,12,30,17,21};
        int res=countPairs(nums);
        System.out.println(res);
    }
}

