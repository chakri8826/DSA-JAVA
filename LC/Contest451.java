class Contest451{
    // 1
    public long minCuttingCost(int n, int m, int k) {
        if (n <= k && m <= k) return 0;

         long cost = Long.MAX_VALUE;
        // In the multiplication it can go out of int range so use long range only so that they will fit in this.
        if(n>k){
            for(int i=1;i<n;i++){
                if(i<=k && (n-i)<=k){
                    cost = Math.min(cost,(long)i*(n-i));
                }
            }
        }
        else{
            for(int i=1;i<m;i++){
                if(i<=k && (m-i)<=k){
                    cost = Math.min(cost,(long)i*(m-i));
                }
            }
        }
        return cost;
    }

    // 2
    public String resultingString(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && isConsecutive(stack.peek(), c)) {
                stack.pop(); // Remove the pair
            } else {
                stack.push(c);
            }
        }

        // Build the result string from the stack
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.removeLast()); // reverse order
        }

        return result.toString();
    }

    private boolean isConsecutive(char a, char b) {
        int diff = Math.abs(a - b);
        return diff == 1 || diff == 25;
    }
}