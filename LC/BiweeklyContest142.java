import java.util.*;

class BiweeklyContest142{
    public static int possibleStringCount(String word) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<word.length();i++){
            map.put(word.charAt(i),map.getOrDefault(word.charAt(i),0)+1);
        }  
        int sum = 0;
        for(Map.Entry<Character,Integer> e : map.entrySet()){
            if(e.getValue()>1){
                sum+=e.getValue()-1;
            }
            else{
                sum+=1;
            }
        }
        return sum;
    }


    public int rec(int n, int k, int[][] stayScore, int[][] travelScore){
        if(k<0) return 0;
        int stay = stayScore[k][n]+rec(n,k-1,stayScore,travelScore);
        int travel = Integer.MIN_VALUE;
        for(int v=0;v<travelScore.length;v++){
            int travelPoints = travelScore[v][n] + rec(v,k-1,stayScore,travelScore);
            travel = Math.max(travel,travelPoints);
        }
        return Math.max(stay,travel);
    }
    public int maxScore(int n, int k, int[][] stayScore, int[][] travelScore) {
        int max=0;
        
        for(int i=0;i<n;i++){
            max = Math.max(max,rec(i,k-1,stayScore,travelScore));
        }
        return max;
    }
    public static void main(String[] args) {
        System.out.println(possibleStringCount("abbcccc"));
    }
}