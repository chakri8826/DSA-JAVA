import java.util.HashSet;
class S7ThreeChars{
    //brute chakri
    // public static int numberOfSubstrings(String s) {
    //     int n = s.length(),res=0;
    //     for(int i=0;i<n;i++){
    //         HashSet<Character> set = new HashSet<>();
    //         for(int j=i;j<n;j++){
    //             set.add(s.charAt(j));
    //             if(set.size()==3) res++;
    //         }
    //     }
    //     return res;
    // }


    //opti chakri
    // public static int numberOfSubstrings(String s) {
    //     int l=0,r=0,n=s.length(),res=0;
    //     HashMap<Character,Integer> map = new HashMap<>();
    //     while(r<n){
    //         map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)+1);
    //         while(map.size()==3){
    //             res+=(n-r);
    //             map.put(s.charAt(l),map.get(s.charAt(l))-1);
    //             if(map.get(s.charAt(l))==0){
    //                 map.remove(s.charAt(l));
    //             }
    //             l++;
    //         }
    //         r++;
    //     }   
    //     return res;
    // }


    // New trick try Chakri  takes O(N)+Hashset time and space
    // public static int numberOfSubstrings(String s){
    //     int a=-1,b=-1,c=-1,res=0,i=0,n=s.length();
    //     while(i<n){
    //         if(s.charAt(i)=='a'){
    //             a=i;
    //         }
    //         if(s.charAt(i)=='b'){
    //             b=i;
    //         }
    //         if(s.charAt(i)=='c'){
    //             c=i;
    //         }
    //         HashSet<Character> set = new HashSet<>();
    //         if(a!=-1) set.add(s.charAt(a));
    //         if(b!=-1) set.add(s.charAt(b));
    //         if(c!=-1) set.add(s.charAt(c));
    //         if(set.size()==3){
    //             int min = Math.min(Math.min(a,b),c);
    //             res+=min+1;
    //         }
    //         i++;
    //     }
    //     return res;
    // }


    //NEW TRICK MAIN IMPLEMENTATION  takes O(N) no  Hashset
    public static int numberOfSubstrings(String s){
        int n = s.length(),cnt=0;
        int lastSeen[] = {-1,-1,-1};
        for(int i=0;i<n;i++){
            lastSeen[s.charAt(i)-'a'] = i;
            cnt = cnt + (1+Math.min(Math.min(lastSeen[0],lastSeen[1]),lastSeen[2]));
        }
        return cnt;
    }
    public static void main(String[] args) {
        System.out.println(numberOfSubstrings("abcabc"));
    }
}
