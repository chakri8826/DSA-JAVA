import java.util.ArrayList;

public class M6AsteroidCollisions {
        public int[] asteroidCollision(int[] asteroids) {
        ArrayList<Integer> st = new ArrayList<>();
        for(int a:asteroids){
            if(a>0)st.add(a);
            else{
                while(!st.isEmpty() && st.get(st.size()-1)>0 && st.get(st.size()-1)<Math.abs(a)){
                    st.remove(st.size()-1);
                }
                if(!st.isEmpty() && st.get(st.size()-1)==Math.abs(a)){
                    st.remove(st.size()-1);
                }
                else if(st.isEmpty() || st.get(st.size()-1)<0){
                    st.add(a);
                }    
            }
        }
        /*
            int[] arr = new int[st.size()];
            for (int i = 0; i < st.size(); i++) {
                arr[i] = st.get(i);
            }
        */
        return st.stream().mapToInt(i -> i).toArray();
    }
}

