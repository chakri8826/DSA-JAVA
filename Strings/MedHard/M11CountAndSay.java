public class M11CountAndSay {
//     // public String countAndSay(int n) {
//     //     if(n==1)return "1";
//     //     String prev = countAndSay(n-1);
//     //     StringBuilder sb = new StringBuilder();
//     //     int m=prev.length();
//     //     for(int i=0;i<m;i++){
//     //         int cnt=1;
//     //         while(i+1<m && prev.charAt(i)==prev.charAt(i+1)){
//     //             i++;
//     //             cnt++;
//     //         }
//     //         sb.append(cnt).append(prev.charAt(i));
//     //     }
//     //     return sb.toString();
//     // }

//     public String countAndSay(int n) {
//         String prev="1";
//         for(int k=0;k<n-1;k++){
//             StringBuilder sb = new StringBuilder();
//             int m=prev.length();
//             for(int i=0;i<m;i++){
//                 int cnt=1;
//                 while(i+1<m && prev.charAt(i)==prev.charAt(i+1)){
//                     i++;
//                     cnt++;
//                 }
//                 sb.append(cnt).append(prev.charAt(i));
//             }
//             prev = sb.toString();
//         }
//         return prev;   
//     }

 
    public String countAndSay(int n) {
        if (n <= 0) return "";

        String current = "1";

        for (int i = 2; i <= n; i++) {
            StringBuilder next = new StringBuilder();
            int j = 0;
            int len = current.length();

            while (j < len) {
                char ch = current.charAt(j);
                int count = 1;

                while (j + 1 < len && current.charAt(j) == current.charAt(j + 1)) {
                    j++;
                    count++;
                }

                next.append(count).append(ch);
                j++;
            }

            current = next.toString();  // Prepare for next iteration
        }

        return current;
    }
}
