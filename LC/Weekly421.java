class Weekly421{
    //first problem
    public int gcd(int a,int b){
        if(b==0)return a;
        return gcd(b,a%b);
    }
    public int lcm(int a, int b){
        return (a*b)/(gcd(a,b));
    }
    public int lcmAll(int[] nums){
        int res = nums[0];
        for(int i=1;i<nums.length;i++){
            res = lcm(res,nums[i]);
        }
        return res;
    }
    public int gcdAll(int[] nums){
        int res = nums[0];
        for(int i=1;i<nums.length;i++){
            res = gcd(res,nums[i]);
        }
        return res;
    }
    public int[] getSub(int[] nums, int ind){
        int[] res = new int[nums.length-1];
        for(int i=0;i<ind;i++){
            res[i] = nums[i];
        }
        for(int i=ind;i<nums.length;i++){
            if(i+1<nums.length){
                res[i] = nums[i+1];
            }
        }
        return res;
    }
    public long calculate(int sa[]){
        int l = lcmAll(sa);
        int g = gcdAll(sa);
        int maxVal = l*g;
        return maxVal;
    }
    public long maxScore(int[] nums) {
        if(nums.length==1) return nums[0]*nums[0];
        long maxVal = 0;
        int l = lcmAll(nums);
        int g = gcdAll(nums);
        maxVal = l*g;
        for(int i=0;i<nums.length;i++){
            int sa[] = getSub(nums,i);
            long cal = calculate(sa);
            maxVal = Math.max(maxVal,cal);
        }
        return maxVal;
    }



    public static final int MOD = 1_000_000_007;
    //Second Problem
    public int lengthAfterTransformations(String s, int t) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < t; i++) {
            StringBuilder newSb = new StringBuilder();
            for (int j = 0; j < sb.length(); j++) {
                char c = sb.charAt(j);
                if (c == 'z') {
                    newSb.append("ab"); 
                } else {
                    newSb.append((char) (c + 1));  
                }
            }
            sb = newSb;  
        }
        return sb.length()%MOD;  
    }

    public static void main(String[] args) {
        
    }
}