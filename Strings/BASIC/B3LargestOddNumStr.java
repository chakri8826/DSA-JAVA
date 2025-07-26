class B3LargestOddNumStr {
    // ascii values of 0-9 are 48-57, asci values also have odd values for odd nums and even values for even nums
    // so we can use this to our advantage to find the largest odd number
    // public String largestOddNumber(String num) {
    //     int lastDig = num.charAt(num.length()-1);
    //     if(lastDig%2!=0)return num;        
    //     for(int i=num.length()-1;i>=0;i--){
    //         int dig = num.charAt(i);
    //         if(dig%2!=0){
    //             return num.substring(0,i+1);
    //         }
    //     }
    //     return "";
    // }

    public String largestOddNumber(String num) {
        int lastDig = num.charAt(num.length()-1)-'0';
        if(lastDig%2!=0)return num;        
        for(int i=num.length()-1;i>=0;i--){
            int dig = num.charAt(i)-'0';
            if(dig%2!=0){
                return num.substring(0,i+1);
            }
        }
        return "";
    }
}
