package GREEDY.DSA;

import java.util.Arrays;

public class G1AssignCookies {
        
    // public int findContentChildren(int[] g, int[] s) {
    //     int cnt=0;
    //     Arrays.sort(g);
    //     Arrays.sort(s);
        // GIVES TLE
        // boolean used[] = new boolean[s.length];
        // Arrays.fill(used,true);
        // for(int i=0;i<g.length;i++){
        //     for(int j=0;j<s.length;j++){
        //         if(used[j] && s[j]>=g[i]){
        //             cnt++;
        //             used[j]=false;
        //             break;
        //         }
        //     }
        // }
        // return cnt;        
    // }
    
    public int findContentChildren(int[] g, int[] s) {
        int cnt=0;
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0,j=0;
        while(i<g.length && j<s.length){
            if(s[j]>=g[i]){
                cnt++;
                i++;
                j++;
            }
            else{
                j++;
            }
        }
        return cnt;
    }


    // LITTLE IMPROVEMENT
    // public int findContentChildren(int[] g, int[] s) {
    //     int cnt=0;
    //     Arrays.sort(g);
    //     Arrays.sort(s);
    //     int i=0,j=0;
    //     while(i<g.length && j<s.length){
    //         if(s[j]>=g[i]){
    //             i++;
    //         }
    //         j++;
    //     }
    //     return i;
    // }
    
}
