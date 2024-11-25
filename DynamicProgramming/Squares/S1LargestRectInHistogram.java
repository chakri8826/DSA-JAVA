import java.util.*;
public class S1LargestRectInHistogram {
    // public static void main(String[] args) {
    //     int heights[] = {2,1,5,6,2,3,1};
    //     int n = heights.length;
    //     int ls[] = new int[n];
    //     Stack<Integer> s = new Stack<>();
    //     ls[0]=0;
    //     s.push(0);
    //     for(int i=1;i<n;i++){
    //         if(heights[s.peek()]<heights[i]){
    //             ls[i]=s.peek()+1;
    //             s.push(i);
    //         }
    //         else if(heights[s.peek()]>=heights[i]){
    //             while(!s.isEmpty() && heights[s.peek()]>=heights[i]){
    //                 s.pop();
    //             }
    //             if(s.isEmpty()){
    //                 ls[i]=0;
    //                 s.push(i);
    //             }
    //             else{
    //                 ls[i]=s.peek()+1;
    //                 s.push(i);
    //             }
    //         }
    //     }


    //     int rs[] = new int[n];
    //     Stack<Integer> s1 = new Stack<>();
    //     rs[n-1]=n-1;
    //     s1.push(n-1);
    //     for(int i=n-1;i>=0;i--){
    //         if(heights[s1.peek()]<heights[i]){
    //             rs[i]=s1.peek()-1;
    //             s1.push(i);
    //         }
    //         else if(heights[s1.peek()]>=heights[i]){
    //             while(!s1.isEmpty() && heights[s1.peek()]>=heights[i]){
    //                 s1.pop();
    //             }
    //             if(s1.isEmpty())
    //                 rs[i]=n-1;
    //                 s1.push(i);
    //             }
    //             else{
    //                 rs[i]=s1.peek()-1;
    //                 s1.push(i);
    //             }
    //         }
    //     }


    //     int maxi=0;
    //     for(int i=0;i<n;i++){
    //         int val  = (rs[i]-ls[i]+1) * heights[i];
    //         maxi = Math.max(maxi,val);
    //     }
    //     System.out.println(maxi);

    // }


    //DECRESING NOOF LINES 
    public static void main(String[] args) {
        int heights[] = {2,1,5,6,2,3,1};
        int n = heights.length;
        int ls[] = new int[n];
        Stack<Integer> s = new Stack<>();
        ls[0]=0;
        s.push(0);
        for(int i=1;i<n;i++){
            while(!s.isEmpty() && heights[s.peek()]>=heights[i]){
                s.pop();
            }
            if(s.isEmpty()) ls[i]=0;
            else  ls[i]=s.peek()+1;   
            s.push(i);
        }

        while(!s.isEmpty()) s.pop();  

        int maxi=0;
        int rs[] = new int[n];
        rs[n-1]=n-1;
        s.push(n-1);
        for(int i=n-1;i>=0;i--){
            while(!s.isEmpty() && heights[s.peek()]>=heights[i]){
                s.pop();
            }
            if(s.isEmpty()) rs[i]=n-1;
            else  rs[i]=s.peek()-1;
            maxi = Math.max(maxi,(rs[i]-ls[i]+1) * heights[i]);
            s.push(i);
        }


        System.out.println(maxi);
    }
}

